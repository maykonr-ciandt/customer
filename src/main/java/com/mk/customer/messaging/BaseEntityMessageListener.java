package com.mk.customer.messaging;

import com.mk.customer.messaging.kafka.KafkaQualifier;
import com.mk.customer.messaging.kafka.MessageOperation;
import com.mk.customer.model.base.BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;

@Slf4j
@Component
public class BaseEntityMessageListener {

    @Autowired
    @KafkaQualifier
    private Producer producer;

    @PostPersist
    private void postPersist(final BaseEntity baseEntity) {
        this.produceMessage(baseEntity, MessageOperation.INSERT);
    }

    @PostUpdate
    private void postUpdate(final BaseEntity baseEntity) {
        this.produceMessage(baseEntity, MessageOperation.UPDATE);
    }

    @PostRemove
    private void postRemove(final BaseEntity baseEntity) {
        this.produceMessage(baseEntity, MessageOperation.DELETE);
    }

    private void produceMessage(final BaseEntity baseEntity, final MessageOperation messageOperation) {
        if (baseEntity instanceof BaseEntityMessage) {
            final BaseEntityMessage baseEntityMessage = (BaseEntityMessage) baseEntity;
            final Message message = Message.builder()
                    .Operation(messageOperation)
                    .version(baseEntityMessage.getVersion())
                    .object(baseEntity)
                    .build();
            this.producer.sendMessage(baseEntityMessage.getTopicName(), message);
        }
    }
}

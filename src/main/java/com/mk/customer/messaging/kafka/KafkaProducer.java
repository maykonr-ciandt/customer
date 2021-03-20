package com.mk.customer.messaging.kafka;

import com.mk.customer.messaging.Message;
import com.mk.customer.messaging.Producer;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Component
public class KafkaProducer implements Producer {

    private final KafkaTemplate<String, Message> producer;

    @Autowired
    public KafkaProducer(final KafkaTemplate<String, Message> producer) {
        this.producer = producer;
    }

    @Override
    public void sendMessage(final String topic, final Message message) {
        final ProducerRecord<String, Message> record = new ProducerRecord<>(topic, message);
        record.headers().add(new RecordHeader("version", message.getVersion().getBytes()));
        record.headers().add(new RecordHeader("op", message.getOperation().toString().getBytes()));
        record.headers().add(new RecordHeader("origin", this.getClass().getCanonicalName().getBytes()));

        this.producer.send(record).addCallback(
                new ListenableFutureCallback<SendResult<String, Message>>() {
                    @Override
                    public void onSuccess(final SendResult<String, Message> stringMessageSendResult) {
                        log.info("Message sent to topic {}. (Operation {} | Partition {} | Offset {})",
                                topic,
                                message.getOperation(),
                                stringMessageSendResult.getRecordMetadata().partition(),
                                stringMessageSendResult.getRecordMetadata().offset());
                    }

                    @Override
                    public void onFailure(final Throwable throwable) {
                        log.error("unable to send message = {}", message, throwable);
                    }
                });
    }
}

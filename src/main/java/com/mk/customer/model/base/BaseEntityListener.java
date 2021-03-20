package com.mk.customer.model.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;

@Slf4j
@Configuration
public class BaseEntityListener {

    @PostPersist
    private void postPersist(final BaseEntity baseEntity) {
        log.info("Creating entity {} with id {}", baseEntity.getClass().getSimpleName(), baseEntity.getId());
    }

    @PostUpdate
    private void postUpdate(final BaseEntity baseEntity) {
        log.info("Updating entity {} with id {}", baseEntity.getClass().getSimpleName(), baseEntity.getId());
    }

    @PostRemove
    private void postRemove(final BaseEntity baseEntity) {
        log.info("removing entity {} with id {}", baseEntity.getClass().getSimpleName(), baseEntity.getId());
    }
}

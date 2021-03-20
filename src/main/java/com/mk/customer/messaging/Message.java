package com.mk.customer.messaging;

import com.mk.customer.messaging.kafka.MessageOperation;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class Message implements Serializable {
    private String version;
    private MessageOperation Operation;
    private Object object;
}

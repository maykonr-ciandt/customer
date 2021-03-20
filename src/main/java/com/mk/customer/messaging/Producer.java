package com.mk.customer.messaging;

public interface Producer {

    void sendMessage(final String topic, final Message message);
}

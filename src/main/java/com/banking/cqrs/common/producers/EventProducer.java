package com.banking.cqrs.common.producers;

import com.banking.cqrs.common.events.BaseEvent;

public interface EventProducer {
    /**
     * canal va a producir el mensaje topic
     */
    void producer(String topic, BaseEvent event);
}

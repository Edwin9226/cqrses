package com.banking.cqrs.common.infrastructure;

import com.banking.cqrs.common.events.BaseEvent;

import java.util.List;

public interface EventStore {
    /**
     * almacenar los eventos por el agregate ID
     * @param aggregateId
     * @param events
     * @param expectedVersion
     */
    void saveEvents(String aggregateId, Iterable<BaseEvent> events, int expectedVersion);

    /**
     * devuelva la lista de eventos por el agregateID
     * @param aggregateId
     * @return
     */
    List<BaseEvent> getEvent(String aggregateId);
}

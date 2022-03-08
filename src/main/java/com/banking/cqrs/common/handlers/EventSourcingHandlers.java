package com.banking.cqrs.common.handlers;

import com.banking.cqrs.common.domains.AgregateRoot;

public interface EventSourcingHandlers<T> {
    void save(AgregateRoot agregate);
    T getById(String Id);
}

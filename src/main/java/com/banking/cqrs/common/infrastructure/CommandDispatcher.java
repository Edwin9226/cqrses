package com.banking.cqrs.common.infrastructure;

import com.banking.cqrs.common.commands.BaseCommand;
import com.banking.cqrs.common.commands.CommandHandlerMethod;

public interface CommandDispatcher {
    <T extends BaseCommand> void registerHandler(Class<T>type, CommandHandlerMethod<T> handler);
    void send(BaseCommand command);
}

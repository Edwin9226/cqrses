package com.banking.cqrs.common.commands;

@FunctionalInterface
public interface CommandHandlerMethod <T extends BaseCommand> {
    void handle(T command);
}

package com.banking.cqrs.common.exceptions;

public class AggregateNotFoundException extends RuntimeException{
    public AggregateNotFoundException(String message){
        super(message);
    }
}

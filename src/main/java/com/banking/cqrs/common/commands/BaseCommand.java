package com.banking.cqrs.common.commands;

import com.banking.cqrs.common.messages.Message;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class BaseCommand extends Message {

     public BaseCommand(String id){
         super(id);
     }

}

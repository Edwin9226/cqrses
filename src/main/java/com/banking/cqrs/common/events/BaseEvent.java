package com.banking.cqrs.common.events;

import com.banking.cqrs.common.messages.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class BaseEvent extends Message {

    private int version;

    /**
     * /**
     *  * La version es importante por que cada vez que
     *  * volvamos a ejecutar el evento necesitaremos recrear
     *  *el agregate ademàs, que nos permitirà implementar un control de
     *  * concurrencia.
     *  * /
     */
 }

package com.banking.cqrs.common.events;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document(collection = "eventStore")
public class EventModel {
    @Id
    private String id;
    private Date timeStamp;
    //lista de events que se deben entregar en un agregate
    private String aggregateIdentifier;
    private String aggregateType;
    private int version;
    private  String eventType;
    //importante propiedad que capture el evento relacionado a este bit model
    // descripcion de la operacion que tu quieres almacenar.
    private BaseEvent eventData;



}

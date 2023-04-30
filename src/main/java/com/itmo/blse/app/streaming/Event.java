package com.itmo.blse.app.streaming;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.UUID;

public class Event<T, V> {

    String eventId;
    LocalDateTime createdAt;
    String routingKey;
    String action;
    V data;


    public Event(T object, EventDataConverter<T,V> dataProvider, String routingKey, String action){
        this.routingKey = routingKey;
        this.action = action;
        this.data = dataProvider.toEventData(object);
        this.eventId = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

}

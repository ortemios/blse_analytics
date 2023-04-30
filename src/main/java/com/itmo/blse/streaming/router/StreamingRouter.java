package com.itmo.blse.streaming.router;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itmo.blse.streaming.event.Event;
import com.itmo.blse.streaming.event.TeamCreatedEvent;
import com.itmo.blse.streaming.handler.EventHandler;
import com.itmo.blse.streaming.handler.TeamCreatedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;


@Service
@SuppressWarnings("all")
public class StreamingRouter {

    @Autowired
    @Handler(TeamCreatedEvent.class)
    TeamCreatedHandler teamCreatedHandler;

    @JmsListener(destination = "analytics.stats")
    public void onMessage(String message) throws JsonProcessingException, IllegalAccessException {

        ObjectMapper mapper = new ObjectMapper();

        Event event = mapper.readValue(message, Event.class);
        System.out.println(event.getClass().getSimpleName() + " " + message);
        EventHandler handler = getEventHandler(event);
        if (handler != null) {
            handler.handle(event);
        }
    }

    private EventHandler<?> getEventHandler(Event event) throws IllegalAccessException {
        for (Field field : getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Handler.class)) {
                Handler annotation = field.getAnnotation(Handler.class);
                if (annotation.value().equals(event.getClass())) {
                    return (EventHandler<?>) field.get(this);
                }
            }
        }
        return null;
    }

}
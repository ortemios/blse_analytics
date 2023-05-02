package com.itmo.blse.streaming.router;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itmo.blse.StreamingErrorRepository;
import com.itmo.blse.model.StreamingError;
import com.itmo.blse.streaming.event.*;
import com.itmo.blse.streaming.handler.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Field;


@Service
@SuppressWarnings("all")
public class StreamingRouter {

    @Autowired
    @Handler(TeamCreatedEvent.class)
    TeamCreatedHandler teamCreatedHandler;

    @Autowired
    @Handler(TournamentCreatedEvent.class)
    TournamentCreatedHandler tournamentCreatedHandler;

    @Autowired
    @Handler(GamePlayedEvent.class)
    GamePlayedHandler gamePlayedHandler;

    @Autowired
    @Handler(GameDroppedEvent.class)
    GameDroppedHandler gameDroppedHandler;

    @Autowired
    @Handler(MatchUpdatedEvent.class)
    MatchUpdatedHandler matchUpdatedHandler;


    @Autowired
    StreamingErrorRepository streamingErrorRepository;

    @JmsListener(destination = "${rabbitmq.queue}")
    @Transactional
    public void onMessage(String message) throws JsonProcessingException, IllegalAccessException {

        ObjectMapper mapper = new ObjectMapper();
        Event event = null;
        try {
            event = mapper.readValue(message, Event.class);
            System.out.println(event.getClass().getSimpleName() + " " + message);
            EventHandler handler = getEventHandler(event);
            if (handler != null) {
                handler.handle(event);
            }
        }
        catch (Throwable e){
            handleError(e, event, message);
        }


    }

    private void handleError(Throwable error, Event event, String message){
        StreamingError.StreamingErrorBuilder builder = StreamingError.builder()
                .errorText(error.getMessage())
                .message(message);
        if (event != null){
            builder.eventAction(event.getAction()).eventId(event.getEventId());
        }
        streamingErrorRepository.save(builder.build());
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
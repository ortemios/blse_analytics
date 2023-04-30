package com.itmo.blse.streaming.handler;

import com.itmo.blse.streaming.event.Event;

public interface EventHandler<T extends Event> {

    void handle(T event);
}

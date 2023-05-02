package com.itmo.blse.streaming.router;

import com.itmo.blse.streaming.event.Event;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Handler {
    Class<? extends Event> value();
}
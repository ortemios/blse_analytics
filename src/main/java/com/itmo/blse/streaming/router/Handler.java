package com.itmo.blse.streaming.router;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Handler {
    Class<?> value();
}
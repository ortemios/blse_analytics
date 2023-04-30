package com.itmo.blse.app.streaming;

public interface EventDataConverter<T,V>{
    V toEventData(T object);
}

package com.k1m743hyun.springeventexercise.data.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class UserEvent extends ApplicationEvent {

    private final String name;

    public UserEvent(Object source, String name) {
        super(source);
        this.name = name;
    }
}

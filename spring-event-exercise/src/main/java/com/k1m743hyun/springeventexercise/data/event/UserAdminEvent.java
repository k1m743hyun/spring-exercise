package com.k1m743hyun.springeventexercise.data.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class UserAdminEvent extends ApplicationEvent {

    private final String name;

    public UserAdminEvent(Object source, String name) {
        super(source);
        this.name = name;
    }
}

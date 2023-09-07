package com.k1m743hyun.springeventexercise.service;

import com.k1m743hyun.springeventexercise.data.dto.UserRequest;
import com.k1m743hyun.springeventexercise.data.entity.User;
import com.k1m743hyun.springeventexercise.data.event.UserEvent;
import com.k1m743hyun.springeventexercise.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;
    private final ApplicationEventPublisher publisher;

    public void create(UserRequest userRequest) {

        User user = new User(
                userRequest.getName(),
                userRequest.getEmail(),
                userRequest.getPhoneNumber()
        );
        repository.save(user);

        publisher.publishEvent(new UserEvent(this, user.getName()));
    }
}

package com.k1m743hyun.springeventexercise.service;

import com.k1m743hyun.springeventexercise.data.dto.UserRequest;
import com.k1m743hyun.springeventexercise.data.entity.User;
import com.k1m743hyun.springeventexercise.data.event.UserAdminEvent;
import com.k1m743hyun.springeventexercise.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

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

        publisher.publishEvent(new UserAdminEvent(this, user.getName()));
    }
}

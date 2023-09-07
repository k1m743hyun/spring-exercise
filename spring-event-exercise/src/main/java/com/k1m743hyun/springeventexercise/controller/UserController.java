package com.k1m743hyun.springeventexercise.controller;

import com.k1m743hyun.springeventexercise.data.dto.UserRequest;
import com.k1m743hyun.springeventexercise.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService service;

    @PostMapping("/save")
    public void create(@RequestBody UserRequest request) {
        service.create(request);
    }
}

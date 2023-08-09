package com.k1m743hyun.springsecurityexercise.controller;

import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/")
    public ResponseEntity<Map<String, String>> home() {
        return ResponseEntity.ok().body(Map.of("path", "/"));
    }

    @GetMapping("/api/api1")
    public ResponseEntity<Map<String, String>> api1(@AuthenticationPrincipal User principal) {
//        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return ResponseEntity.ok().body(Map.of("path", principal.getName() + principal.getPassword()));
    }

    @GetMapping("/api/api2")
    public ResponseEntity<Map<String, String>> api2() {
        return ResponseEntity.ok().body(Map.of("path", "/api/api2"));
    }
}

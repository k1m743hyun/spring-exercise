package com.k1m743hyun.customerrorpage.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorldController {

    @GetMapping("/world")
    public ResponseEntity<String> printWorld(HttpServletRequest request) {
        return ResponseEntity.ok().body("world controller");
    }
}

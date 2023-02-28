package com.k1m743hyun.springsecurity.controller;

import com.k1m743hyun.springsecurity.dto.XSSRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class XSSRequestController {

    @PostMapping("/xss/dto")
    public String insertDto(@RequestBody XSSRequestDto requestDto) {

        log.info("requestDto = {}", requestDto);

        return requestDto.getContent();
    }

    @PostMapping("/xss/form")
    public @ResponseBody String insertForm(XSSRequestDto requestDto) {

        log.info("requestDto = {}", requestDto);

        return requestDto.getContent();
    }
}

package com.k1m743hyun.springsecurity.controller;

import com.k1m743hyun.springsecurity.dto.XSSRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class XSSRequestControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void xss() {

        // given
        String content = "<li>content</li>";
        String expected = "&lt;li&gt;content&lt;/li&gt;";

        // when
        ResponseEntity<XSSRequestDto> response = restTemplate.postForEntity(
            "/xss",
            new XSSRequestDto(content),
            XSSRequestDto.class
        );

        log.info(">>>>>>>>>> {}", response);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getContent()).isEqualTo(expected);
    }
}
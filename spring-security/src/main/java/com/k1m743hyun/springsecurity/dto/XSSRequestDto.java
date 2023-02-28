package com.k1m743hyun.springsecurity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class XSSRequestDto {

    private String content;

    public XSSRequestDto(String content) {
        this.content = content;
    }
}

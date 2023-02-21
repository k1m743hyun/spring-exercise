package com.k1m743hyun.utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CLog {

    public void info(String... params) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[").append("INFO").append("]");

        for (String param : params) {
            stringBuilder.append("[").append(param).append("]");
        }

        log.info(stringBuilder.toString());
    }
}
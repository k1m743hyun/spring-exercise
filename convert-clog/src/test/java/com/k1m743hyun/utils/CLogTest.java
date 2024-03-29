package com.k1m743hyun.utils;

import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class CLogTest {

    @Test
    void CLogTest() {
        CLog CLog = new CLog();
        CLog.info("id:" + 1, "name:" + "hello", "group:" + null);
    }

    @Test
    void convertCLogTest() {
        log.info("{}", List.of("id:" + 1, "name:" + "hello", "group:" + null).toString());
    }

    @Test
    void convertCLogNullTest() {
        log.info("{}", List.of("id:" + 1, "name:" + "hello", "group:" + null, null).toString());
    }

    @Test
    void convertCLogStringNullTest() {
        String param = null;
        log.info("{}", List.of("id:" + 1, "name:" + "hello", "group:" + null, param).toString());
    }

    @Test
    void convertCLogArrayNullTest() {
        log.info("{}", Arrays.asList("id:" + 1, "name:" + "hello", "group:" + null, null).toString());
    }

    @Test
    void convertCLogArrayStringNullTest() {
        String param = null;
        log.info("{}", Arrays.asList("id:" + 1, "name:" + "hello", "group:" + null, param).toString());
    }
}
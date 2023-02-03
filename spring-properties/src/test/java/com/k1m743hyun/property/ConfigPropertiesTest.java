package com.k1m743hyun.property;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@ComponentScan(basePackages = "com.k1m743hyun")
class ConfigPropertiesTest {

    @Autowired
    ConfigProperties configProperties;

    @Test
    void getPropertyTest() {
        List<String> pushgw = configProperties.getGw();
        System.out.println(pushgw);
    }
}
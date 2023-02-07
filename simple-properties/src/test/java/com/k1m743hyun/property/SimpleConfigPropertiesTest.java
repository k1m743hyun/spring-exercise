package com.k1m743hyun.property;

import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@EnableConfigurationProperties(SimpleConfigProperties.class)
class SimpleConfigPropertiesTest {

    @Resource
    SimpleConfigProperties simpleConfigProperties;

    @Test
    void BasePropertyTest() {
        String path = simpleConfigProperties.base.path;
        System.out.println(">>>>> " + path);
        assertThat(path).isNotNull();
    }

    @Test
    void SubEtcPropertyTest() {
        String path = simpleConfigProperties.sub.etc.path;
        System.out.println(">>>>> " + path);
        assertThat(path).isNotNull();
    }

    @Test
    void SubStatusPropertyTest() {
        String path = simpleConfigProperties.sub.status.path;
        System.out.println(">>>>> " + path);
        assertThat(path).isNotNull();
    }

    @Test
    void SubBatchPropertyTest() {
        String path = simpleConfigProperties.sub.batch.path;
        System.out.println(">>>>> " + path);
        assertThat(path).isNotNull();
    }

    @Test
    void SubBatchMetaPropertyTest() {
        String path = simpleConfigProperties.sub.batch.meta.path;
        System.out.println(">>>>> " + path);
        assertThat(path).isNotNull();
    }

    @Test
    void SubBatchMonitorPropertyTest() {
        String path = simpleConfigProperties.sub.batch.monitor.path;
        System.out.println(">>>>> " + path);
        assertThat(path).isNotNull();
    }
}
package com.k1m743hyun.corespring.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.context.annotation.ComponentScan.*;

public class ComponentFilterAppConfigTest {

    @Test
    void filterScan() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA = applicationContext.getBean("beanA", BeanA.class);
        assertThat(beanA).isNotNull();

        assertThrows(
            NoSuchBeanDefinitionException.class,
            () -> applicationContext.getBean("beanB", BeanB.class));
    }

    @ComponentScan(
        // includeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
        includeFilters = @Filter(classes = MyIncludeComponent.class),
        // excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class)
        excludeFilters = @Filter(classes = MyExcludeComponent.class)
    )
    @Configuration
    static class ComponentFilterAppConfig {

    }
}

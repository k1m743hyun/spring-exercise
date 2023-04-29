package com.k1m743hyun.corespring.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    void singletonBeanFind() {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SingletonBean.class);

        SingletonBean bean1 = applicationContext.getBean(SingletonBean.class);
        System.out.println("bean1 = " + bean1);

        SingletonBean bean2 = applicationContext.getBean(SingletonBean.class);
        System.out.println("bean2 = " + bean2);

        assertThat(bean1).isSameAs(bean2);

        applicationContext.close();
    }

    @Scope()
    static class SingletonBean {

        @PostConstruct
        public void init() {
            System.out.println("SingletonBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("SingletonBean.destroy");
        }
    }
}

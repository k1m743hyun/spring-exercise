package com.k1m743hyun.corespring.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeTest {

    @Test
    void prototypeBeanFind() {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PrototypeBean.class);

        System.out.println("find bean1");
        PrototypeBean bean1 = applicationContext.getBean(PrototypeBean.class);
        System.out.println("bean1 = " + bean1);

        System.out.println("find bean2");
        PrototypeBean bean2 = applicationContext.getBean(PrototypeBean.class);
        System.out.println("bean1 = " + bean2);

        assertThat(bean1).isNotSameAs(bean2);

        bean1.destroy();
        bean2.destroy();
        applicationContext.close();
    }

    @Scope("prototype")
    static class PrototypeBean {

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destory");
        }
    }
}

package com.k1m743hyun.corespring.beanFind;

import com.k1m743hyun.corespring.AppConfig;
import com.k1m743hyun.corespring.member.MemberService;
import com.k1m743hyun.corespring.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회하기")
    void findBeanByName() {

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        // System.out.println("memberService = " + memberService);
        // System.out.println("memberService.getClass() = " + memberService.getClass());
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회하기 X")
    void findBeanByNameX() {

        // applicationContext.getBean("xxxx", MemberService.class);
        //MemberService xxxx = applicationContext.getBean("xxxx", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class,
            () -> applicationContext.getBean("xxxx", MemberService.class));
    }

    @Test
    @DisplayName("이름없이 타입으로만 조회하기")
    void findBeanByType() {

        MemberService memberService = applicationContext.getBean(MemberService.class);

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회하기")
    void findBeanByType2() {

        MemberServiceImpl memberServiceImpl = applicationContext.getBean(MemberServiceImpl.class);

        assertThat(memberServiceImpl).isInstanceOf(MemberServiceImpl.class);
    }
}
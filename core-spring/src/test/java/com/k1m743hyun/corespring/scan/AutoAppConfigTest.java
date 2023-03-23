package com.k1m743hyun.corespring.scan;

import com.k1m743hyun.corespring.AutoAppConfig;
import com.k1m743hyun.corespring.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {

    @Test
    void basicScan() {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = applicationContext.getBean(MemberService.class);

        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}

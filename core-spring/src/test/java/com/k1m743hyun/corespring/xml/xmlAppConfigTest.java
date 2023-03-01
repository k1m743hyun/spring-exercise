package com.k1m743hyun.corespring.xml;

import com.k1m743hyun.corespring.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class xmlAppConfigTest {

    @Test
    void xmlAppContext() {

        // given
        GenericXmlApplicationContext genericXmlApplicationContext = new GenericXmlApplicationContext("appConfig.xml");

        // when
        MemberService memberService = genericXmlApplicationContext.getBean("memberService", MemberService.class);

        // then
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }
}

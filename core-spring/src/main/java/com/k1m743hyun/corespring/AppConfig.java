package com.k1m743hyun.corespring;

import com.k1m743hyun.corespring.discount.DiscountPolicy;
import com.k1m743hyun.corespring.discount.RateDiscountPolicy;
import com.k1m743hyun.corespring.member.MemberRepository;
import com.k1m743hyun.corespring.member.MemberService;
import com.k1m743hyun.corespring.member.MemberServiceImpl;
import com.k1m743hyun.corespring.member.MemoryMemberRepository;
import com.k1m743hyun.corespring.order.OrderService;
import com.k1m743hyun.corespring.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {

        System.out.println("Call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {

        System.out.println("Call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {

        System.out.println("Call AppConfig.orderService");
        //return new OrderServiceImpl(memberRepository(), discountPolicy());
        return null;
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}

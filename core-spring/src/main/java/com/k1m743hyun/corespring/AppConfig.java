package com.k1m743hyun.corespring;

import com.k1m743hyun.corespring.discount.DiscountPolicy;
import com.k1m743hyun.corespring.discount.FixDiscountPolicy;
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

    // public MemberService memberService() {
    //     return new MemberServiceImpl(new MemoryMemberRepository());
    // }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    // public OrderService orderService() {
    //     return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    // }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}

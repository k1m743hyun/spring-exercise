package com.k1m743hyun.corespring;

import com.k1m743hyun.corespring.member.Grade;
import com.k1m743hyun.corespring.member.Member;
import com.k1m743hyun.corespring.member.MemberService;
import com.k1m743hyun.corespring.member.MemberServiceImpl;
import com.k1m743hyun.corespring.order.Order;
import com.k1m743hyun.corespring.order.OrderService;
import com.k1m743hyun.corespring.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

        // MemberService memberService = new MemberServiceImpl();
        // OrderService orderService = new OrderServiceImpl();

        // AppConfig appConfig = new AppConfig();
        // MemberService memberService = appConfig.memberService();
        // OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);
        //System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}

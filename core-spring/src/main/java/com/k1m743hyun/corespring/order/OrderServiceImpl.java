package com.k1m743hyun.corespring.order;

import com.k1m743hyun.corespring.discount.DiscountPolicy;
import com.k1m743hyun.corespring.discount.FixDiscountPolicy;
import com.k1m743hyun.corespring.discount.RateDiscountPolicy;
import com.k1m743hyun.corespring.member.Member;
import com.k1m743hyun.corespring.member.MemberRepository;
import com.k1m743hyun.corespring.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@Component("service")
public class OrderServiceImpl implements OrderService {

    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    private MemberRepository memberRepository;
//    private final MemberRepository memberRepository;
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private DiscountPolicy discountPolicy;
//    private final DiscountPolicy discountPolicy;

    // 생성자 주입
    //public OrderServiceImpl() {}

    // new OrderServiceImpl(memberRepository, discountPolicy);
    //@Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        //System.out.println("memberRepository = " + memberRepository);
        //System.out.println("discountPolicy = " + discountPolicy);
        //System.out.println("1. OrderServiceImpl.OrderServiceImpl");
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // 수정자 주입
//    @Autowired(required = false)
//    public void setMemberRepository(MemberRepository memberRepository) {
//        System.out.println("memberRepository = " + memberRepository);
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        System.out.println("discountPolicy = " + discountPolicy);
//        this.discountPolicy = discountPolicy;
//    }

    // 필드 주입
//    @Autowired private MemberRepository memberRepository;
//    @Autowired private DiscountPolicy discountPolicy;
//
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }

    // 일반 메서드 주입
    @Autowired
    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

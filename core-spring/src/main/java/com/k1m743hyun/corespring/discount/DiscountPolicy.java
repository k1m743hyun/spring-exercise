package com.k1m743hyun.corespring.discount;

import com.k1m743hyun.corespring.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}

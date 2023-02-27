package com.k1m743hyun.corespring.discount;

import com.k1m743hyun.corespring.member.Grade;
import com.k1m743hyun.corespring.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private final int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {

        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}

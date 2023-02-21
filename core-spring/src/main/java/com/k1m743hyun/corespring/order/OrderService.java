package com.k1m743hyun.corespring.order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);
}

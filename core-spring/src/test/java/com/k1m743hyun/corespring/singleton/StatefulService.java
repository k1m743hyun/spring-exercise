package com.k1m743hyun.corespring.singleton;

public class StatefulService {

//    private int price; // 상태를 유지하는 필드 10000 => 20000
//
//    public void order(String name, int price) {
//
//        System.out.println("name = " + name);
//        System.out.println("price = " + price);
//        this.price = price; // 문제가 되는 코드
//    }

    public int order(String name, int price) {

        System.out.println("name = " + name);
        System.out.println("price = " + price);
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}

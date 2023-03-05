package com.k1m743hyun.corespring.singleton;

public class SingletonService {

    // static 영역에 객체를 짝 1개만 생성함
    private static final SingletonService instance = new SingletonService();

    // 생성자를 private으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막음
    private SingletonService() {}

    // public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용함
    public static SingletonService getInstance() {
        return instance;
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}

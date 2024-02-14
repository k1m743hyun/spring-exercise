package com.k1m743hyun.springeventexercise.listener;

import com.k1m743hyun.springeventexercise.data.event.UserEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderServiceEventListener implements ApplicationListener<UserEvent> {

    @Override
    public void onApplicationEvent(UserEvent event) {
        log.info("Order Service: {}님, 이제 회원 주문으로 가능합니다.", event.getName());
    }
}

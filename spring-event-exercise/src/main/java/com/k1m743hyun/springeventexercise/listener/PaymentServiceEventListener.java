package com.k1m743hyun.springeventexercise.listener;

import com.k1m743hyun.springeventexercise.data.event.UserEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentServiceEventListener {

    @EventListener
    public void getEvent(UserEvent event) {
        log.info("Payment Service: {}님, 간편 결제 서비스를 이용할 수 있습니다.", event.getName());
    }
}

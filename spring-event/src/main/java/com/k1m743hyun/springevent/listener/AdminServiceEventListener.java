package com.k1m743hyun.springeventexercise.listener;

import com.k1m743hyun.springeventexercise.data.event.UserEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AdminServiceEventListener implements ApplicationListener<UserEvent> {

    @Override
    public void onApplicationEvent(UserEvent event) {
        log.info("Admin Service: {}님이 회원으로 등록이 완료되었습니다.", event.getName());
    }
}

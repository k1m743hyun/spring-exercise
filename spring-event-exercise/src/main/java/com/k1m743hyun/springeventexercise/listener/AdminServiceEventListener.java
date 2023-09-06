package com.k1m743hyun.springeventexercise.listener;

import com.k1m743hyun.springeventexercise.data.event.UserAdminEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AdminServiceEventListener implements ApplicationListener<UserAdminEvent> {

    @Override
    public void onApplicationEvent(UserAdminEvent event) {
        log.info("Admin Service: {}님이 회원으로 등록되었습니다.", event.getName());
    }
}

package com.yunjae.websocket.config;

import com.yunjae.websocket.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Configuration
@EnableScheduling
public class SchedulerConfig {

    @Autowired
    SimpMessagingTemplate template;

    @Scheduled(fixedDelay = 3000)
    public void sendAdhocMessages() {
        template.convertAndSend("/topic/user", new UserResponse("Fxed Delay Scheduler"));
    }
}

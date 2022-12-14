package com.kimry.spring_netty_client;

import com.kimry.spring_netty_client.util.SendMessageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
@RequiredArgsConstructor
public class SpringNettyClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringNettyClientApplication.class, args);
    }

    private final SendMessageUtil sendMessageUtil;

    @EventListener(ApplicationReadyEvent.class)
    void run(){
        for(int i=0; i<3;i++){
            sendMessageUtil.sendMessage("localhost",8090,"sendMsg_"+i);
        }
    }

}

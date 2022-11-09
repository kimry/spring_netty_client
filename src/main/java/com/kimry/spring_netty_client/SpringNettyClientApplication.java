package com.kimry.spring_netty_client;

import com.kimry.spring_netty_client.netty.handler.NettyInitializer;
import com.kimry.spring_netty_client.netty.NettyClient;
import io.netty.bootstrap.Bootstrap;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringNettyClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringNettyClientApplication.class, args);
    }

    private final Bootstrap bs;

    @EventListener(ApplicationReadyEvent.class)
    void run(){
        for(int i=0; i<5;i++){
            NettyClient nettyClient = new NettyClient("localhost",8090,"sendMsg_"+i,bs);
            nettyClient.start();
        }
    }

}

package com.kimry.spring_netty_client.util;

import com.kimry.spring_netty_client.netty.NettyClient;
import io.netty.bootstrap.Bootstrap;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendMessageUtil {

    private final Bootstrap bs;

    @Async
    public void sendMessage(String ip, int port, String msg){
        NettyClient nettyClient = new NettyClient(ip,port,msg,bs);
        nettyClient.sendMessage();
    }
}

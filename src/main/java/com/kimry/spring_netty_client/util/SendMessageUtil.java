package com.kimry.spring_netty_client.util;

import com.kimry.spring_netty_client.netty.NettyClient;
import io.netty.bootstrap.Bootstrap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendMessageUtil {

    private final Bootstrap bs;

    public void sendMessage(String ip, int port, String msg){
        NettyClient nettyClient = new NettyClient(ip,port,msg,bs);
        nettyClient.start();
    }
}

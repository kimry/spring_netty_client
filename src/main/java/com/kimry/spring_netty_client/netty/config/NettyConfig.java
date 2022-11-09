package com.kimry.spring_netty_client.netty.config;

import com.kimry.spring_netty_client.netty.handler.NettyInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class NettyConfig {

    private final NettyInitializer nettyInitializer;

    @Bean
    public Bootstrap bs(){
        Bootstrap bs = new Bootstrap();
        bs.group(new NioEventLoopGroup(5))
                .channel(NioSocketChannel.class)
                .handler(nettyInitializer);
        return bs;
    }

}

package com.kimry.spring_netty_client.netty;

import com.kimry.spring_netty_client.netty.handler.NettyInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;

@Slf4j
@RequiredArgsConstructor
public class NettyClient extends Thread{

    private final String ip;
    private final int port;
    private final String msg;
    private final NettyInitializer nettyInitializer;

    @Override
    public void run() {
        Bootstrap bs = new Bootstrap();
        bs.group(new NioEventLoopGroup(5))
                .channel(NioSocketChannel.class)
                .handler(nettyInitializer);

        try {
            ChannelFuture cf = bs.connect(new InetSocketAddress(ip,port)).sync();
            log.info("송신 메세지 : "+msg);
            cf.channel().writeAndFlush(msg.getBytes("EUC-KR"));
            cf.channel().closeFuture().sync();
        }catch(Exception e){
            log.error("NettyClient Error" + e);
        }
    }
}

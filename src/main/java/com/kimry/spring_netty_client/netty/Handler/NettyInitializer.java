package com.kimry.spring_netty_client.netty.Handler;

import com.kimry.spring_netty_client.netty.Handler.decoder.SharableByteArrayDecoder;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NettyInitializer extends ChannelInitializer {

    private ByteArrayEncoder byteArrayEncoder = new ByteArrayEncoder();
    private SharableByteArrayDecoder byteArrayDecoder = new SharableByteArrayDecoder();
    private final NettyHandler nettyHandler;

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast(byteArrayDecoder);
        pipeline.addLast(byteArrayEncoder);
        pipeline.addLast(nettyHandler);
    }
}

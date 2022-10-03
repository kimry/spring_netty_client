package com.kimry.spring_netty_client.netty.Handler.decoder;

import io.netty.channel.ChannelHandler;
import io.netty.handler.codec.bytes.ByteArrayDecoder;

@ChannelHandler.Sharable
public class SharableByteArrayDecoder extends ByteArrayDecoder {
}

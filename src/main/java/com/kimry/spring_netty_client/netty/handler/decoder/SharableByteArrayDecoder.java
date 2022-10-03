package com.kimry.spring_netty_client.netty.handler.decoder;

import io.netty.channel.ChannelHandler;
import io.netty.handler.codec.bytes.ByteArrayDecoder;

@ChannelHandler.Sharable
public class SharableByteArrayDecoder extends ByteArrayDecoder {
}

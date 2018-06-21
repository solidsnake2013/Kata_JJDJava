package com.kata.jjd.chapter2.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.GenericFutureListener;

import java.nio.charset.Charset;

/**
 * Kata_JJDJava
 * <p>
 * Description :
 * <p>
 * Creator :
 *
 * @author Sudao @ Tim Zhang
 * @email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
 * @date: 2018/4/16
 * @time: 16:51
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2018/4/16 16:51
 */
public class NettyService {
    /******* Fields Area *******/

    /******* Construction Area *******/
    public NettyService() {
    }
    /******* GetSet Area ******/

    /******* Method Area *******/

    @ChannelHandler.Sharable
    public static class ABC extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ByteBuf byteBuf = (ByteBuf) msg;
            System.out.println(byteBuf.toString());
            Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("你好", CharsetUtil.UTF_8));
            ctx.write(byteBuf);
            System.out.println(ctx);
            System.out.println(ctx.channel());
        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).
                    addListener(ChannelFutureListener.CLOSE);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        final ABC abc = new ABC();
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(eventLoopGroup).
                channel(NioServerSocketChannel.class).
                localAddress(8011).
                childHandler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(abc);
                    }
                });
        ChannelFuture future = serverBootstrap.bind().sync();
        future.channel().closeFuture().sync();
        eventLoopGroup.shutdownGracefully().sync();


    }

}

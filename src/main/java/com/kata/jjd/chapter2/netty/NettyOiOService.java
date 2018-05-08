package com.kata.jjd.chapter2.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

import java.util.logging.SocketHandler;

/**
 * Kata_JJDJava
 * <p>
 * Description :
 * <p>
 * Creator :
 *
 * @author Sudao @ Tim Zhang
 * @email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
 * @date: 2018/4/24
 * @time: 10:22
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2018/4/24 10:22
 */
public class NettyOiOService {
    /******* Fields Area *******/

    /******* Construction Area *******/
    public NettyOiOService() {
    }
    /******* GetSet Area ******/

    /******* Method Area *******/


    @ChannelHandler.Sharable
    public static class TestInputChannelHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println(ctx);
            ctx.fireChannelRead(msg);
//            ByteBuf byteBuf = (ByteBuf) msg;
//            System.out.println(byteBuf.toString());
//            Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("你好", CharsetUtil.UTF_8));
//            ctx.write(byteBuf);
//            System.out.println(ctx.channel());
        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//            ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).
//                    addListener(ChannelFutureListener.CLOSE);
        }
    }


    @ChannelHandler.Sharable
    public static class TestOutputChannelHandler extends ChannelOutboundHandlerAdapter {
        @Override
        public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
            System.out.println(ctx);
            super.write(ctx, msg, promise);
        }
    }

    public void start() throws InterruptedException {
        final TestInputChannelHandler inputHandler = new TestInputChannelHandler();
        final TestOutputChannelHandler outputHandler = new TestOutputChannelHandler();
        NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.localAddress(8011);
        serverBootstrap.group(nioEventLoopGroup);
        serverBootstrap.channel(NioServerSocketChannel.class);
        serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {

            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast("1", inputHandler);
                ch.pipeline().addLast("2", outputHandler);
            }
        });
        ChannelFuture sync = serverBootstrap.bind().sync();
        sync.channel().closeFuture().sync();
        nioEventLoopGroup.shutdownGracefully().sync();
    }


    public static void main(String[] args) throws InterruptedException {
        new NettyOiOService().start();

    }

}

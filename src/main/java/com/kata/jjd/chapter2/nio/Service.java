package com.kata.jjd.chapter2.nio;

import com.kata.jjd.kit.Reader;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Kata_JJDJava
 * <p>
 * Description :
 * <p>
 * Creator :
 *
 * @author Sudao @ Tim Zhang
 * @email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
 * @date: 2018/4/14
 * @time: 21:56
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2018/4/14 21:56
 */
public class Service {
    /******* Fields Area *******/

    /******* Construction Area *******/
    public Service() {
    }
    /******* GetSet Area ******/

    /******* Method Area *******/

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel channel = ServerSocketChannel.open();

        channel.socket().bind(new InetSocketAddress(8011));
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            int readyChannels = selector.select();
            if (readyChannels == 0) {
                continue;
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();

                if (key.isAcceptable()) {
                    System.out.println("accept");
                    SocketChannel acceptChannel = ((ServerSocketChannel) key.channel()).accept();
                    acceptChannel.configureBlocking(false);
                    acceptChannel.register(selector, SelectionKey.OP_READ);
                } else if (key.isConnectable()) {
                    System.out.println("connect");
                } else if (key.isReadable()) {
                    System.out.println("read");
                    SocketChannel readChannel = ((SocketChannel) key.channel());
                    String text = Reader.readString(readChannel);
                    if (text.isEmpty()) {
                        // 这里需要注意, 如果读到的内容为空, 则可以关闭这个客户端连接了.
                        readChannel.close();
                    } else {
                        key.attach(text);
                        readChannel.register(selector, SelectionKey.OP_WRITE);
                    }
                } else if (key.isWritable()) {
                    System.out.println("write");
                    String text = (String) key.attachment();
                    SocketChannel writeChannel = ((SocketChannel) key.channel());
                    System.out.println(text);
                    writeChannel.write(ByteBuffer.wrap("FINISH".getBytes()));
                    writeChannel.register(selector, SelectionKey.OP_READ);
                }
                selectionKeys.remove(key);
            }


        }

    }

}

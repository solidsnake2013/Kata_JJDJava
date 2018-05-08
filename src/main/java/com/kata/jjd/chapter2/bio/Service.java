package com.kata.jjd.chapter2.bio;

import com.kata.jjd.kit.Reader;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Kata_JJDJava
 * <p>
 * Description :
 * <p>
 * Creator :
 *
 * @author Sudao @ Tim Zhang
 * @email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
 * @date: 2018/4/13
 * @time: 16:14
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2018/4/13 16:14
 */
public class Service {
    /******* Fields Area *******/

    /******* Construction Area *******/
    public Service() {
    }
    /******* GetSet Area ******/

    /******* Method Area *******/


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8011);
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8011);


        while(true) {
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            OutputStream clientOut = accept.getOutputStream();
            String text = Reader.readString(inputStream);
            System.out.println(text);
            clientOut.write("FINISH".getBytes());
            clientOut.flush();
            // 这句非常重要, 相当于给写入增加一个结束符
            accept.shutdownOutput();
        }


    }


}

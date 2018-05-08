package com.kata.jjd.chapter2;

import com.kata.jjd.kit.Reader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

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
 * @time: 17:57
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2018/4/14 17:57
 */
public class Client {
    /******* Fields Area *******/

    /******* Construction Area *******/
    public Client() {
    }
    /******* GetSet Area ******/

    /******* Method Area *******/

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8011);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        outputStream.write("abcdefhhhfff".getBytes());
        outputStream.flush();
        // 这句非常重要相当于给写入增加一个结束符.
        socket.shutdownOutput();
        String text = Reader.readString(inputStream);
        System.out.println(text);
        outputStream.close();
        inputStream.close();
        socket.close();
    }


}

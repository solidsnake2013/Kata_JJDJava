package com.kata.jjd.kit;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;

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
 * @time: 21:57
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2018/4/14 21:57
 */
public class Reader {
    /******* Fields Area *******/

    public static String readString(InputStream inputStream) {
        String text = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(bytes)) != -1) {
                out.write(bytes, 0, len);
            }
            text = new String(out.toByteArray(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return text;
    }


    public static String readString(ByteChannel byteChannel) {
        String text = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteBuffer bytes = ByteBuffer.wrap(new byte[1024]);
        int len;
        try {
            while ((len = byteChannel.read(bytes)) != -1) {
                out.write(bytes.array(), 0, len);
            }
            text = new String(out.toByteArray(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return text;
    }


    public static void main(String[] args) {
        Runnable runnable = new Runnable() {

            @Override
            public void run() {

            }
        };
        new Thread(runnable).stop();
    }
    /******* Construction Area *******/

    /******* GetSet Area ******/

    /******* Method Area *******/



}

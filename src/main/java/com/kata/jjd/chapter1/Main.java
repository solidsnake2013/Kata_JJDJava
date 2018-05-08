package com.kata.jjd.chapter1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jodd.io.FileUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Kata_JJDJava
 * <p>
 * Description :
 * <p>
 * Creator :
 * Sudao @ Tim Zhang
 * Email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
 * Date: 2017/7/6
 * Time: 下午3:46
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2017/7/6 下午3:46
 */
public abstract class Main {
    /******* Fields Area *******/

    /******* Construction Area *******/
    /******* GetSet Area ******/

    /******* Method Area *******/


    /**
     * 10 进制转换到 2 进制
     * @param count
     * @return
     */
    public static String convert2Bit(Integer count) {
        return count >> 1 == 0 ? count.toString() : convert2Bit(count >> 1) + count % 2;
    }


    public static void main(String[] args) throws IOException {
//        String path = Thread.currentThread().getContextClassLoader().getResource("geoData.json").getPath();
//        System.out.println(path);
//
//        String json = FileUtil.readString(path);
//        JSONObject jsonObject = JSON.parseObject(json);
//        JSONArray areas = jsonObject.getJSONArray("area");
//        List<Object> type = areas.stream().filter(v -> ((JSONObject) v).getLong("type") == 1L).collect(Collectors.toList());
//        System.out.println(type.size());
        System.out.println(findMissingLetter(new char[] { 'a','b','c','d','f' }));
        System.out.println(findMissingLetter(new char[] { 'O','Q','R','S' }));



    }

    public static char findMissingLetter(char[] array)
    {
        char result = 'Z';
        char prov = array[0];
        for(int i = 1; i<array.length; i++) {
            char current = array[i];
            if(prov + 1 != current) {
                result = (char)(prov + 1);
                break;
            }else {
                prov = current;
            }
        }
        return result;
    }

}

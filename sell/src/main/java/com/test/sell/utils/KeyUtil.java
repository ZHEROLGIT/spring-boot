package com.test.sell.utils;

import lombok.Synchronized;

import java.util.Random;

/**
 * @file_name: KeyUtil
 * @Description：
 * @author: 张磊
 * @date: 四月 2018/4/17 15:28
 * @version：
 */
public class KeyUtil {
    /** 生成唯一的主键key
     *  格式：时间+随机数
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}

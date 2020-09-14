package com.simon.learn;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author simon.wei
 */
public class Client {

    public static void main(String[] args) {
        // 10是初始大小，0.75是装载因子，true是表示按照访问时间排序
        HashMap m = new LinkedHashMap<>(10, 0.75f, true);
        m.put(3, 11);
        m.put(1, 12);
        m.put(5, 23);
        m.put(2, 22);
        m.put(3, 26);
        m.get(5);
        System.out.println(m);
    }
}

package com.simon.learn.algorithm.limit;

/**
 * @author simon.wei
 */
public class CountClient {

    /**
     * 限流算法
     * 1、固定窗口
     * 2、滑动窗口
     * 3、令牌桶
     * 4、漏桶
     */

    public static void main(String[] args) {
        Count count = new Count();
        System.out.println(count.limit());
    }

}

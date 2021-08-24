package com.simon.learn;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @author simon.wei
 */
public class MedianFinder {

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());
    }

    PriorityQueue<Integer> minQueue;

    /** initialize your data structure here. */
    public MedianFinder() {
        minQueue = new PriorityQueue<>();
    }

    public void addNum(int num) {
        minQueue.add(num);
    }

    public double findMedian() {
        if(minQueue.size() == 0) {
            return 0d;
        }
        PriorityQueue<Integer> resultQueue = new PriorityQueue<>();
        Iterator<Integer> iterator = minQueue.iterator();
        while (iterator.hasNext()) {
            Integer ele = iterator.next();
            resultQueue.add(ele);
        }
        if(resultQueue.size() == 1) {
            return (double)resultQueue.poll();
        } else {
            if(resultQueue.size() % 2 == 0) {
                int count = resultQueue.size() / 2;
                int left = 0;
                int right;
                for(int i = 0; i < count; i++) {
                    left = resultQueue.poll();
                }
                right = resultQueue.poll();
                return (double)(left + right) / 2;
            } else {
                int count = resultQueue.size() / 2;
                for(int i = 0; i < count; i++) {
                    resultQueue.poll();
                }
                return (double)resultQueue.poll();
            }
        }
    }
}

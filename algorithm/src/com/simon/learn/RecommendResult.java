package com.simon.learn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author simon.wei
 */
public class RecommendResult {

    public static void main(String[] args) {
        List<String> picAndVideo = new ArrayList<>();
        picAndVideo.add("v_0");
        picAndVideo.add("v_1");
        picAndVideo.add("v_2");
        picAndVideo.add("p_3");
        picAndVideo.add("p_4");
        picAndVideo.add("p_5");
        picAndVideo.add("v_6");
        picAndVideo.add("p_7");
        picAndVideo.add("v_8");
        picAndVideo.add("v_9");
        List<String> result = new RecommendResult().getRecommendResult(picAndVideo, 2);
        result.forEach(e -> System.out.println(e));
    }

    public List<String> getRecommendResult(List<String> picAndVideo, int maxInterval) {
        List<String> result = new ArrayList<>();
        if(picAndVideo == null || picAndVideo.size() == 0) {
            return result;
        }
        Queue<String> videoQueue = new LinkedList<>();
        Queue<String> picQueue = new LinkedList<>();
        for (String element : picAndVideo) {
            if(isVideo(element)) {
                videoQueue.add(element);
            } else {
                picQueue.add(element);
            }
        }
        int current = 0;
        while (!videoQueue.isEmpty()) {
            if(current < maxInterval) {
                result.add(videoQueue.poll());
                current++;
            } else {
                if(!picQueue.isEmpty()) {
                    result.add(picQueue.poll());
                }
                current = 0;
            }
        }
        if(current >= maxInterval && !picQueue.isEmpty()) {
            result.add(picQueue.poll());
        }
        return result;
    }

    public boolean isVideo(String element) {
        if(element.indexOf("v") != -1) {
            return true;
        }
        return false;
    }
}

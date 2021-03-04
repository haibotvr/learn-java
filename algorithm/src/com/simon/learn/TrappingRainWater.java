package com.simon.learn;

/**
 * @author simon.wei
 */
public class TrappingRainWater {

    public static void main(String[] args) {

        int[] num = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = new TrappingRainWater().trap(num);
        System.out.println(trap);
    }

    public int trap(int[] num) {
        if(num == null || num.length == 0) {
            return 0;
        }
        int total = 0;
        int start = 0;
        int end = num.length - 1;
        int leftHeight = num[start];
        int rightHeight = num[end];
        while (start < end) {
            if(leftHeight < rightHeight) {
                if(leftHeight > num[start + 1]) {
                    total += leftHeight - num[start + 1];
                } else {
                    leftHeight = num[start + 1];
                }
                start++;
            } else {
                if(rightHeight > num[end - 1]) {
                    total += rightHeight - num[end - 1];
                } else {
                    rightHeight = num[end - 1];
                }
                end--;
            }
        }
        return total;
    }
}

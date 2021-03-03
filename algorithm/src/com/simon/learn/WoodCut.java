package com.simon.learn;

/**
 * @author simon.wei
 */
public class WoodCut {

    public static void main(String[] args) {
        int[] woods = new int[]{232,124,456};
        int piecesLength = new WoodCut().getPiecesLength(woods, 7);
        System.out.println(piecesLength);
    }

    public int getPiecesLength(int[] woods, int pieces) {
        if(woods == null || woods.length == 0) {
            return 0;
        }
        int start = 1;
        int end = getMax(woods);
        int mid;
        while (start < end - 1) {
            mid = start + (end - start) / 2;
            if(getPieces(woods, mid) >= pieces) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(getPieces(woods, end) >= pieces) {
            return end;
        }
        if(getPieces(woods, start) >= pieces) {
            return start;
        }
        return 0;
    }

    private int getPieces(int[] woods, int length) {
        int pieces = 0;
        for (int wood : woods) {
            pieces += wood / length;
        }
        return pieces;
    }

    private int getMax(int[] woods) {
        int max = 0;
        for (int wood : woods) {
            max += wood;
        }
        return max;
    }
}

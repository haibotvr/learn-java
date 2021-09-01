package com.simon.learn.unionfind;

import java.util.HashMap;
import java.util.Map;

/**
 * @author simon.wei
 */
public class UnionFind {

    private Map<Integer, Integer> father = new HashMap<>();

    public UnionFind(int n) {
        for (int i = 0; i < n; i++) {
            father.put(i, i);
        }
    }

    public int find(int x) {
        int parent = father.get(x);
        while(parent != father.get(parent)) {
            parent = father.get(parent);
        }
        int temp;
        int tp = father.get(x);
        while (tp != father.get(tp)) {
            temp = father.get(tp);
            father.put(tp, parent);
            tp = temp;
        }
        return parent;
    }

    public void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if(parentX != parentY) {
            father.put(parentX, parentY);
        }
    }
}

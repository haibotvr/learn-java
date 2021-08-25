package com.simon.learn.graph;

import java.util.*;

/**
 * @author simon.wei
 */
public class Solution {

    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        List<Node> nodes = getNodes(node);
        Map<Node, Node> map = new HashMap<>();
        for(Node element: nodes) {
            map.put(element, new Node(element.val));
        }
        for(Node element: nodes) {
            List<Node> neighbors = element.neighbors;
            List<Node> newNeighbors = new ArrayList<>();
            for(Node neighbor: neighbors) {
                newNeighbors.add(map.get(neighbor));
            }
            map.get(element).neighbors = newNeighbors;
        }
        return map.get(node);
    }

    public List<Node> getNodes(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        queue.offer(node);
        set.add(node);
        while(!queue.isEmpty()) {
            Node element = queue.poll();
            List<Node> neighbors = element.neighbors;
            for(Node neighbor: neighbors) {
                if(!set.contains(neighbor)) {
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return new ArrayList<>(set);
    }
}

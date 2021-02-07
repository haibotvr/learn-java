package com.simon.learn;

import com.simon.learn.structure.Node;

/**
 * @author simon.wei
 */
public class LinkOperation {

    public static Node init() {
        Node node_6 = new Node(6, null);
        Node node_5 = new Node(5, node_6);
        Node node_4 = new Node(4, node_5);
        Node node_3 = new Node(3, node_4);
        Node node_2 = new Node(2, node_3);
        Node node_1 = new Node(1, node_2);
        Node node_dummy = new Node(-1, node_1);
        return node_dummy;
    }

    public static void print(Node node) {
        System.out.println(">>>开始打印<<<");
        Node head = node.getNext();
        while (head != null) {
            System.out.print(head.getData());
            head = head.getNext();
        }
        System.out.println("\n>>>打印结束<<<");
    }

    public static Node reverseBetween(Node node, int m, int n) {
        Node head = node.getNext();
        if(head == null || m >= n) {
            return node;
        }
        Node prev = head;
        for (int i = 1; i < m; i++) {
            prev = head.getNext();
        }
        Node current = prev.getNext();
        for (int i = 1; i < n - m; i++) {
            Node next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        return node;
    }

    public static Node reverse(Node node) {
        Node head = node.getNext();
        if(head == null) {
            return node;
        }
        Node prev = head;
        Node current = head.getNext();
        prev.setNext(null);
        while (current != null) {
            Node next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        node.setNext(prev);
        return node;
    }

    public static void main(String[] args) {
        Node node = LinkOperation.init();
        LinkOperation.print(node);
        node = LinkOperation.reverse(node);
        LinkOperation.print(node);
        node = LinkOperation.reverseBetween(node, 2, 5);
        LinkOperation.print(node);
    }
}

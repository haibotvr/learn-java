package com.simon.learn;

import com.simon.learn.structure.Node;

import java.util.HashMap;
import java.util.Map;

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

    public static Node initDeepCopyNode() {
        Node node_3 = new Node(3, null);
        Node node_2 = new Node(2, node_3);
        Node node_1 = new Node(1, node_2);
        node_1.setRandom(node_3);
        return node_1;
    }

    public static Node initNumberOneNode() {
        Node node_4 = new Node(2, null);
        Node node_3 = new Node(4, node_4);
        Node node_2 = new Node(5, node_3);
        Node node_1 = new Node(9, node_2);
        return node_1;
    }

    //2459
    //465
    //60101
    public static Node initNumberTwoNode() {
        Node node_3 = new Node(4, null);
        Node node_2 = new Node(6, node_3);
        Node node_1 = new Node(5, node_2);
        node_1.setRandom(node_3);
        return node_1;
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
        for (int i = 1; i < m - 1; i++) {
            head = head.getNext();
        }
        Node sPrev = head.getNext();
        Node prev = sPrev;
        Node current = prev.getNext();
        Node next = current.getNext();
        for (int i = 1; i < n - m; i++) {
            current.setNext(prev);
            prev = current;
            current = next;
            next = current.getNext();
        }
        current.setNext(prev);
        sPrev.setNext(next);
        head.setNext(current);
        return node;
    }

    public static Node reverse(Node node) {
        Node prev = node;
        if(prev == null) {
            return null;
        }
        Node current = prev.getNext();
        prev.setNext(null);
        while (current != null) {
            Node next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        return prev;
    }

    public static Node deepCopyByHashMap(Node node) {
        if(node == null) {
            return null;
        }
        Node head = node;
        Map<Node, Node> map = new HashMap<>(3);
        while (head != null) {
            if(!map.containsKey(head)) {
                Node copy = new Node(head.getData());
                map.put(head, copy);
            }
            head = head.getNext();
        }
        head = node;
        while (head != null) {
            if(head.getNext() != null) {
                map.get(head).setNext(map.get(head.getNext()));
            }
            if(head.getRandom() != null) {
                map.get(head).setRandom(map.get(head.getRandom()));
            }
            head = head.getNext();
        }
        return map.get(node);
    }

    public static Node deepCopy(Node node) {
        if(node == null) {
            return null;
        }
        copy(node);
        copyRandom(node);
        return split(node);
    }

    private static Node split(Node node) {
        Node head = node;
        Node result = head.getNext();
        Node move = head.getNext();
        while (head != null && head.getNext() != null) {
            head.setNext(head.getNext().getNext());
            head = head.getNext();
            if(move != null && move.getNext() != null) {
                move.setNext(move.getNext().getNext());
                move = move.getNext();
            }
        }
        return result;
    }

    private static void copyRandom(Node node) {
        Node head = node;
        while (head != null && head.getRandom() != null) {
            Node random = head.getRandom();
            head.getNext().setRandom(random.getNext());
            head = head.getNext().getNext();
        }
    }

    private static void copy(Node node) {
        Node head = node;
        while (head != null) {
            Node copy = new Node(head.getData());
            copy.setNext(head.getNext());
            head.setNext(copy);
            head = head.getNext().getNext();
        }
    }

    public static Node addTwoNumbers(Node before, Node after) {

        Node dummy = new Node(-1);
        Node head = dummy;
        int carry = 0;
        while (before != null && after != null) {
            int number = ((int)before.getData() + (int)after.getData() + carry)%10;
            carry = ((int)before.getData() + (int)after.getData() + carry)/10;
            Node node = new Node(number);
            before = before.getNext();
            after = after.getNext();
            head.setNext(node);
            head = head.getNext();
        }
        while (before != null) {
            int number = ((int)before.getData() + carry)%10;
            carry = ((int)before.getData() + carry)/10;
            Node node = new Node(number);
            before = before.getNext();
            head.setNext(node);
            head = head.getNext();
        }
        while (after != null) {
            int number = ((int)after.getData() + carry)%10;
            carry = ((int)after.getData() + carry)/10;
            Node node = new Node(number);
            after = after.getNext();
            head.setNext(node);
            head = head.getNext();
        }
        if(carry > 0) {
            Node node = new Node(carry);
            head.setNext(node);
        }
        return dummy;
    }

    public static void main(String[] args) {
//        Node node = LinkOperation.init();
//        LinkOperation.print(node);
//        node = LinkOperation.reverse(node);
//        LinkOperation.print(node);
//        node = LinkOperation.reverseBetween(node, 2, 5);
//        LinkOperation.print(node);
//        Node node = LinkOperation.initDeepCopyNode();
//        LinkOperation.print(node);
//        LinkOperation.print(LinkOperation.deepCopy(node));

        Node before = initNumberOneNode();
        Node beforeRevese = reverse(before);
        Node after = initNumberTwoNode();
        Node afterReverse = reverse(after);
        Node node = addTwoNumbers(beforeRevese, afterReverse);
        System.out.println();

    }
}

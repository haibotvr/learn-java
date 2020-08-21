package com.simon.learn.structure;

/**
 * @author simon.wei
 */
public class Client {

    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();
        linkedList.add(new Node(10));
        linkedList.add(new Node(20));
        linkedList.add(new Node(30));
        linkedList.add(new Node(40));
        linkedList.log();
        System.out.println(linkedList.getSize());
        linkedList.remove(0);
        linkedList.log();
        System.out.println(linkedList.getSize());
    }
}

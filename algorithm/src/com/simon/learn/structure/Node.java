package com.simon.learn.structure;

/**
 * @author simon.wei
 */
public class Node {

    private Object data;

    private Node next;

    private Node random;

    public Node(Object data) {
        this.data = data;
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(Object data, Node next, Node random) {
        this.data = data;
        this.next = next;
        this.random = random;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getRandom() {
        return random;
    }

    public void setRandom(Node random) {
        this.random = random;
    }
}

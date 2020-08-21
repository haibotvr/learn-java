package com.simon.learn.structure;

/**
 * @author simon.wei
 */
public class CustomLinkedList {

    private int size;

    private Node head;

    public int getSize() {
        return size;
    }

    public CustomLinkedList() {
        this.size = 0;
        this.head = new Node(null);
    }

    public CustomLinkedList add(Node node) {
        if (node == null) {
            return this;
        }
        Node temp = head;
        while (temp != null) {
            if(temp.getNext() == null){
                temp.setNext(node);
                size++;
                return this;
            }
            temp = temp.getNext();
        }
        return this;
    }

    public CustomLinkedList remove(int index) {
        int pos = 0;
        Node temp = head;
        while(temp.getNext() != null) {
            if(pos == index) {
                Node delNode = temp.getNext();
                temp.setNext(delNode.getNext());
                size--;
                return this;
            }
            temp = temp.getNext();
            pos++;
        }
        size--;
        return this;
    }

    public void log() {
        Node temp = head;
        StringBuilder builder = new StringBuilder();
        while (temp.getNext() != null) {
            temp = temp.getNext();
            builder.append(temp.getData().toString());
            builder.append(",");
        }
        System.out.println(builder.toString());
    }
}

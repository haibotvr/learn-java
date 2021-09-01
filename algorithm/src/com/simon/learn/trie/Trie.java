package com.simon.learn.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author simon.wei
 */
public class Trie {

    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node current = root;
        Map<Character, Node> children = current.children;
        char[] wordArray = word.toCharArray();
        for(int i = 0; i < wordArray.length; i++) {
            char c = wordArray[i];
            if(!children.containsKey(c)) {
                Node newNode = new Node(c);
                children.put(c, newNode);
                current = newNode;
            } else {
                current = children.get(c);
            }
            children = current.children;
            if(i == wordArray.length - 1) {
                current.end = true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] wordArray = word.toCharArray();
        Node current = root;
        Map<Character, Node> children = root.children;
        for(int i = 0; i < wordArray.length; i++) {
            char c = wordArray[i];
            if(!children.containsKey(c)) {
                return false;
            } else {
                current = children.get(c);
                children = current.children;
            }
        }
        if(current.end) {
            return true;
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] wordArray = prefix.toCharArray();
        Node current;
        Map<Character, Node> children = root.children;
        for(int i = 0; i < wordArray.length; i++) {
            char c = wordArray[i];
            if(!children.containsKey(c)) {
                return false;
            } else {
                current = children.get(c);
                children = current.children;
            }
        }
        return true;
    }

}

class Node {
    public char c;
    public boolean end;
    public Map<Character, Node> children;
    public Node(char c) {
        this.c = c;
        this.children = new HashMap<>();
    }
    public Node() {
        this.children = new HashMap<>();
    }
}

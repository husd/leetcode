package com.husd.leetcode.linkedlist;

/**
 * 这里是这个类的功能描述
 *
 * @author hushengdong
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node prev;
    public Node child;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
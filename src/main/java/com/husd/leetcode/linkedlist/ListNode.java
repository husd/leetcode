package com.husd.leetcode.linkedlist;

/**
 * 这里的注释内容，需要对类的使用做一个简单的说明。
 *
 * @author hushengdong
 * @create 2019-10-30 16:32:00
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return " " + val + " - " + (next == null ? null : next.val);
    }

    public String toString1() {

        StringBuilder sb = new StringBuilder();

        ListNode c = next;
        sb.append(val);
        sb.append(" ");
        while(c != null) {
            sb.append(c.val);
            sb.append(" ");
            c = c.next;
        }
        return sb.toString();
    }
}

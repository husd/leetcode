package com.husd.leetcode;

import com.husd.leetcode.entry.ListNode;

/**
 * 反转单链表
 *
 * @author hushengdong
 * @create 2019-10-30 16:31:00
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = pre;
            pre = head;
            head = nextNode;
        }
        return pre;
    }
}

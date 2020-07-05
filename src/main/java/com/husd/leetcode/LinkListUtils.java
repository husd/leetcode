package com.husd.leetcode;

import com.husd.leetcode.linkedlist.ListNode;

public class LinkListUtils {

    public static ListNode mock(int [] arr) {

        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for(int i=1;i<arr.length;i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }
}

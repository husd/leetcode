package com.husd.leetcode.linkedlist;

/**
 * 203. 移除链表元素
 *
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {

        ListNode pre = null;
        ListNode curr = head;
        while(curr != null) {
            if(curr.val == val) {
                if(pre == null) {
                    head = curr.next;
                    curr = curr.next;
                } else {
                    pre.next = curr.next;
                    curr = curr.next;
                }
            } else {
                pre = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}

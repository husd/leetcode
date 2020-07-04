package com.husd.leetcode.linkedlist;

/**
 * 82. 删除排序链表中的重复元素 II
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null) return head;
        //先把头部相等的删除了
        while(head.val == head.next.val && head != null &&  head.next != null) {
            head = head.next;
        }
        ListNode pre = null;
        ListNode curr = head;
        while(curr != null) {
            boolean repeat = false;
            while(curr.next != null && curr.val == curr.next.val) {
                curr.next = curr.next.next;
                repeat = true;
            }
            if(repeat) {
                pre.next = curr.next;
                curr = curr.next;
            } else {
                if(pre == null) pre = head;
                else pre = pre.next;
                curr = curr.next;
            }
        }
        return head;
    }
}

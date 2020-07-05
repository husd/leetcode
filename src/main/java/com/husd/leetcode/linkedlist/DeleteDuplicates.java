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

    //TODO 值得一看 尾巴插法
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;  // 若head为空则直接返回null
        ListNode dummy = new ListNode(-1);  // 建立一个虚拟头结点
        ListNode tail = dummy;  // 定义一个尾巴，用于尾插法。
        for (ListNode curr = head, next = head; curr != null; curr = next) {
            while (next != null && next.val == curr.val) next = next.next;  // 只要r不为空并且与l的值相等则一直向后移动

            //指定一个尾巴，然后把元素一直向后加
            //curr.next = next 说明没有重复元素
            if (curr.next == next) {  // 若长度为1，则通过尾插法加入。
                tail.next = curr;  // 基本的尾插法
                tail = curr;
                tail.next = null;  // 这里记得将尾部的后面置为null，不然可能后面会带着一些其他的节点。
            }
        }
        return dummy.next;
    }


    public ListNode deleteDuplicates1(ListNode head) {

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

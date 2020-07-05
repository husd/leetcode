package com.husd.leetcode.linkedlist;

/**
 *
 * 83. 删除排序链表中的重复元素
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class DeleteDuplicates2 {

    // 1 1 2 3 4
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;  // 若head为空则直接返回null
        ListNode dummy = new ListNode(-1);  // 建立一个虚拟头结点
        ListNode tail = dummy;  // 定义一个尾巴，用于尾插法。
        for (ListNode curr = head, next = head; curr != null; curr = next) {
            while (next != null && next.val == curr.val) next = next.next;  // 只要curr不为空并且与next的值相等则一直向后移动
            tail.next = curr;  // 基本的尾插法
            tail = curr;
            tail.next = null;  // 这里记得将尾部的后面置为null，不然可能后面会带着一些其他的节点。
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        DeleteDuplicates2 m = new DeleteDuplicates2();

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        m.deleteDuplicates(head);

    }
}

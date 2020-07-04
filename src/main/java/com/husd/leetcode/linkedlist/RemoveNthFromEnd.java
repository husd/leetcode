package com.husd.leetcode.linkedlist;

/**
 * 19. 删除链表的倒数第N个节点
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head.next == null) return null;

        ListNode first = head;
        ListNode after = null;
        ListNode pre = null;
        int step = 0;
        while(first != null && step < n) {
            first = first.next;
            step++;
        }
        while(first != null) {
            first = first.next;
            if(after == null) {
                after = head.next;
                pre = head;
            } else {
                after = after.next;
                pre = pre.next;
            }
        }
        //表示要删除的是第一个元素
        if(pre == null) {
            head = head.next;
        } else {
            pre.next = after.next;
        }

        return head;
    }
}

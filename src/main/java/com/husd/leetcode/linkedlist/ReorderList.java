package com.husd.leetcode.linkedlist;

/**
 * 143. 重排链表
 *
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReorderList {

    //TODO 值得一看
    //注意怎么反转list的
    public void reorderList(ListNode head) {

        if(head == null || head.next == null || head.next.next == null) return;
        //找到中间节点
        //利用快慢指针来找
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {

            fast = fast.next;
            if(fast != null) {
                fast = fast.next;
            }
            slow = slow.next;
        }

        //slow.next = null;
        ListNode sec = slow.next;
        slow.next = null;
        ListNode prev = null;
        while(sec != null) {
            ListNode temp = sec.next;
            //反转的关键
            sec.next = prev;
            //更新prev
            prev = sec;
            //这个比较好理解
            sec = temp;
        }
//1 2 3 4 5

        ListNode h2 = head;
        while(prev != null) {

            ListNode t1 = prev.next;
            ListNode t2 = h2.next;

            h2.next= prev;
            prev.next = t2;

            h2 = t2;
            prev = t1;

        }

    }

    public static void main(String[] args) {

        ReorderList m = new ReorderList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
       // head.next.next.next.next = new ListNode(5);
        //head.next.next.next.next.next = new ListNode(2);

        m.reorderList(head);

        System.out.printf("1");
    }
}

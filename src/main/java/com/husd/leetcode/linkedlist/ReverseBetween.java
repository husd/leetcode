package com.husd.leetcode.linkedlist;

/**
 * 92. 反转链表 II
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseBetween {

    //TODO 值得一看

    //还没做出来
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if(head == null || head.next == null) return head;
        //先找到第M
        ListNode curr = head;
        ListNode last = curr;
        int index = 0;
        while(index < m - 1) {
            last = curr;
            curr = curr.next;
            index++;
        }
        ListNode c = curr;
        //正常反转，计数N
        index = 0;
        ListNode prev = null;
        if(n>m) {
            while(index < n - 1 && curr != null) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
                index++;
            }
            if(curr != null) {
                curr.next = prev;
            }
            c.next = curr;
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        //head.next.next = new ListNode(3);
       // head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);

        ReverseBetween m = new ReverseBetween();
        m.reverseBetween(head,1,2);
        System.out.println("1");
    }
}

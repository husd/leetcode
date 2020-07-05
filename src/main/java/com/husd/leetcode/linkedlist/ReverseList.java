package com.husd.leetcode.linkedlist;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseList {

    //TODO 值得一看
    //TODO 好好看看
    //迭代 A - B - C - D  -> D - C - B - A
    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode temp = curr.next;
            //这个是关键
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    //递归
    public ListNode reverseList1(ListNode head) {

        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        //假设把其它的都反转了，那么就反这1个就行了
        head.next.next = head;
        head.next = null;
        return p;
    }
}

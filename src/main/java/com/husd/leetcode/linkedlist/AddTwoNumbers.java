package com.husd.leetcode.linkedlist;

/**
 *
 * 面试题 02.05. 链表求和
 *
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 *
 * 这些数位是反向存放的，也就是个位排在链表首部。
 *
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 *
 *  
 *
 * 示例：
 *
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 进阶：假设这些数位是正向存放的，请再做一遍。
 *
 * 示例：
 *
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-lists-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(0);
        ListNode curr = res;
        int n = 0;
        while(l1 != null || l2 != null) {
            int v = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + n;
            curr.next = new ListNode(v >= 10 ? v - 10 : v);
            n = v >= 10 ? 1 : 0;
            curr = curr.next;
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        if(n > 0) {
            curr.next = new ListNode(n);
        }
        return res.next;
    }

    public static void main(String[] args) {

        AddTwoNumbers m = new AddTwoNumbers();
        int [] a  = {2,4,3};
        int [] b = {5,6,4};
        ListNode head1 = mock(a);
        ListNode head2 = mock(b);
        m.addTwoNumbers(head1,head2);
    }

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

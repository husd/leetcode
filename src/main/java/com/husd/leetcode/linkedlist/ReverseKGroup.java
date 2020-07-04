package com.husd.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 25. K 个一组翻转链表
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *  
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 *  
 *
 * 说明：
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        if(k <= 1) return head;
        int n = 0;
        ListNode c = head;
        while(c!= null) {
            n++;
            c = c.next;
        }


        //1->2->3->4->5  if k =3 : 3->2->1->4->5
        // 双指针游走
        ListNode pre = head;
        ListNode sec = head;
        int count = 0;
        while(count < k && sec != null) {
            count++;
            sec = sec.next;
            if(count == (k-1)) {
                //找到了，反转

            }
        }






        return null;
    }
}

package com.husd.leetcode;

import com.husd.leetcode.entry.ListNode;

import com.husd.leetcode.entry.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 * @create 2019-11-04 10:32:00
 */
public class AddTwoNumber {

    public ListNode addTwoNumbers0ms(ListNode l1, ListNode l2) {
        int c = 0;
        ListNode pre = null;
        ListNode res = l1;
        while(l1 != null || l2 != null) {
            if(l1 == null) {
                pre.next = l2;
                l1 = l2;
                l2 = null;
            }
            l1.val += (l2 == null) ? c : (l2.val + c);
            c = 0;
            if(l1.val > 9) {
                l1.val %= 10;
                c = 1;
            }
            pre = l1;
            l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(c != 0) {
            ListNode hi = new ListNode(1);
            pre.next = hi;
        }
        return res;
    }

    // 直观写法
    public ListNode addTwoNumbers400ms(ListNode l1, ListNode l2) {
        StringBuilder sb1 = new StringBuilder(1024);
        StringBuilder sb2 = new StringBuilder(1024);
        long num1 = 0;
        long num2 = 0;
        if(l1 != null) {
            sb1.append(l1.val);
            l1 = l1.next;
            while(l1!= null){
                sb1.append(l1.val);
                l1 = l1.next;
            }
            String temp = sb1.reverse().toString();
            num1 = Long.parseLong(temp);
        }

        if(l2 != null) {
            sb2.append(l2.val);
            l2 = l2.next;
            while(l2!= null){
                sb2.append(l2.val);
                l2 = l2.next;
            }
            String temp = sb2.reverse().toString();
            num2 = Long.parseLong(temp);
        }

        long total = num1 + num2;
        if(total <=9) {
            return new ListNode((int)total);
        }
        ListNode listNode = new ListNode(0);
        ListNode current = listNode;
        StringBuilder sb3 = new StringBuilder(String.valueOf(total));
        String result = sb3.reverse().toString();
        int len = result.length();
        for(int i=0;i<len;i++) {
            String temp = String.valueOf(result.charAt(i));
            current.val = Integer.parseInt(temp);
            if(i != len-1) {
                current.next = new ListNode(0);
                current = current.next;
            }
        }
        return listNode;

    }
}

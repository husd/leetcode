package com.husd.leetcode.linkedlist;


/**
 * 面试题 02.06. 回文链表
 *
 * 编写一个函数，检查输入的链表是否是回文的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入： 1->2
 * 输出： false
 * 示例 2：
 *
 * 输入： 1->2->2->1
 * 输出： true
 *  
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPalindrome {

    //TODO 值得一看
    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        //一边走 一边反转前面的
        // 1 2 3 4 5 6 7
        while (fast != null && fast.next != null) {
            ListNode oldCur = slow;
            slow = slow.next;
            fast = fast.next.next;

            //反转的关键 把slow节点的下一个指向前1个，就实现了反转
            oldCur.next = prev;
            //更新prev
            prev = oldCur;
        }

        if (fast != null) {
            // 链表个数为奇数
            slow = slow.next;
        }

        // 判断pre和slow是否相等
        while (slow != null) {
            if (slow.val != prev.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }
}

package com.husd.leetcode.linkedlist;

/**
 * 面试题 02.02. 返回倒数第 k 个节点
 * <p>
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * 示例：
 * <p>
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 * <p>
 * 给定的 k 保证是有效的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class KthToLast {

    //反转？ 再遍历

    //双指针解法 1个指针先走K步 这样当它到尾巴的时候，第2个指针就是结果
    public int kthToLast(ListNode head, int k) {

        ListNode first = head;
        ListNode sec = head;
        int index = 0;
        //first先走K步
        while (index++ < k) {
            first = first.next;
        }
        //一块走
        while (first != null) {
            first = first.next;
            sec = sec.next;
        }
        return sec.val;
    }
}

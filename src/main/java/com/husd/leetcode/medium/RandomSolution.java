package com.husd.leetcode.medium;

import com.husd.leetcode.entry.ListNode;

import java.util.Random;

/**
 * 382. 链表随机节点
 * <p>
 * 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
 * <p>
 * 进阶:
 * 如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？
 * <p>
 * 示例:
 * <p>
 * // 初始化一个单链表 [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 * <p>
 * // getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
 * solution.getRandom();
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-random-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 * @date 2020/4/20
 * @tag 蓄水池抽样
 */
public class RandomSolution {

    ListNode head = null;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public RandomSolution(ListNode head) {
        this.head = head;
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {

        Random random = new Random();
        ListNode result = head;
        ListNode node = head.next;
        int index = 1;
        while (node != null) {
            if (random.nextInt(index + 1) == 0) {
                result = node;
            }
            node = node.next;
            index++;
        }
        return result.val;
    }
}

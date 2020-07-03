package com.husd.leetcode.linkedlist;

import com.husd.leetcode.entry.ListNode;

/**
 * 面试题 02.08. 环路检测
 * <p>
 * 给定一个有环链表，实现一个算法返回环路的开头节点。
 * 有环链表的定义：在链表中某个节点的next元素指向在它前面出现过的节点，则表明该链表存在环路。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class DetectCycle {

    //检测环，主要使用快慢指针来实现
    //TODO 值得一看
    //TODO 重点学习
    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) return null;
        //定义2个指针，1个快的 1个慢的
        ListNode slow = head, fast = head;
        //快指针如果没有空指针，慢的一定也不会，所以不用考虑 slow == null
        while (fast != null && fast.next != null) {
            //慢指针走的慢 快指针走的快
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        //说明没有找到环
        if (fast == null || fast.next == null) {
            return null;
        }

        // slow从head开始，fast从相遇点开始，一步一步走再次相遇即为环入口
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

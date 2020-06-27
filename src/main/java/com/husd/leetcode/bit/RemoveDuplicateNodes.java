package com.husd.leetcode.bit;

import com.husd.leetcode.entry.ListNode;

/**
 * 面试题 02.01. 移除重复节点
 *
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 * 示例2:
 *
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 * 提示：
 *
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 *
 * 如果不得使用临时缓冲区，该怎么解决？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicateNodes {

    int [] set = new int[20000];

    public ListNode removeDuplicateNodes(ListNode head) {

        ListNode current = head;
        ListNode pre = null;
        while(current != null) {
            int v = current.val;
            if(set[v] == 0) {
                set[v] = 1;
                pre = current;
                current = current.next;
            } else {
                pre.next = current.next;
                current = current.next;
            }
        }
        return head;
    }
}

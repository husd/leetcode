package com.husd.leetcode.linkedlist;

/**
 * 1171. 从链表中删去总和值为零的连续节点
 *
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 *
 * 删除完毕后，请你返回最终结果链表的头节点。
 *
 *  
 *
 * 你可以返回任何满足题目要求的答案。
 *
 * （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
 *
 * 示例 1：
 *
 * 输入：head = [1,2,-3,3,1]
 * 输出：[3,1]
 * 提示：答案 [1,2,1] 也是正确的。
 * 示例 2：
 *
 * 输入：head = [1,2,3,-3,4]
 * 输出：[1,2,4]
 * 示例 3：
 *
 * 输入：head = [1,2,3,-3,-2]
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * 给你的链表中可能有 1 到 1000 个节点。
 * 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class RemoveZeroSumSublists {

    // 2 3 -3 3 2 -2

    //TODO 值得一看
    public ListNode removeZeroSumSublists(ListNode head) {

        ListNode current = head;
        ListNode pre = null;
        int [] val = new int[1001];

        int index = 0;
        while(current != null) {
            val[index++] = current.val;
        }

        //for(int i = 0;i<)

        current = head;
        while(current != null && current.next != null) {
            if(current.val < 0) {
                //2中情况可能为0
                //向前为0 先不考虑
                //向后为0
                int sum = current.val;
                ListNode c = current.next;
                while(sum <0 && c != null && c.val > 0) {
                    sum += c.val;
                    c = c.next;
                }
                if(sum == 0) {
                    // find it
                    pre.next = c == null ? null : c.next;
                    current = c == null ?  null : c.next;
                } else {
                    pre = current;
                    current = current.next;
                }
            } else {
                pre = current;
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

        RemoveZeroSumSublists m = new RemoveZeroSumSublists();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(-2);
        head.next.next.next = new ListNode(-3);
        head.next.next.next.next = new ListNode(3);
        ListNode c = m.removeZeroSumSublists(head);
        String s = c.toString1();
        System.out.printf(s);
    }
}

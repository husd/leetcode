package com.husd.leetcode.linkedlist;

/**
 * 面试题 02.04. 分割链表
 * <p>
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 3->5->8->5->10->2->1, x = 5
 * 输出: 3->1->2->10->5->5->8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class Partition {

    // TODO 值得一看
    //生成2个节点 1个比x小 1个比X大
    public ListNode partition(ListNode head, int x) {


        ListNode before_head = new ListNode(0);
        //这个假节点非常重要 仔细体会用法
        ListNode before = before_head;
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;

        ListNode curr = head;

        while(curr != null) {

            if(curr.val < x) {
                before.next = curr;
                before = before.next;
            } else {
                after.next = curr;
                after = after.next;
            }
            curr = curr.next;
        }
        //after.next非常重要，因为 after.next指向了原来的链表，如果不设置为null,会在链表上形成环
        after.next = null;
        before.next = after_head.next;

        return before_head.next;
    }

    public static void main(String[] args) {

        Partition m = new Partition();

        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        m.partition(head,3);
    }
}

package com.husd.leetcode.linkedlist;

/**
 * 138. 复制带随机指针的链表
 * <p>
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 要求返回这个链表的 深拷贝。 
 * <p>
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * <p>
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *  
 * <p>
 * 提示：
 * <p>
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class CopyRandomList {

    //TODO 值得一看

    //
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node current = head;
        // A-B-C-D
        // A- A1 - B - B1 - C - C1 - D - D1
        while (current != null) {
            Node n = new Node(current.val);
            n.random = current.random;

            n.next = current.next;
            current.next = n;

            current = n.next;
        }

        current = head;
        Node res = current.next;
        while (current != null) {
            if (current.random != null) {
                res.random = current.random.next;
            }
            current = current.next.next;
            res = res.next == null ? null : res.next.next;
        }

        // current = head;
        // while(current != null) {
        //     System.out.println(current.val + " " + (current.random == null ? null : current.random.val));
        //     current = current.next;
        // }

        current = head;
        Node a = current.next;
        res = current.next;
        // A- A1 - B - B1 - C - C1 - D - D1
        while (current != null) {
            //System.out.println(current.val + " " + (current.random == null ? null : current.random.val));
            current.next = current.next.next;
            res.next = res.next == null ? null : res.next.next;

            current = current.next;
            res = res.next;
        }
        return a;
    }
}

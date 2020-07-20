package com.husd.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class InorderTraversal {

    //递归 不写了，因为太简单
    //写用栈 中序遍历 核心思想是把节点，让入栈中
    //由于是中序，所以先把中间的入栈，然后再把左入栈，再右
    // 由于栈的特点，左会先出战，然后中 然后右 达到了中序的目的
    //TODO 重点看
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || stack.isEmpty() == false) {
            //中间的先入栈 后出 再把左边的入栈
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    public void recursion(TreeNode root, List<Integer> res) {

        if (root == null) return;
        recursion(root.left, res);
        res.add(root.val);
        recursion(root.right, res);
    }
}

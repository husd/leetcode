package com.husd.leetcode.recursion;

import com.husd.leetcode.entry.TreeNode;

/**
 * 面试题 17.12. BiNode
 *
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 *
 * 返回转换后的单向链表的头节点。
 *
 * 注意：本题相对原题稍作改动
 *
 *  
 *
 * 示例：
 *
 * 输入： [4,2,5,1,3,null,6,0]
 * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 * 提示：
 *
 * 节点数量不会超过 100000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binode-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class ConvertBiNode {

    //TODO 值得一看
    public TreeNode convertBiNode(TreeNode root) {

        if(root == null) {
            return null;
        }
        TreeNode subRoot = convertBiNode(root.left);
        if(subRoot == null) {
            subRoot = root;
        } else {
            TreeNode subRootTmp = subRoot;
            while (subRoot.right != null) {
                subRoot = subRoot.right;
            }
            subRoot.right = root;
            subRoot = subRootTmp;
        }
        root.left = null;
        root.right = convertBiNode(root.right);
        return subRoot;
    }

}

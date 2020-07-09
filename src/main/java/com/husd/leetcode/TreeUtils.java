package com.husd.leetcode;

import com.google.common.collect.Lists;
import com.husd.leetcode.entry.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hushengdong
 */
public class TreeUtils {

    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    public static TreeNode mockTree() {

        TreeNode treeNode = mockTreeNode(3);
        treeNode.left = mockTreeNode(9);
        treeNode.right = mockTreeNode(20);
        treeNode.right.left = mockTreeNode(15);
        treeNode.right.right = mockTreeNode(7);
        return treeNode;
    }

    public static TreeNode mockTreeNode(int n) {

        return new TreeNode(n);
    }

    //DFS 搜索算法
    //一共有3中遍历方式

    // 前 中 后
    // 前： 根节点、左子树、右子树
    // 中： 左子树、根节点、右子树
    // 后： 左子树、右子树、根节点

    //可以先用简单的递归
    public static List<Integer> pre(TreeNode head) {

        if (head == null) {
            return Lists.newArrayList();
        }
        List<Integer> res = new ArrayList<>(10);
        res.add(head.val);
        if (head.left != null) {
            res.addAll(pre(head.left));
        }
        if (head.right != null) {
            res.addAll(pre(head.right));
        }
        return res;
    }

    public static List<Integer> mid(TreeNode head, List<Integer> res) {

        if (head == null) {
            return res;
        }
        if (head.left != null) {
            res.addAll(mid(head.left, res));
        }
        res.add(head.val);
        if (head.right != null) {
            res.addAll(mid(head.right, res));
        }
        return res;
    }

    public static List<Integer> last(TreeNode head) {

        if (head == null) {
            return Lists.newArrayList();
        }
        List<Integer> res = new ArrayList<>(10);
        if (head.left != null) {
            res.addAll(last(head.left));
        }
        if (head.right != null) {
            res.addAll(last(head.right));
        }
        res.add(head.val);
        return res;
    }


}

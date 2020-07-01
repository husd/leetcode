package com.husd.leetcode.tree;

import com.google.common.collect.Lists;
import com.husd.leetcode.TreeUtils;
import com.husd.leetcode.entry.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 遍历树
 *
 * @author hushengdong
 */
public class TreeView {

    //一共有3中遍历方式

    // 前 中 后
    // 前： 根节点、左子树、右子树
    // 中： 左子树、根节点、右子树
    // 后： 左子树、右子树、根节点

    //可以先用简单的递归
    public List<Integer> pre(TreeNode head) {

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

    public List<Integer> mid(TreeNode head) {

        if (head == null) {
            return Lists.newArrayList();
        }
        List<Integer> res = new ArrayList<>(10);
        if (head.left != null) {
            res.addAll(pre(head.left));
        }
        res.add(head.val);
        if (head.right != null) {
            res.addAll(pre(head.right));
        }
        return res;
    }

    public List<Integer> last(TreeNode head) {

        if (head == null) {
            return Lists.newArrayList();
        }
        List<Integer> res = new ArrayList<>(10);
        if (head.left != null) {
            res.addAll(pre(head.left));
        }
        if (head.right != null) {
            res.addAll(pre(head.right));
        }
        res.add(head.val);
        return res;
    }

    public static void main(String[] args) {

        TreeView treeView = new TreeView();

        TreeNode t = TreeUtils.mockTree();

        System.out.println("前序遍历： " + treeView.pre(t));
        System.out.println("中序遍历： " + treeView.mid(t));
        System.out.println("后序遍历： " + treeView.last(t));
    }
}

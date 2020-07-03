package com.husd.leetcode.recursion;

import com.husd.leetcode.entry.TreeNode;

import java.util.*;

/**
 * 894. 所有可能的满二叉树
 * <p>
 * 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
 * <p>
 * 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
 * <p>
 * 答案中每个树的每个结点都必须有 node.val=0。
 * <p>
 * 你可以按任何顺序返回树的最终列表。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：7
 * 输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-possible-full-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AllPossibleFBT {

    Map<Integer, List<TreeNode>> memo = new HashMap();

    //TODO 值得一看
    public List<TreeNode> allPossibleFBT(int N) {
        if (!memo.containsKey(N)) {
            List<TreeNode> ans = new LinkedList();
            if (N == 1) {
                ans.add(new TreeNode(0));
            } else if (N % 2 == 1) {
                for (int x = 0; x < N; ++x) {
                    int y = N - 1 - x;
                    for (TreeNode left : allPossibleFBT(x))
                        for (TreeNode right : allPossibleFBT(y)) {
                            TreeNode bns = new TreeNode(0);
                            bns.left = left;
                            bns.right = right;
                            ans.add(bns);
                        }
                }
            }
            memo.put(N, ans);
        }
        return memo.get(N);
    }


    List<TreeNode> res = null;

    //TODO 值得一看
    public List<TreeNode> allPossibleFBT1(int N) {

        res = new ArrayList<>();
        if (N < 3) return res;
        //偶数个节点，不能满足条件
        if ((N & 1) == 0) return res;
        return init(N);
    }

    // n = 3 有 2 个叶子节点
    // n = 5 3
    // n = 7 4
    private List<TreeNode> init(int n) {

        List<TreeNode> res = new ArrayList<>(n);
        if (n == 3) {
            TreeNode t = new TreeNode(0);
            t.left = new TreeNode(0);
            t.right = new TreeNode(0);
            res.add(t);
            return res;
        }
        //n 有 n+1个叶子节点，找到这些叶子节点
        List<TreeNode> subTree = init(n - 2);
        List<TreeNode> newTree = new ArrayList<>(n - 4 + 1);
        for (TreeNode t : subTree) {
            List<TreeNode> subsubTree = createNew(t);
            newTree.addAll(subsubTree);
        }
        return newTree;
    }

    private List<TreeNode> createNew(TreeNode t) {

        List<TreeNode> res = new ArrayList<>(10);
        dfs(t, res, t);
        return res;
    }

    private void dfs(TreeNode t, List<TreeNode> res, TreeNode root) {

        if (t.left == null && t.right == null) {
            t.left = new TreeNode(0);
            t.right = new TreeNode(0);
            res.add(root);
        } else {
            dfs(t.left, res, t.left.left == null ? copyTree(root) : root);
            dfs(t.right, res, t.right.right == null ? copyTree(root) : root);
        }
    }

    private TreeNode copyTree(TreeNode root) {

        TreeNode t = new TreeNode(0);
        dfsCopy(root, t);
        return t;
    }

    private void dfsCopy(TreeNode from, TreeNode to) {

        if (from == null) return;

        to.left = new TreeNode(0);
        to.right = new TreeNode(0);

        dfsCopy(from.left, to.left);
        dfsCopy(from.right, to.right);
    }

    private TreeNode mockT() {

        TreeNode t = new TreeNode(0);
        t.left = new TreeNode(0);
        t.right = new TreeNode(0);
        return t;
    }

    public static void main(String[] args) {

        TreeNode t = new TreeNode(0);
        System.out.println(1);

        AllPossibleFBT m = new AllPossibleFBT();
        m.allPossibleFBT(5);
    }

}

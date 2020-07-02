package com.husd.leetcode.recursion;

import com.husd.leetcode.entry.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 894. 所有可能的满二叉树
 *
 * 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
 *
 * 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
 *
 * 答案中每个树的每个结点都必须有 node.val=0。
 *
 * 你可以按任何顺序返回树的最终列表。
 *
 *  
 *
 * 示例：
 *
 * 输入：7
 * 输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-possible-full-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AllPossibleFBT {

    List<TreeNode> res = null;

    //TODO 值得一看
    public List<TreeNode> allPossibleFBT(int N) {

        res = new ArrayList<>();

        return res;
    }

    // n = 1 有 2 个叶子节点
    // n = 2 3
    // n = 3 4
    private List<TreeNode> init(int n) {

        List<TreeNode> res = new ArrayList<>(n);
        if(n == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        //n 有 n+1个叶子节点，找到这些叶子节点
        List<TreeNode> subTree = init(n-1);
        for(TreeNode t : subTree) {

        }
        return null;
    }

}

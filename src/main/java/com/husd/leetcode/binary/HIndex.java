package com.husd.leetcode.binary;

import java.util.Arrays;

/**
 *
 * 275. H指数 II
 *
 给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。

 h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数 不超过 h 次。）

 例如：某人的 h 指数是 20，这表示他已发表的论文中，每篇被引用了至少 20 次的论文总共有 20 篇。

  

 示例：

 输入：citations = [3,0,6,1,5]
 输出：3
 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
      由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
  

 提示：如果 h 有多种可能的值，h 指数是其中最大的那个。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/h-index
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HIndex {

    //思考这道题的本质是什么
    //非常值得一看
    public int hIndex(int[] citations) {

        // 排序（注意这里是升序排序，因此下面需要倒序扫描）
        Arrays.sort(citations);
        // 线性扫描找出最大的 i
        int i = 0;
        while (i < citations.length && citations[citations.length - 1 - i] > i) {
            i++;
        }
        return i;
    }

    //TODO 重点学习
    //剪枝的思路
    public int hIndex2(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];
        // 计数
        for (int c: citations)
            papers[Math.min(n, c)]++;
        // 找出最大的 k
        int k = n;
        for (int s = papers[n]; k > s; s += papers[k])
            k--;
        return k;
    }

}

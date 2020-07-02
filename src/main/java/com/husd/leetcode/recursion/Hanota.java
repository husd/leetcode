package com.husd.leetcode.recursion;

import java.util.List;

/**
 * 面试题 08.06. 汉诺塔问题
 * <p>
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 * <p>
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 * <p>
 * 你需要原地修改栈。
 * <p>
 * 示例1:
 * <p>
 * 输入：A = [2, 1, 0], B = [], C = []
 * 输出：C = [2, 1, 0]
 * 示例2:
 * <p>
 * 输入：A = [1, 0], B = [], C = []
 * 输出：C = [1, 0]
 * 提示:
 * <p>
 * A中盘子的数目不大于14个。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hanota-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class Hanota {


    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {

        hanota1(A.size(), A, B, C);
    }

    // 2 1 0
    //用递归
    public void hanota1(int n, List<Integer> A, List<Integer> B, List<Integer> C) {

        if (n == 1) {
            C.add(A.get(A.size() - 1));
            A.remove(A.size() - 1);
        } else {
            hanota1(n - 1, A, C, B);
            C.add(A.get(A.size() - 1));
            A.remove(A.size() - 1);
            hanota1(n - 1, B, A, C);
        }
    }

    //用栈
    //TODO 尝试一下
    public void hanota2(List<Integer> A, List<Integer> B, List<Integer> C) {


    }
}

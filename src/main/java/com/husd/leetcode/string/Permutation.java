package com.husd.leetcode.string;

import java.util.ArrayList;

/**
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 * <p>
 * 示例1:
 * <p>
 * 输入：S = "qwe"
 * 输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 * 示例2:
 * <p>
 * 输入：S = "ab"
 * 输出：["ab", "ba"]
 * 提示:
 * <p>
 * 字符都是英文字母。
 * 字符串长度在[1, 9]之间。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-i-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class Permutation {

    public ArrayList<String> permutation(String str) {
        ArrayList<String> ans = new ArrayList<>();//所有排列的可能都在这里
        if (str != null || str.length() > 0) {
            backtracking(0, str.toCharArray(), ans);
        }
        return ans;
    }

    public void backtracking(int i, char[] cha, ArrayList<String> ans) {
        if (i == cha.length - 1) {
            String val = String.valueOf(cha);
            if (!ans.contains(val)) {
                ans.add(val);
            }
        } else {
            for (int j = i; j < cha.length; j++) {
                swap(i, j, cha);//依次选一个数固定住
                backtracking(i + 1, cha, ans);//让后面的进行全排列
                swap(i, j, cha);//恢复原来的模样，回溯关键
            }
        }

    }

    public void swap(int i, int j, char[] cha) {
        char temp = cha[i];
        cha[i] = cha[j];
        cha[j] = temp;
    }

}

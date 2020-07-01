package com.husd.leetcode.bit;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 1239. 串联字符串的最大长度
 * <p>
 * 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
 * <p>
 * 请返回所有可行解 s 中最长长度。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = ["un","iq","ue"]
 * 输出：4
 * 解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
 * 示例 2：
 * <p>
 * 输入：arr = ["cha","r","act","ers"]
 * 输出：6
 * 解释：可能的解答有 "chaers" 和 "acters"。
 * 示例 3：
 * <p>
 * 输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
 * 输出：26
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] 中只含有小写英文字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class MaxLength {

    //思路比解题更重要
    // 简单来看，就是2个字符串长度加起来，最大
    public int maxLength(List<String> arr) {

        //temp先把字符串操作转为数字操作
        int[] temp = new int[arr.size() + 1];
        //一次性记录好长度
        int[] len = new int[arr.size() + 1];
        String[] t = new String[arr.size() + 1];
        int index = 0;
        for (String s : arr) {
            int x = s2int(s);
            if (x == 0) continue;
            int y = s.length();
            temp[index] = x;
            len[index] = y;
            t[index] = s;
            index++;
        }
        int res = dfs(temp, len, 0, 0);
        return res;
    }

    //TODO 值得一看
    private int dfs(int[] temp, int[] len, int start, int mask) {

        if (start >= temp.length) {
            return 0;
        }
        int res = 0;
        for (int i = start; i < temp.length; i++) {
            if (temp[i] == 0) continue;
            if ((mask & temp[i]) != 0) continue;
            //一。当前子字符位掩码不为0（为0的话证明子字符里面有重复字符）
            //二。当前子字符位掩码与前面字符的位掩码与运算结果为0（如果结果不为0，那么说明与之前的字符串有重复）
            //满足上述两个条件才进入一下层递归。
            res = Math.max(res, dfs(temp, len, i + 1, temp[i] | mask) + len[i]);
        }
        return res;
    }

    public static int s2int(String s) {

        int res = 0;
        for (char c : s.toCharArray()) {
            //int a = (int) c - (int) 'a';
            int a = (int) c - 97;
            int res1 = res | (1 << a);
            if (res1 == res) {
                return 0;
            } else {
                res = res1;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        MaxLength m = new MaxLength();
        List<String> list = new ArrayList<>();
        list.add("abcdefghijklmnopqrstuvwxyz");
        //String[] a = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p"};
        //String[] a = {"un", "iq", "ue"};
        //String[] a = {"cha", "r", "act", "ers"};
        //String[] a = {"a", "abc", "d", "de", "def"};
        //String [] a= {"ab","ba","cd","dc","ef","fe","gh","hg","ij","ji","kl","lk","mn","nm","op","po"};
        String[] a = {"a", "abc", "d", "de", "def"};
        m.maxLength(Lists.newArrayList(a));
    }
}

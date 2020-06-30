package com.husd.leetcode.bit;

/**
 * 318. 最大单词长度乘积
 * <p>
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 * 示例 2:
 * <p>
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * 示例 3:
 * <p>
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class MaxProduct {

    //往往都是最直观的办法
    public int maxProduct(String[] words) {

        int max = 0;
        int len = words.length;
        int[] num = new int[len];
        int[] lenArray = new int[len];

        for (int i = 0; i < len; i++) {
            num[i] = s2int(words[i]);
            lenArray[i] = words[i].length();
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                //可以考虑剪枝
                if ((num[i] & num[j]) == 0) {
                    max = Math.max(max, lenArray[i] * lenArray[j]);
                }
            }
        }
        return max;
    }

    private int s2int(String s) {

        int res = 0;
        for (char c : s.toCharArray()) {
            //int a = (int) c - (int) 'a';
            int a = (int) c - 97;
            res |= (1 << a);
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println((int) 'a');
    }
}

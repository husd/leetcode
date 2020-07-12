package com.husd.leetcode.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
 *
 * 若无答案，则返回空字符串。
 *
 * 示例 1:
 *
 * 输入:
 * words = ["w","wo","wor","worl", "world"]
 * 输出: "world"
 * 解释:
 * 单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
 * 示例 2:
 *
 * 输入:
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * 输出: "apple"
 * 解释:
 * "apply"和"apple"都能由词典中的单词组成。但是"apple"得字典序小于"apply"。
 * 注意:
 *
 * 所有输入的字符串都只包含小写字母。
 * words数组长度范围为[1,1000]。
 * words[i]的长度范围为[1,30]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestWord {

    public String longestWord(String[] words) {

        Map<String,Integer> m = new HashMap<>();
        Set<String> mm =new HashSet<>();
        int res = Integer.MAX_VALUE;
        int len = Integer.MIN_VALUE;
        for(int i=0;i<words.length;++i) {
            m.put(words[i],i);
        }
        for(int i=0;i<words.length;++i) {
            String s= words[i];
            boolean c = mm.contains(s.substring(0,s.length() - 1));
            if(!c) {
                int a = 1;
                while(a < s.length() && m.containsKey(s.substring(0,a))) {
                    a++;
                }
                c =  a == s.length();
            }

            if(c) {
                mm.add(s.substring(0,s.length() - 1));
                if(s.length() > len) {
                    res = i;
                    len = s.length();
                } else if(s.length() == len) {
                    if(words[i].compareTo(words[res]) < 0) {
                        res = i;
                    }
                }
            }
        }
        if(res == Integer.MAX_VALUE) {
            return "";
        }
        return words[res];
    }

    public static void main(String[] args) {

        LongestWord  m = new LongestWord();
        String [] arr = {"t","ti","tig","tige","tiger","e","en","eng","engl","engli","englis","english","h","hi","his","hist","histo","histor","history"};
        String s = m.longestWord(arr);
        System.out.println(s);
    }
}

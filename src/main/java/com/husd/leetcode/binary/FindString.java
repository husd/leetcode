package com.husd.leetcode.binary;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 10.05. 稀疏数组搜索
 *
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 *
 * 示例1:
 *
 *  输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 *  输出：-1
 *  说明: 不存在返回-1。
 * 示例2:
 *
 *  输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 *  输出：4
 * 提示:
 *
 * words的长度在[1, 1000000]之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sparse-array-search-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindString {

    public int findString(String[] words, String s) {
        int left = 0;
        int right = words.length - 1;
        int mid;
        while (left <= right){
            //如果最左边空字符串，跳过空串
            while (words[left].length() == 0){
                left ++;
            }
            //如果最右边空字符串，跳过空串
            while (words[right].length() == 0){
                right --;
            }
            mid = (left + right) / 2;
            //如果mid位置字符串为空串，mid--，直到不是空串
            while (mid >= 0 && words[mid].length() == 0){
                mid --;
            }
            if(words[mid].compareTo(s) == 0){
                return mid;
            }else if(words[mid].compareTo(s) > 0){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int findString2(String[] words, String s) {

        Map<String,Integer> m = new HashMap<>();
        for(int i=0;i<words.length;i++) {
            if(words[i].length() > 0) {
                m.put(words[i],i);
            }
        }
        return m.getOrDefault(s,-1);
    }
}

package com.husd.leetcode.binary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 349. 两个数组的交集
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 *
 * 说明：
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Intersection {

    //没劲 垃圾题目
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();//如果数据量大，应当考虑TreeSet
        for (Integer n : nums1) set1.add(n);
        List<Integer> list = new ArrayList<Integer>();
        for (Integer n : nums2) {
            if(set1.contains(n)){
                list.add(n);
                set1.remove(n);
            }
        }
        int[] output =new int[list.size()];
        for(int i=0;i<list.size();i++){
            output[i]=list.get(i);
        }
        return output;
    }
}

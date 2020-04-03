package com.husd.leetcode.hard;

/**
 * 打印当前值和前面一个值
 * <p>
 * 有一个数组，例如：[1,2,3,4,5] 你需要逐次打印当前元素和它的前一个元素，例如:
 * <p>
 * 0 1
 * 1 2
 * 2 3
 * 3 4
 * <p>
 * 注意，只能使用一个变量，而且，不可以用数组下标访问的方式，获取前一个值
 *
 * @author hushengdong
 * @date 2020/4/3
 */
public class RemembersPre {

    public void printPreNum(int[] nums) {

        int a = 0;
        for (int item : nums) {
            System.out.println(a + " " + item);
            a = item;
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};
        RemembersPre remembersPre = new RemembersPre();
        remembersPre.printPreNum(nums);
    }
}

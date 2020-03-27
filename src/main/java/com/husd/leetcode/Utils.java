package com.husd.leetcode;

/**
 * 这里是这个类的功能描述
 *
 * @author hushengdong
 * @date 2020/3/27
 */
public class Utils {

    /**
     * 判断一个整数在乘以10之后，是否会溢出的方法
     *
     * @param num
     * @return
     */
    public boolean tooBig(int num) {

        return (num * 10) / 10 != num;
    }
}

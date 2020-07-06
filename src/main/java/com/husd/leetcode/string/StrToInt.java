package com.husd.leetcode.string;

/**
 * 这里是这个类的功能描述
 *
 * @author hushengdong
 */
public class StrToInt {

    //TODO 值得一看
    public int strToInt(String str) {

        char[] c = str.trim().toCharArray();
        //特殊情况
        if (c.length == 0) return 0;
        //准备好结果 边界值
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        //sign表示正负
        int i = 1, sign = 1;
        if (c[0] == '-') {
            sign = -1;
        } else if (c[0] != '+') {
            //如果没有+,要把i设置为0 ，从头开始计算
            i = 0;
        }

        //2147483647
        //-2147483648
        for (int j = i; j < c.length; j++) {
            //如果不是数字，就需要结束了
            if (c[j] < '0' || c[j] > '9') break;
            // 直接溢出了，或者没溢出，但是最后一个数字已经大于7了，就说明溢出了
            // 直接返回特殊值
            if (res > bndry || (res == bndry && c[j] > '7')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (c[j] - '0');
        }
        return sign == 1 ? res : -res;
    }
}

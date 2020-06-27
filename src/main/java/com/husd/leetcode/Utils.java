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
    public static boolean tooBig(int num) {

        return (num * 10) / 10 != num;
    }

    // 辗转相除法 求最大公约数
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    //求1个数的二进制表示法中，1的个数 结果称为 pop count，或 汉明权重
    //例如： 10010 返回2
    //例如： 10011 返回3
    // n & (n-1) 用来把一个二进制数的最右边1个1，设置为0
    public static int popCount(int n) {

        int res = 0;
        while (n != 0) {
            res++;
            n = n & (n - 1);
        }
        return res;
    }

    //这个是jdk自带的算法 计算一个整数中 2进制表示法的1的个数
    public static int popCountVersion2(int i) {
        // HD, Figure 5-2
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }

    //把一个数字的低位的几个数字设置为0
    public static int setLow0(int num, int count) {

        return (num >> count) << count;
    }

    //把一个数字的高位的几个数字设置为0
    public static int setHigh0(int num, int count) {

        //TODO
        return 0;
    }

    // 把1个整数的某个位置的位，设置位0
    public static int setPos0(int num, int pos) {

        int b = 1 << (pos - 1);
        return num & ~b;
    }

    // 把1个整数的某个位置的位，设置位1
    public static int setPos1(int num, int pos) {

        int b = 1 << (pos - 1);
        return num | b;
    }

    //获取num的奇数位，把偶数位全部设置位0
    public static int oddBit(int num) {

        //0x55555555 = 0b0101_0101_0101_0101_0101_0101_0101_0101
        return num & 0x55555555;
    }

    //获取num的偶数位，把奇数位全部设置位0
    public static int evenBit(int num) {

        //0xaaaaaaaa = 0b1010_1010_1010_1010_1010_1010_1010_1010
        return num & 0xaaaaaaaa;
    }

    //判断字节长度 ，UTF-8 合法的是 1 - 4
    //判断字节的低位有几个1 11000000 返回2
    //                   10000000
    public static int countN(int num) {

        int mask = 1 << 7;
        int res = 0;
        while((num & mask) > 0) {
            res++;
            mask = mask >> 1;
        }
        return res;
    }

    //判断字节是否是10开头的 例如 1010000 1011111
    public static boolean valid10(int num) {

        int mask1 = 1 << 7;
        int mask2 = 1 << 6;
        return (num & mask1) > 0 && ((num & mask2) == 0);
    }

    //是否是2的幂次方 2的幂次方，表示是数字只有1个1
    // 100000000
    // 1000 这种的
    public static boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long x = (long) n;
        return (x & (x - 1)) == 0;
    }

    public static boolean isPowerOfFour(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0xaaaaaaaa) == 0);
    }
}

package com.husd.leetcode;

/**
 * 位操作的一些需要知道的基础理论知识
 * <p>
 * 异或操作 :
 * n = n ^ 0 n是任意一个值
 * <p>
 * // 101 ^ 111 = 010 是不是看到了～？
 * <p>
 * 位操作的一些基础知识
 * 尤其是异或
 * <p>
 * 0 ^ n = n
 * n ^ n = 0
 *
 * @author hushengdong
 * @date 2020/3/27
 */
public class BitUtils {

    /**
     * 判断一个整数在乘以10之后，是否会溢出的方法
     *
     * @param num
     * @return
     */
    public static boolean tooBig(int num) {

        return (num * 10) / 10 != num;
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

    // 把1个整数的某个位置的位，设置位0 pos是从右向左计算
    // 比如: 11的2进制表示法是 1011 要把第2位，设置为0 变成: 1001
    // setPos0(11,2)
    // 首先要构造1个数字 1101 因为 1011 & 1101 = 1001
    // 因为 1101 = 0010 取反，所以第2位就是 1 << (pos -1) 之后，再取反
    public static int setPos0(int num, int pos) {

        int b = 1 << (pos - 1);
        return num & ~b;
    }

    // 把1个整数的某个位置的位，设置位1
    //拿11举例: 1011 把第2位设置位1 就是 1011 ｜ 0010
    //0010 = 1 << (pos -1) 所以很容易理解
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
        while ((num & mask) > 0) {
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

    // 讨论下 x & -x 的结果
    // 10进制下的 11 :                             1011
    // -11         : 11111111111111111111111111110101

    //因为负数，使用正数，取反 +1 得到的 ，所以 x & -x 就得到了该值最右边的1个1
    public static int rightDiff1(int num) {

        return num & (-num);
    }

    //求绝对值，注意 31是因为int是32位
    public static int abs(int num) {

        return (num ^ (num >> 31)) - (num >> 31);
    }

    //判断1个数字是奇数
    public static boolean isOddNum(int n) {

        return (n & 1) == 1;
    }

    //判断1个数字是偶数
    public static boolean isEvenNum(int n) {

        return (n & 1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}

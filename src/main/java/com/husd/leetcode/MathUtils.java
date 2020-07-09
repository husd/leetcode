package com.husd.leetcode;

/**
 * 数学问题 多 而且杂 不建议深入学
 * <p>
 * 1： 开平方 3种方法：递归 二分查找 牛顿迭代法
 * 2：求数组的所有排列组合 ，给一个数组 int[] arr ，求arr的所有可能排列组合 （重要） 是很多题目的暴力解法
 * 3：离散数学的模幂算法 怎么高效的计算 N 的 M 次方
 * <p>
 * 计算 N 的 M次方 通常需要 M 次乘法, 当M特别大的时候, 运算效率很低.
 * 可以尝试 例如 N 的14次方 14 = 2b1110 = 1 * 2^3 + 1 * 2^2 + 1 * 2^1 + 0 * 2^0
 * 所以 N ^ 14 = N ^2 ^3 * N ^2 ^2 * N ^2^1 这样能减少乘法的次数
 * <p>
 * 4：二分查找中，我们求中点索引时用 (l+r)/2 转化成 l+(r-l)/2，避免溢出的同时得到正确的结果
 * 5：数学运算中，要注意整数溢出的问题
 * 6：如果要计算 N % M 的值，但是N的值可能会特别大，需要用到1个公式 (a * b) % k = (a % k)(b % k) % k
 * 7：求N % M 余运算在M = 2的整数幂次方是有技巧的 例如:
 * N % 2 = N & 01 = N & 1
 * N % 4 = N & 011 = N & 3
 * N % 16 = N & 0111 = N & 15
 *
 * 8：n以内的所有素数 如果n不是很大的话，是可以优化的 可以声明1个数组或者其它结构
 * 假设是 int [] a = new int[n]
 * 我们知道2 3都是素数，那么从2开始 : index = 3;
 * while(index <= n) {
 *      int s = 1;
 *     while(s <= n) {
 *      int inx = index * s;
 *      //a[inx]设置为1 ，表示这个数字不是素数
 *      a[inx] = 1;
 *      s++
 *     }
 * }
 * 这样就能知道n以内的所有素数了
 *
 * 9： 判断单个数字是不是素数
 *
 *
 *
 * @author hushengdong
 */
public class MathUtils {

    //2分法，求中间
    public static int mid(int h, int l) {

        return l + (h - l) / 2;
    }

    //绳子切 3刀 或者4刀 乘最大
    public int cuttingRope(int n) {
        return n <= 3 ? n - 1 : (int) Math.pow(3, n / 3) * 4 / (4 - n % 3);
    }

    //三角形 a b c能组成三角形的条件
    public boolean sanjiaoxing(int a, int b, int c) {

        //2个边长和大于第三边
        return b + c > a;
    }


    public int maxInt() {

        return 2147483647;
    }

    public int minInt() {

        return -2147483648;
    }

    // 辗转相除法 求最大公约数
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // 开平方 简单计算器方法
    public static int sqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }

    // 开平方 2分
    public static int sqrt2(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    //开平方 牛顿迭代方法
    //TODO 值得一看 重点学习
    public static int sqrt3(int x) {

        if (x == 0) {
            return 0;
        }
        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }

    //计算高斯和 计算从1到N的和
    public static int sum(int n) {

        return n * (n + 1) / 2;
    }

}

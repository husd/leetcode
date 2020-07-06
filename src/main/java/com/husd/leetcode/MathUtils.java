package com.husd.leetcode;

/**
 * 数据
 * <p>
 * //开平方 3种方法：递归 二分查找 牛顿迭代法
 * //
 *
 * @author hushengdong
 */
public class MathUtils {

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
}

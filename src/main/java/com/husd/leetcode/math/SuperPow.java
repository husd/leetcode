package com.husd.leetcode.math;

/**
 * 372. 超级次方
 * <p>
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = 2, b = [3]
 * 输出: 8
 * 示例 2:
 * <p>
 * 输入: a = 2, b = [1,0]
 * 输出: 1024
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-pow
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class SuperPow {

    //这个算法其实就是广泛应用于离散数学的模幂算法，这道题可以有三个难点：
    //一是如何处理用数组表示的指数，现在 b 是一个数组，也就是说 b 可以非常大，
    // 没办法直接转成整型，否则可能溢出。你怎么把这个数组作为指数，进行运算呢？
    //二是如何得到求模之后的结果？按道理，起码应该先把幂运算结果算出来，然后做 % 1337 这个运算。
    // 但问题是，指数运算你懂得，真实结果肯定会大得吓人，也就是说，算出来真实结果也没办法表示，早都溢出报错了。
    //三是如何高效进行幂运算，进行幂运算也是有算法技巧的，
    int base = 1337;

    //10次方的缓存
    int[] cache = new int[1338];

    public int superPow(int a, int[] b) {

        return sp(a, b, b.length - 1);
    }

    int sp(int a, int[] b, int idx) {

        if (idx < 0) return 1;
        int last = b[idx];
        int part1 = mypow(a, last);
        int part2 = mypow(sp(a, b, idx - 1), 10);
        // 每次乘法都要求模
        return (part1 * part2) % base;
    }

    // 计算 a 的 k 次方
    int mypow(int a, int k) {

        //因为a的范围是在1337 之内，所以可以缓存
        if (a < 1338 && k == 10 && cache[a] != 0) {
            return cache[a];
        }

        // 对因子求模
        a = a % base;
        int res = 1;
        for (int i = 0; i < k; i++) {
            // 这里有乘法，是潜在的溢出点
            res *= a;
            // 对乘法结果求模
            res = res % base;
        }
        if (a < 1338 && k == 10) {
            cache[a] = res;
        }
        return res;
    }

    private int eular(int n) {
        int ans = n;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                ans = ans / i * (i - 1);
                while (n % i == 0) n /= i;
            }
        }
        if (n > 1) ans = ans / n * (n - 1);
        return ans;
    }

    public static void main(String[] args) {

        SuperPow m = new SuperPow();
        int a = m.eular(1337);
        System.out.println(a);
    }
}

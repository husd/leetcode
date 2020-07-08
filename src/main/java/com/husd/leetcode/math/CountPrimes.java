package com.husd.leetcode.math;

/**
 * 204. 计数质数
 * <p>
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 * @author hushengdong
 */
public class CountPrimes {

    public int countPrimes(int n) {

        if(n < 2) return 0;
        int count = 0;
        for (int i = 2; i <= n; i++)
            if (primes(i)) count++;
        return count;
    }

    boolean primes(int n) {

        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                // 有其他整除因子
                return false;
        return true;
    }

    public static void main(String[] args) {

        CountPrimes m = new CountPrimes();
        int a = m.countPrimes(10);
        System.out.println(a);
    }
}

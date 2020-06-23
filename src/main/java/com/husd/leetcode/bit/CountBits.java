package com.husd.leetcode.bit;

/**
 * 338. 比特位计数
 * <p>
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 * <p>
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class CountBits {

    //思路： 时间复杂度为O(n*sizeof(integer))的解答非常容易 直接按顺序求每一个整数的
    //1的数量就行了 如果要O（N）的话，意味着每个数字只需要计算一遍
    //前一个数字和后一个数字的1的个数，肯定是有关系的
    //动态规划？
    //如果要用动态规划，就要写出状态变化方程式
    //假设结果是 int [] res = {};
    // res[i] = res[i-x] + y;
    //最直观的假设，就是根据res[i-x] + y来计算

    //P(x+b)=P(x)+1,b=2^m > x
    public int[] countBits(int num) {

        int[] ans = new int[num + 1];
        int i = 0, b = 1;
        while (b < num) {
            while (i < b && i + b <= num) {
                ans[i + b] = ans[i] + 1;
                ++i;
            }
            i = 0;   // reset i
            b <<= 1; // b = 2b
        }
        return ans;
    }

    //还是动态规划的思路
    //P(x)=P(x/2)+(x mod 2)
    // 0101010101 = p(x)
    // 010101010 = p(x/2) + (x mod 2)
    public int [] countBits2(int num) {

        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            ans[i] = ans[i >> 1] + (i & 1); // x / 2 is x >> 1 and x % 2 is x & 1
        return ans;
    }

    //这个就是 O(n*sizeof(integer)) 的解答
    public int[] countBits1(int num) {

        int[] a = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            a[i] = count1(i);
        }
        return a;
    }

    public int count1(int n) {

        int res = 0;
        while (n != 0) {
            res++;
            n = n & (n - 1);
        }
        return res;
    }
}

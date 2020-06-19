package com.husd.leetcode.simple;

/**
 * 面试题 17.01. 不用加号的加法
 * <p>
 * 设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。
 * <p>
 * 示例:
 * <p>
 * 输入: a = 1, b = 1
 * 输出: 2
 *  
 * <p>
 * 提示：
 * <p>
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-without-plus-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 * @tag 位运算
 */
public class AddWithoutPlus {

    //位运算版本
    public int add(int a, int b) {

        //进位
        int c = (a & b) << 1;
        int resu = a ^ b;
        while (c != 0) {
            int old_resu = resu;
            resu = resu ^ c;
            c = (old_resu & c) << 1;
        }
        return resu;
    }

    public static void main(String[] args) {

        AddWithoutPlus addWithoutPlus = new AddWithoutPlus();

        System.out.println(addWithoutPlus.add(111, 899));
    }

    //搞笑版本
    public int add2Funny(int a, int b) {

        return a - (-b);
    }

}

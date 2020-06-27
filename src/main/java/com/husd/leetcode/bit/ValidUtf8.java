package com.husd.leetcode.bit;

/**
 * 393. UTF-8 编码验证
 *
 * UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：
 *
 * 对于 1 字节的字符，字节的第一位设为0，后面7位为这个符号的unicode码。
 * 对于 n 字节的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为0，后面字节的前两位一律设为10。剩下的没有提及的二进制位，全部为这个符号的unicode码。
 * 这是 UTF-8 编码的工作方式：
 *
 *  Char. number range  |        UTF-8 octet sequence
 *       (hexadecimal)    |              (binary)
 *    --------------------+---------------------------------------------
 *    0000 0000-0000 007F | 0xxxxxxx
 *    0000 0080-0000 07FF | 110xxxxx 10xxxxxx
 *    0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
 *    0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
 *
 * 给定一个表示数据的整数数组，返回它是否为有效的 utf-8 编码。
 *
 * 注意:
 * 输入是整数数组。只有每个整数的最低 8 个有效位用来存储数据。这意味着每个整数只表示 1 字节的数据。
 *
 * 示例 1:
 *
 * data = [197, 130, 1], 表示 8 位的序列: 11000101 10000010 00000001.
 *
 * 返回 true 。
 * 这是有效的 utf-8 编码，为一个2字节字符，跟着一个1字节字符。
 * 示例 2:
 *
 * data = [235, 140, 4], 表示 8 位的序列: 11101011 10001100 00000100.
 *
 * 返回 false 。
 * 前 3 位都是 1 ，第 4 位为 0 表示它是一个3字节字符。
 * 下一个字节是开头为 10 的延续字节，这是正确的。
 * 但第二个延续字节不以 10 开头，所以是不符合规则的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/utf-8-validation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidUtf8 {

    public boolean validUtf8(int[] data) {

        //先判断是几个字节
        int n = 0;
        boolean valid = false;
        for(int i=0;i<data.length;i++) {
            int current = data[i];
            if(n == 0) {
                n = countN(current);
                valid = (n == 0 || n == 2 || n == 3 || n == 4);
                n = n == 0 ? 0 : n - 1;
            } else {
                valid = valid10(current);
                n--;
            }
            if(valid == false) {
                break;
            }
        }
        return valid && n == 0;
    }

    //判断字节长度 ，UTF-8 合法的是 1 - 4
    //判断字节有几个1 11000000
    //              10000000
    private int countN(int num) {

        int mask = 1 << 7;
        int res = 0;
        while((num & mask) > 0) {
            res++;
            mask = mask >> 1;
        }
        return res;
    }

    //判断字节是否是10开头的
    private boolean valid10(int num) {

        int mask1 = 1 << 7;
        int mask2 = 1 << 6;
        return (num & mask1) > 0 && ((num & mask2) == 0);
    }
}

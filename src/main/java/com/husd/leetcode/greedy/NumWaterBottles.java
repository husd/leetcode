package com.husd.leetcode.greedy;

/**
 * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
 * <p>
 * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
 * <p>
 * 请你计算 最多 能喝到多少瓶酒。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/water-bottles
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class NumWaterBottles {

    //递归 这个方法亲测可以
    public int numWaterBottles(int numBottles, int numExchange) {

        return numWaterBottles(numBottles, numExchange, 0);
    }

    public int numWaterBottles(int numBottles, int numExchange, int empty) {

        if (numBottles + empty < numExchange) {
            return numBottles;
        }
        int empty2 = (numBottles + empty) % numExchange;
        int n = (numBottles + empty) / numExchange;
        return numBottles + numWaterBottles(n, numExchange, empty2);
    }

    //模拟方法
    public int numWaterBottles2(int numBottles, int numExchange) {
        int bottle = numBottles, ans = numBottles;
        while (bottle >= numExchange) {
            bottle = bottle - numExchange;
            ++ans;
            //多了一瓶新的
            ++bottle;
        }
        return ans;
    }

    //数学方法
    public int numWaterBottles3(int numBottles, int numExchange) {
        return numBottles >= numExchange ? (numBottles - numExchange) / (numExchange - 1) + 1 + numBottles : numBottles;
    }

}

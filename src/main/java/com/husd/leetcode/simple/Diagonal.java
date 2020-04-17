package com.husd.leetcode.simple;

/**
 * 这个题目不是leetcode的题目，是为了八皇后问题准备的练习题目
 * <p>
 * 八皇后问题，要求计算皇后的位置不能冲突，对于一个棋盘来说，假设有一个1维数组
 * <p>
 * 简单点，我们假设4皇后，数组的每个元素的值表示皇后在对应行的对应列，判断皇后是否有冲突
 * <p>
 * int [] a = {0,1,2,3};
 *
 * @author hushengdong
 * @date 2020/4/17
 */
public class Diagonal {

    //用1维数组表示
    //loc中存的是各个行的 皇后，row表示当前行，判断当前行的皇后是否和其它行的皇后冲突
    public boolean isOk(int[] loc, int row) {

        //遍历每一行
        for (int i = 0; i != row; i++) {
            if (loc[i] == loc[row] || row - loc[row] == i - loc[i] || row + loc[row] == i + loc[i]) {
                return false;
            }
        }
        return true;
    }
}

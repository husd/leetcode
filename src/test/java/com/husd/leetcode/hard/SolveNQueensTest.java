package com.husd.leetcode.hard;

import com.husd.leetcode.math.SolveNQueens;
import org.junit.Test;

public class SolveNQueensTest {

    @Test
    public void solveNQueens() {

        SolveNQueens solution = new SolveNQueens();
        solution.solveNQueens(8);
        System.out.println(solution.total);
    }
}
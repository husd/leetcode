package com.husd.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolveNQueensTest {

    @Test
    public void solveNQueens() {

        SolveNQueens solution = new SolveNQueens();
        solution.solveNQueens(8);
        System.out.println(solution.total);
    }
}
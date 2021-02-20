package com.husd.leetcode.string;

/**
 * 根据当前列索引返回所在excel所在列名称，例如第一列是A，第二列是B 1 return A 2 return B 27 return AA
 *
 * @author hushengdong
 */
public class ExcelColumn {

    private final static String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    private void getLetterNum(StringBuilder sb, int num) {

        if (num < 0) {
            return;
        }
        if (num < 26) {
            sb.append(letters[num]);
            return;
        }
        getLetterNum(sb, num / 26 - 1);
        sb.append(letters[num % 26]);
    }

    public static void main(String[] args) {

        ExcelColumn excelColumn = new ExcelColumn();
        for (int i = 1; i < 100; i++) {
            StringBuilder sb = new StringBuilder();
            excelColumn.getLetterNum(sb, i - 1);
            System.out.println("i:" + i + " col:" + sb.toString());
        }

    }
}

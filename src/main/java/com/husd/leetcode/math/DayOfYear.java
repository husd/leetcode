package com.husd.leetcode.math;

import java.time.LocalDate;

/**
 * 1154. 一年中的第几天
 * <p>
 * 给你一个按 YYYY-MM-DD 格式表示日期的字符串 date，请你计算并返回该日期是当年的第几天。
 * <p>
 * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：date = "2019-01-09"
 * 输出：9
 * 示例 2：
 * <p>
 * 输入：date = "2019-02-10"
 * 输出：41
 * 示例 3：
 * <p>
 * 输入：date = "2003-03-01"
 * 输出：60
 * 示例 4：
 * <p>
 * 输入：date = "2004-03-01"
 * 输出：61
 *  
 * <p>
 * 提示：
 * <p>
 * date.length == 10
 * date[4] == date[7] == '-'，其他的 date[i] 都是数字。
 * date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/day-of-the-year
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class DayOfYear {

    public int dayOfYear(String date) {

        LocalDate localDate = LocalDate.parse(date);
        return localDate.getDayOfYear();
    }

    //常规思路
    public int dayOfYear2(String date) {

        int year = Integer.parseInt(date.substring(0, 4));
        String m = date.substring(5, 7);
        int month = m.charAt(0) == '0' ? m.charAt(1) - '0' : Integer.parseInt(m);
        String d = date.substring(8, 10);
        int day = d.charAt(0) == '0' ? d.charAt(1) - '0' : Integer.parseInt(d);
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int count = 0;
        for (int i = 0; i < month; i++) {
            count += days[i];
        }

//        if (month == 2) {
//            if (isLeepYear(year)) {
//                day = Math.min(29, day);
//            } else {
//                day = Math.min(28, day);
//            }
//        } else {
//            day = Math.min(days[month], day);
//        }

        return isLeepYear(year) && month > 2 ? (count + day + 1) : (count + day);
    }

    private boolean isLeepYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void main(String[] args) {

        DayOfYear m = new DayOfYear();
        int d = m.dayOfYear2("2016-02-29");

        System.out.println(d);
    }
}

package com.husd.leetcode.bit;

import java.util.*;

/**
 * 756. 金字塔转换矩阵
 * <p>
 * 现在，我们用一些方块来堆砌一个金字塔。 每个方块用仅包含一个字母的字符串表示。
 * <p>
 * 使用三元组表示金字塔的堆砌规则如下：
 * <p>
 * 对于三元组(A, B, C) ，“C”为顶层方块，方块“A”、“B”分别作为方块“C”下一层的的左、右子块。当且仅当(A, B, C)是被允许的三元组，我们才可以将其堆砌上。
 * <p>
 * 初始时，给定金字塔的基层 bottom，用一个字符串表示。一个允许的三元组列表 allowed，每个三元组用一个长度为 3 的字符串表示。
 * <p>
 * 如果可以由基层一直堆到塔尖就返回 true ，否则返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：bottom = "BCD", allowed = ["BCG", "CDE", "GEA", "FFF"]
 * 输出：true
 * 解析：
 * 可以堆砌成这样的金字塔:
 * A
 * / \
 * G   E
 * / \ / \
 * B   C   D
 * <p>
 * 因为符合('B', 'C', 'G'), ('C', 'D', 'E') 和 ('G', 'E', 'A') 三种规则。
 * 示例 2：
 * <p>
 * 输入：bottom = "AABA", allowed = ["AAA", "AAB", "ABA", "ABB", "BAC"]
 * 输出：false
 * 解析：
 * 无法一直堆到塔尖。
 * 注意, 允许存在像 (A, B, C) 和 (A, B, D) 这样的三元组，其中 C != D。
 *  
 * <p>
 * 提示：
 * <p>
 * bottom 的长度范围在 [2, 8]。
 * allowed 的长度范围在[0, 200]。
 * 方块的标记字母范围为{'A', 'B', 'C', 'D', 'E', 'F', 'G'}。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pyramid-transition-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class PyramidTransition {

    //思路
    // 先把allowed转为set ，计算金字塔的上一层，然后逐个遍历，是否有
    // 还需要有1个前缀的判断 每次只知道前2个,所以要拆分

    //动态规划，从金字塔顶开始推
    //TODO
    public boolean pyramidTransition(String bottom, List<String> allowed) {

        //金字塔的高度
        int n = allowed.size() - 1;
        Map<String, HashSet<Character>> m = new HashMap<String, HashSet<Character>>(128 * 2);
        for (String s : allowed) {
            String key = s.substring(0, 2);
            HashSet<Character> set = m.getOrDefault(key, new HashSet<>());
            set.add(s.charAt(2));
            m.put(key, set);
        }
        int num = bottom.length();
        while (num > 1) {
            int start = 0;
            int end = bottom.length() - 1;
            while (start < end) {
                String c = bottom.substring(start, start + 1);
                //Character t = m.get(c);

                start++;
            }
        }
        return num == 1;
    }

    public boolean pyramidTransition2(String bottom, List<String> allowed) {

        // Map<层数，可以构造的bottom>
        //f(n) = f(n+1) + bottom
        Set<String> exist = new HashSet<>(allowed);
        Map<Integer, HashSet<String>> m = new HashMap<>();
        HashSet<String> set1 = new HashSet<String>();
        Map<String, List<String>> level1Map = new HashMap<>();
        for (String s : allowed) {
            String k = s.substring(0, 2);
            String top = s.substring(2, 3);
            set1.add(k);
            List<String> kList = level1Map.getOrDefault(top, new ArrayList<>(2));
            kList.add(k);
            level1Map.put(top, kList);
        }
        m.put(1, set1);
        for (int i = 2; i < 9; i++) {
            Integer k = i - 1;
            int bottomLength = i + 1;
            HashSet<String> set = new HashSet<String>();
            HashSet<String> allow = m.get(k);
            for (String s : allow) {
                String topPre = null;
                String topAfter = null;
                StringBuilder bottom1 = new StringBuilder();
                for (int j = 0; j < i; j++) {
                    topPre = s.substring(0, 1);
                    topAfter = s.substring(1, 2);

                }
            }
        }
        return true;
    }

    private List<String> next(String s, Map<String, List<String>> level1Map) {

        int len = s.length();
        if (len == 1) {
            return level1Map.get(s);
        }
        List<String> res = new ArrayList<>(len - 1);
        for (int i = 0; i < len - 1; i++) {
            String left = s.substring(i, i + 1);
            String right = s.substring(i + 1, i + 2);

        }
        return null;
    }
}

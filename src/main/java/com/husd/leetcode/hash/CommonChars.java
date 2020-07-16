package com.husd.leetcode.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 * <p>
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 */
public class CommonChars {

    // 求交集？
    public List<String> commonChars(String[] A) {

        List<String> res = new ArrayList<>();
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < A[0].length(); ++i) {
            m.put(A[0].charAt(i), m.getOrDefault(A[0].charAt(i), 0) + 1);
        }
        for (int i = 1; i < A.length; ++i) {

            String s = A[i];
            Map<Character, Integer> m1 = new HashMap<>();
            for (int j = 0; j < s.length(); ++j) {
                int c = m.getOrDefault(s.charAt(j), 0);
                if (c == 0) {
                    m.put(s.charAt(j), 0);
                    continue;
                }
                c = m1.getOrDefault(s.charAt(j), 0);
                m1.put(s.charAt(j), c + 1);
            }

            for (Character c : m1.keySet()) {
                int n = Math.min(m.get(c), m1.get(c));
                m.put(c, n);
            }
        }

        for (Map.Entry<Character, Integer> entry : m.entrySet()) {

            Character c = entry.getKey();
            int n = entry.getValue();
            int i = 0;
            while (i < n) {
                res.add(String.valueOf(c));
            }
        }
        return res;
    }

    public static void main(String[] args) {

        CommonChars m = new CommonChars();
        String[] arr = {"bella", "label", "roller"};
        List<String> a = m.commonChars(arr);
        System.out.println(a);
    }
}

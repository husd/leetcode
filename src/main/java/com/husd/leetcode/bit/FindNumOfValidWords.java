package com.husd.leetcode.bit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1178. 猜字谜
 * <p>
 * 外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。
 * <p>
 * 字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底：
 * <p>
 * 单词 word 中包含谜面 puzzle 的第一个字母。
 * 单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
 * 例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）。
 * 返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i] 所对应的谜底的单词数目。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * words = ["aaaa","asas","able","ability","actt","actor","access"],
 * puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
 * 输出：[1,1,3,2,4,0]
 * 解释：
 * 1 个单词可以作为 "aboveyz" 的谜底 : "aaaa"
 * 1 个单词可以作为 "abrodyz" 的谜底 : "aaaa"
 * 3 个单词可以作为 "abslute" 的谜底 : "aaaa", "asas", "able"
 * 2 个单词可以作为 "absoryz" 的谜底 : "aaaa", "asas"
 * 4 个单词可以作为 "actresz" 的谜底 : "aaaa", "asas", "actt", "access"
 * 没有单词可以作为 "gaswxyz" 的谜底，因为列表中的单词都不含字母 'g'。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 10^5
 * 4 <= words[i].length <= 50
 * 1 <= puzzles.length <= 10^4
 * puzzles[i].length == 7
 * words[i][j], puzzles[i][j] 都是小写英文字母。
 * 每个 puzzles[i] 所包含的字符都不重复。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hushengdong
 * @date 2020/4/14
 * @tag 位运算
 */
public class FindNumOfValidWords {

    private Map<Integer, Integer> map = new HashMap<>();

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {

        for (int i = 0; i < words.length; i++) {
            int k = 0;
            for (int j = 0; j < words[i].length(); j++) {
                k |= 1 << (words[i].charAt(j) - 'a');
            }
            Integer c = map.getOrDefault(k, 0);
            map.put(k, ++c);
        }
        List<Integer> target = new ArrayList<>(puzzles.length);
        for (int i = 0; i < puzzles.length; i++) {
            int puzzle = 0;
            for (int j = 0; j < puzzles[i].length(); j++) {
                puzzle |= 1 << (puzzles[i].charAt(j) - 'a');
            }
            //因为puzzle的长度不超过7，它的子集大小不大于2^7 = 128，所以把它的子集
            //枚举出来，然后通过hash判断
            int first = (1 << puzzles[i].charAt(0) - 'a');
            int count = 0;
            for (int j1 = puzzle; j1 > 0; j1 = (j1 - 1) & puzzle) {
                if ((first & j1) > 0) {
                    count = count + map.getOrDefault(j1, 0);
                }
            }
            target.add(count);
        }
        return target;
    }

}

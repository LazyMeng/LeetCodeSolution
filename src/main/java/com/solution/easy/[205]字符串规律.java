package com.solution.easy;

/**
 * @Author Mn
 * @Date 2022/8/17 16:00
 */
//给定两个字符串 s 和 t ，判断它们是否是同构的。
//
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
//
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
//
//
//
// 示例 1:
//
//
//输入：s = "egg", t = "add"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "foo", t = "bar"
//输出：false
//
// 示例 3：
//
//
//输入：s = "paper", t = "title"
//输出：true
//
//
//
// 提示：
//
//
//
//
//
// 1 <= s.length <= 5 * 10⁴
// t.length == s.length
// s 和 t 由任意有效的 ASCII 字符组成
//
//
// Related Topics 哈希表 字符串 👍 502 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int[] mapS = new int[128];
        int[] mapT = new int[128];
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i); //当前的映射值是否相同
            if (mapS[c1] != mapT[c2]) {
                return false;
            } else { //是否已经修改过，修改过就不需要再处理
                if (mapS[c1] == 0) {
                    mapS[c1] = i + 1;
                    mapT[c2] = i + 1;
                }
            }
        }
        return true;
    }

    private boolean isIsomorphicHelper(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            } else {
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


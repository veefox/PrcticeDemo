package middle.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by veefox on 2020年11月9日, 0009
 * 题目：无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void start() {
        String string = "dejzwcxvbwface";
        System.out.println(Solution.lengthOfLongestSubstring(string));
    }

    //    标签：滑动窗口
//    暴力解法时间复杂度较高，会达到 O(n^2)，故而采取滑动窗口的方法降低时间复杂度
//    定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
//    我们定义不重复子串的开始位置为 start，结束位置为 end
//    随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，此时将字符作为 key 值，获取其 value 值，并更新 start，此时 [start, end] 区间内不存在重复字符
//    无论是否更新 start，都会更新其 map 数据结构和结果 ans。
//    时间复杂度：O(n)
    static class Solution {
        public static int lengthOfLongestSubstring(String s) {//abcdecoiuyt
            int n = s.length(), ans = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int start = 0, end = 0; end < n; end++) {
                char alpha = s.charAt(end);
                if (map.containsKey(alpha)) {
                    start = Math.max(map.get(alpha), start);
                }
                ans = Math.max(ans, end - start + 1);
                map.put(s.charAt(end), end + 1);
            }
            return ans;
        }
    }

    public static int lengthOfLongestSubstring1(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) return 1;
        StringBuilder stringBuffer = new StringBuilder();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (!stringBuffer.toString().contains(String.valueOf(s.charAt(j)))) {
                    stringBuffer.append(s.charAt(j));
                } else {
                    max = Math.max(max, stringBuffer.length());
                    stringBuffer.delete(0, stringBuffer.length());
                    break;
                }
            }
        }
        return max;
    }
}

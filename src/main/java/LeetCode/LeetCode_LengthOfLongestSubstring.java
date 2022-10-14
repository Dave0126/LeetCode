package LeetCode;

/*
题目描述：
给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。

示例1:
输入: s = "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

示例 2:
输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

示例 3:
输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
    请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。

提示：
0 <= s.length <= 5 * 104
s由英文字母、数字、符号和空格组成

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;

public class LeetCode_LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "bbbbbbb";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);

    }

    public static int lengthOfLongestSubstring(String s) {
        // 1 将String转换成char[]数组
        char[] charList = s.toCharArray();
        int length = charList.length;
        int maxNum = 0;
        int slowIndex = 0;
        int fastIndex = 0;
        ArrayList<Character> tempSubString = new ArrayList<>();

        while (fastIndex < length) {
            if(!tempSubString.contains(charList[fastIndex])) {
                tempSubString.add(charList[fastIndex]);
                fastIndex++;
            } else {
                tempSubString.remove(0);
                slowIndex++;
            }
            maxNum = Math.max(maxNum, tempSubString.size());
        }
        return maxNum;
    }

}

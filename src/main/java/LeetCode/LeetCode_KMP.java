package LeetCode;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 *
 */

public class LeetCode_KMP {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);

    }
    public static int lengthOfLongestSubstring(String s) {
        char[] charList = s.toCharArray();
        int length = charList.length;
        int[] mark = new int[length];
        int firstIndex = 1;
        int compareIndex = 0;
        for (int i=0; i<length; i++) {
            if(charList[firstIndex] == charList[compareIndex]) {
                for(int j=i; j<length; j++) {
                }
            }
            else {
                firstIndex++;
                mark[i] = 0;
            }
        }
        return 0;
    }

}

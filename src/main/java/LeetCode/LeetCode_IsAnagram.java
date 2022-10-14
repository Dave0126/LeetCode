package LeetCode; /**
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 *
 * 
 *
 * 示例1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 */

/**
 * 思路：可以先将两个字符串转换成字符数组，排序后如果两个数组equal，则它们互为字母异位词。
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_IsAnagram {
    public static void main(String[] args) {
        String s = "cat";
        String t = "tcaa";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        char[] sList = s.toCharArray();
        char[] tList = t.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        if (sList.length == tList.length) {
            Arrays.sort(sList);
            Arrays.sort(tList);
            return Arrays.equals(tList, sList);

        } else {
            return false;
        }
    }
}

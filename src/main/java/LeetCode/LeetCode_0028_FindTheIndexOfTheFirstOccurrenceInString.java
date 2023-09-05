package LeetCode;

/**
 * @author Guohao
 * @version 1.0
 * @description 找出字符串中第一个匹配项的下标(简单)
 *
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 *
 *
 * 示例 1：
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 *
 * 示例 2：
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 *
 *
 * 提示：
 * 1 <= haystack.length, needle.length <= 104
 * haystack 和 needle 仅由小写英文字符组成
 *
 * @create 2023/9/2 16:54
 */
public class LeetCode_0028_FindTheIndexOfTheFirstOccurrenceInString {
    public static void main(String[] args) {
        String haystack = "leetcode";
        String needle = "leeto";
        int result = strStr(haystack, needle);
        System.out.println(result);
    }

    public static int strStr(String haystack, String needle) {
        int indexStr = 0;
        int indexSubStr = 0;
        while(indexStr < haystack.length() && indexSubStr < needle.length()){
            if(haystack.charAt(indexStr) == needle.charAt(indexSubStr)){
                indexStr++;
                indexSubStr++;
            }
            else{
                indexStr++;
                indexSubStr = 0;
            }
            if(indexSubStr == needle.length()){
                return indexStr - needle.length();
            }
        }
        return -1;
    }
}

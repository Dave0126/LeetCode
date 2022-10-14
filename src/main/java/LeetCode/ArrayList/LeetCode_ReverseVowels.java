package LeetCode.ArrayList;

import java.util.*;

/**
 * 反转字符串中的元音字母
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 *
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
 *
 * 示例 1：
 * 输入：s = "hello"
 * 输出："holle"
 *
 * 示例 2：
 * 输入：s = "leetcode"
 * 输出："leotcede"
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/all-about-array/x93lce/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LeetCode_ReverseVowels {
    public static void main(String[] args) {
        String s = "aA";
        String result = reverseVowels(s);
        System.out.println(result);
    }

    public static String reverseVowels(String s) {
        char[] charList = s.toCharArray();
        int len = charList.length;
        char[] vowels = {'a','e','i','o','u','A','E','I','O','U'};
        char temp;
        int index1 = 0;
        int index2 = len -1;
        while(true) {
            if (index1 >= index2) {
                break;
            }
            if (isInList(charList[index1],vowels)){
                if (isInList(charList[index2], vowels)){
                    temp = charList[index1];
                    charList[index1] = charList[index2];
                    charList[index2] = temp;
                    index1++;
                    index2--;
                } else {
                    index2--;
                }
            } else {
                index1++;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < charList.length; i++) {
            res.append(charList[i]);
        }
        return res.toString();
    }

    public static boolean isInList(char e, char[] list){
        for (char c:list) {
            if(e == c){
                return true;
            }
        }
        return false;
    }
}

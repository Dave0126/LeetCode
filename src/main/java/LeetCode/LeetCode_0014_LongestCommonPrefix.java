package LeetCode;

import java.util.Arrays;

/**
 * @author Guohao
 * @version 1.0
 * @description 最长公共前缀(简单)
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 *
 * 提示：
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * @create 2023/9/18 09:11
 */
public class LeetCode_0014_LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String result = longestCommonPrefix(strs);
        System.out.println(result);
    }

    public static String longestCommonPrefix(String[] strs){
//        return solution1(strs);
        return solution2(strs);
    }

    public static String solution1(String[] strs){
        String result = "";
        String temp = "";
        int index = 0;
        int minLength = 100000000;
        for(String s:strs){
            minLength = Math.min(minLength, s.length());
        }
        System.out.println(minLength);
        while(index < minLength){
            temp += strs[0].charAt(index);
            for(String s:strs){
                if(s.charAt(index) != temp.charAt(index)){
                    return result;
                }
            }
            result = temp;
            index++;
        }
        return result;
    }

    public static String solution2(String[] strs){
        String result = "";
        Arrays.sort(strs);
        int minLength = 100000000;
        for(String s:strs){
            minLength = Math.min(minLength, s.length());
        }
        int index = 0;
        while(index < minLength){
            if(strs[0].charAt(index) != strs[strs.length-1].charAt(index)){
                break;
            }
            result += strs[0].charAt(index);
            index++;
        }
        return result;
    }
}

package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Guohao
 * @version 1.0
 * @description N 字形变换(中等)
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 *
 *
 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 *
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * 示例 3：
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 *
 * @create 2023/9/18 10:41
 */
public class LeetCode_0006_ZigzagConversion {
    public static void main(String[] args) {
        String s = "AB";
        int numRows = 1;
        String result = convert(s, numRows);
        System.out.println(result);
    }

    public static String convert(String s, int numRows){
        String result = "";
        int index = 0;
        int iter = 1;
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < numRows; i++) {
                map.put(i, "");
        }
        for (int i = 0; i < s.length(); i++) {
            if(index == 0) iter = 1;
            if(index == numRows-1) iter = -1;
            if(numRows == 1) iter = 0;

            String temp = map.get(index);
            temp += s.charAt(i);
            map.put(index, temp);

            index = index + iter;
        }
        for (int i = 0; i < numRows; i++) {
            result += map.get(i);
        }
        return result;
    }
}

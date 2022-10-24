package LeetCode;


/**
 * 5. 最长回文子串
 * 题目描述：
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 *
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 */

// a   s   d   f   d   s   a   w
//         ^   ^   ^
//     ^       ^       ^
//
// 主要思想：从中心扩散
// 三个指针，一个中间指针，左右各两个指针。
// 如果左指针 == 中间指针，则左边的指针再向左移一格--；
// 如果右指针 == 中间指针，则右边的指针再向右移一格++；
// 如果左指针 == 右指针，则左指针向左移--，右指针向右移++。
// 以上指针在更新前均不能越界。



public class LeetCode_0005_LongestPalindrome {
    public static void main(String[] args) {
        String s = "a";
        String res = longestPalindrome(s);
        System.out.println(res);
    }

    public static String longestPalindrome(String s) {
        char[] charList = s.toCharArray();  // 将String转换成char[]数组
        int strLen = charList.length;       // 初始串的长度
        int subStrLen = 1;          // 当前子串的长度
        int maxSubStrLen = 0;       // 最长子串的长度
        int startMaxSubStr = 0;     // 最长子串的起始索引，逻辑上等于左指针左移前的位置（更新后的左指针+1）
        int midIndex = 0;           // 中间指针
        int leftIndex = 0;          // 左指针
        int rightIndex = 0;         // 右指针

        // 如果输入字符串的长度 <= 1，则直接返回字符串
        if(strLen <= 1){
            return s;
        }

        for (midIndex=1; midIndex<strLen; midIndex++) {
            leftIndex = midIndex - 1;
            rightIndex = midIndex + 1;
            // 情况一：中间指针指向的元素 == 左指针指向的元素
            while(leftIndex >= 0 && charList[leftIndex] == charList[midIndex]) {
                leftIndex--;
                subStrLen++;
            }

            // 情况二：中间指针指向的元素 == 右指针指向的元素
            while(rightIndex <= strLen-1 && charList[rightIndex] == charList[midIndex]) {
                rightIndex++;
                subStrLen++;
            }

            // 情况三：左指针指向的元素 == 右指针指向的元素
            while(leftIndex >= 0 && rightIndex <= strLen-1
                    && charList[leftIndex] == charList[rightIndex]) {
                leftIndex--;
                rightIndex++;
                subStrLen+=2;
            }

            // 最大子串长度
            if (maxSubStrLen < subStrLen) {
                maxSubStrLen = subStrLen;
                startMaxSubStr = leftIndex + 1;
            }
            System.out.println(leftIndex +"\t" + rightIndex);
            subStrLen = 1;
        }


        return s.substring(startMaxSubStr, startMaxSubStr+maxSubStrLen);
    }

}

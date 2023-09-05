package LeetCode;

/**
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * 字母和数字都属于字母数字字符。
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 *
 * 示例 2：
 * 输入：s = "race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 *
 * 示例 3：
 * 输入：s = " "
 * 输出：true
 * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
 * 由于空字符串正着反着读都一样，所以是回文串。
 *
 *
 * 提示：
 * 1 <= s.length <= 2 * 105
 * s 仅由可打印的 ASCII 字符组成
 */

public class LeetCode_0125_ValidPalindrome {
    public static void main(String[] args) {

        String s = "qwertyuiop[]';lkjhgfdsazxcvbnmmnbvcxzasdfghjkl;'][poiuytrewq";
        boolean result = isPalindrome(s);
        System.out.println(result);
    }

    public static boolean isPalindrome(String s) {
        String temp = s.replaceAll("[^A-Za-z0-9]", "");  // 去除数字，英文之外的内容
        temp = temp.toLowerCase(); // 转小写；转大写为 temp.toUpperCase();
        char[] array = temp.toCharArray();

        int head = 0;
        int queue = array.length <= 0 ? 0 : (array.length - 1);

        return checkPalindrome(array, head, queue);
    }

    public static boolean checkPalindrome(char[] array, int head, int queue) {

        while ( head <= queue && queue != 0){
            if (array[head] == array[queue]) {
                System.out.println(array[head]+"\t"+ array[queue]);
                head += 1;
                queue -= 1;

            }
            else {
                System.out.println("123");
                return false;
            }
        }
        return true;
    }
}

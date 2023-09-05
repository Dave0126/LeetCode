package LeetCode;

/**
 * @author Guohao
 * @version 1.0
 * @description 反转字符串 (简单)
 *
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 *
 *
 * 示例 1：
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 *
 * 示例 2：
 * 输入：s = ["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 *
 *
 * 提示：
 * 1 <= s.length <= 105
 * s[i] 都是 ASCII 码表中的可打印字符
 *
 * @create 2023/8/30 18:53
 */
public class LeetCode_0344_ReverseString {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o', '!'};
        reverseString(s);
        System.out.println(s);
    }

    public static void reverseString(char[] s) {
        solution1(s);
        solution2(s);
    }

    public static void solution1(char[] s) {
        char temp = '0';
        int length = s.length;
        for (int i = 0; i < length/2; i++) {
            temp = s[i];
            s[i] = s[length - 1 - i];
            s[length - 1 - i] = temp;
        }
    }

    public static void solution2(char[] s) {
        int head = 0;
        int queue = (s.length > 0)? s.length-1 : 0;
        // char[] reverse = new char[s.length];
        char temp;
        for (int i = head; i <= queue/2; i++){
            temp = s[i];
            s[i] = s[queue - i];
            s[queue - i] = temp;
        }
    }
}

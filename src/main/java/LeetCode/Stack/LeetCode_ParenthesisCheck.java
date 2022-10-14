package LeetCode.Stack;

import java.util.Stack;

/**
 * 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/queue-stack/g9d0h/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class LeetCode_ParenthesisCheck {
    public static void main(String[] args) {
        String input = "{({[]})()}";
        boolean res = isValid(input);
        System.out.println(res);
    }

    public static boolean isValid(String s) {
        char[] charList = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while(index < charList.length) {
            if(stack.isEmpty()) {
                stack.push(charList[index]);
            }
            else if ((stack.peek() == '(' && charList[index] == ')') ||
                    (stack.peek() == '[' && charList[index] == ']') ||
                    stack.peek() == '{' && charList[index] == '}') {
                stack.pop();
            }
            else {
                stack.push(charList[index]);
            }
            index++;
        }
        return stack.isEmpty();
    }
}

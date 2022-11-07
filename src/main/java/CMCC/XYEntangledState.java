package CMCC;

import java.util.Scanner;
import java.util.Stack;

/**
 * 2022/10/30 中国移动秋招编程题
 * XY纠缠
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 *      航天科学家在采集的月球土质样本中发现了一种新物质X。为了探究其性质，科学家利用了超高真空的真空管和超高压电场；
 *      新物质X含有n层电子层，并用小写字母(a-z)表示每层的电子数。
 *      科学家希望利用仪器通过最多交换一次X中任意两个电子层的电子数，探测XY两种物质是否会产生纠缠。
 *      若通过交换能得到物质Y表示将会产生XY纠缠，否则不会产生XY纠缠。
 *
 *
 *
 * 输入描述
 *      第一行是新物质X各电子层上的电子数（小写字母字符串s1）；
 *      第二行是另一种物质Y各电子层上的电子数（小写字母字符串s2）。
 *
 * 输出描述
 *      若最多交换一次
 *      若最多交换一次X中任意两个电子层的电子数，就能得到物质Y则返回值为true，否则返回值为false。
 *
 * 样例输入
 *      abcdef
 *      fbcdea
 *
 * 样例输出
 *      true
 */
public class XYEntangledState {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String x = sc.nextLine();
            String y = sc.nextLine();
            boolean result = isConnected(x,y);
            System.out.println(result);
        }
    }

    public static boolean isConnected(String x, String y) {
        if(x.length() != y.length()) {
            return false;
        }
        if(x.equals(y)){
            return true;
        }

        char[] xCharArray = x.toCharArray();
        char[] yCharArray = y.toCharArray();
        int length = xCharArray.length;
        Stack<Character> tempStack = new Stack<>();
        for (int i = 0; i < length; i++) {
            if (xCharArray[i] == yCharArray[i]) {
                continue;
            }
            else if (tempStack.isEmpty()) {
                tempStack.push(xCharArray[i]);
                tempStack.push(yCharArray[i]);
            }
            else {
                if(xCharArray[i] != tempStack.peek()){
                    return false;
                }
                tempStack.pop();
                if(yCharArray[i] != tempStack.peek()){
                    return false;
                }
                tempStack.pop();
            }
        }
        if (tempStack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}


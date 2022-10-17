package LeetCode.Stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 每日温度
 * 给定一个整数数组temperatures，表示每天的温度，返回一个数组 answer，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 示例 1:
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出:[1,1,4,2,1,1,0,0]
 *
 * 示例 2:
 * 输入: temperatures = [30,40,50,60]
 * 输出:[1,1,1,0]
 *
 * 示例 3:
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/queue-stack/genw3/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LeetCode_Temperature {
    public static void main(String[] args) {
        int[] temperatures1 = {73,74,75,71,69,72,76,73};
        int[] temperatures2 = {55,38,53,81,61,93,97,32,43,78};
        int[] temperatures3 = {30,40,50,60};
        int[] res = dailyTemperatures(temperatures3);
        System.out.println(Arrays.toString(res));

    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] resList = new int[temperatures.length];
        Stack<Integer> tempStack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int max = 0;
            boolean isEnd = false;
            for (int j = i; j < temperatures.length; j++) {
                if(tempStack.isEmpty()) {
                    if(j == temperatures.length -1) {
                        isEnd = true;
                    }
                    tempStack.push(temperatures[j]);
                    max = temperatures[j];
                    continue;
                }

                if(max >= temperatures[j]) {
                    if(j == temperatures.length -1) {
                        isEnd = true;
                    }
                    tempStack.push(temperatures[j]);
                } else {
                    break;
                }
            }

            if (isEnd) {
                resList[i] = 0;
            } else {
                resList[i] = tempStack.size();
            }
            tempStack.clear();
        }

        return resList;
    }

}

package LeetCode;

import java.util.Arrays;

/**
 * 42. 接雨水
 * (并未完全通过测试，通过的测试用例: 319 / 322)
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 图示：
 *    |              x                  <-
 *    |      x o o o x x o x            <-
 *    |  x o x x o x x x x x x          <-
 *
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * 图示：
 *    |           x         <-
 *    | x o o o o x         <-
 *    | x o o x o x         <-
 *    | x x o x x x         <-
 *    | x x o x x x         <- 按层来计算o的个数
 */
public class LeetCode_0042_Trap {
    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        int result = trap(height);
        System.out.println(result);
    }

    private static int trap(int[] height) {
        int res = 0;
        int[] temp = Arrays.copyOf(height, height.length);
        while (Arrays.stream(temp).sum() != 0){
            // 一层一层削减
            boolean isFirst = false;
            int indexFirst = 0;
            boolean isEnd = false;
            int indexEnd = 0;
            // 找到左起的第一个非0元素，记录
            for (int i = 0; i < temp.length; i++) {
                if(!isFirst && temp[i]>0 ){
                    isFirst = true;
                    indexFirst = i;
                    break;
                }
            }
            // 找到右起的第一个非0元素，记录
            for (int i = 0; i < temp.length; i++) {
                if( !isEnd && temp[temp.length-1-i]>0){
                    isEnd = true;
                    indexEnd = temp.length-1-i;
                    break;
                }
            }
            // 在左右两端开始的第一个非零元素组成的区间中，计算0元素的个数
            for (int i = indexFirst; i <= indexEnd; i++) {
                if(temp[i]==0){
                    res++;
                }
            }
            // 将整行元素减1
            for (int i = 0; i < temp.length; i++) {
                temp[i] = temp[i]-1>0 ? temp[i]-1 : 0;
            }
        }
        return res;
    }
}

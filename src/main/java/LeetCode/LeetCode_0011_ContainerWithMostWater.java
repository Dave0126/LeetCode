package LeetCode;

/**
 * @author Guohao
 * @version 1.0
 * @description 盛最多水的容器(中等)
 *
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 *   #         #
 *   #         #   #
 *   # #       #   #
 *   # #   #   #   #
 *   # #   # # #   #
 *   # #   # # # # #
 *   # # # # # # # #
 * # # # # # # # # #
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 *
 * @create 2023/8/31 10:23
 */
public class LeetCode_0011_ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = maxArea(height);
        System.out.println(result);
    }

    public static int maxArea(int[] height){
        int ptPre = 0;
        int ptSuc = height.length - 1;
        int maxArea = 0;

        while(ptPre < ptSuc){
            maxArea = Math.max(maxArea, Math.min(height[ptPre], height[ptSuc]) * (ptSuc - ptPre));
            if (height[ptPre] >= height[ptSuc]){
                ptSuc--;
            } else{
                ptPre++;
            }
        }
        return maxArea;
    }
}

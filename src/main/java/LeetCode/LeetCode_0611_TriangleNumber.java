package LeetCode;

import java.util.Arrays;

/**
 * 611. 有效三角形的个数
 *
 * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 *
 * 示例 1:
 * 输入: nums = [2,2,3,4]
 * 输出: 3
 * 解释:有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 *
 * 示例 2:
 * 输入: nums = [4,2,3,4]
 * 输出: 4
 *
 *
 * 提示:
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 */

public class LeetCode_0611_TriangleNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{4,2,3,4};
        int result = triangleNumber(nums);
        System.out.println(result);
    }

    public static int triangleNumber(int[] nums) {
        /**
         * 任意两边和大于第三边，O(n^3)
         * 有复杂度更小的算法吗？
         * 一共有C^{3}_{n} 种排列组合
         * 在一组已经排好序的数组中，最小和次小的数相加大于最大的数，相当于在这区间内的所有数都满足该条件
         * Map<数, 该数出现的次数>，将这个Map的键转存到数组中，然后
         * 例如在如下一组数列中 [1,1,3,4,5,6,7]
         */
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        return 0;
    }
}

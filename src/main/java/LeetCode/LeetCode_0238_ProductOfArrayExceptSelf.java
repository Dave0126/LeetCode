package LeetCode;

/**
 * @author Guohao
 * @version 1.0
 * @descriptionx 除自身以外数组的乘积(中等)
 *
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 *
 * 示例 1:
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 * 示例 2:
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 *
 * 提示：
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
 *
 * @create 2023/9/5 15:23
 */
public class LeetCode_0238_ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int result[] = productExceptSelf(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] productExceptSelf(int[] nums){
        int[] result = new int[nums.length];
        result[0] = 1;
        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            temp = temp * nums[i-1];
            result[i] = temp;
        }

        temp = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            temp = temp * nums[i+1];
            result[i] = result[i] * temp;
        }
        return result;
    }
}

package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Guohao
 * @version 1.0
 * @description 轮转数组(中等)
 *
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例 2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *
 * @create 2023/9/5 13:29
 */
public class LeetCode_0189_RotateArray {
    public static void main(String[] args) {
        int[] nums = {-1};
        int k = 2;
        rotate(nums, k);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void rotate(int[] nums, int k){
        List<Integer> temp = new ArrayList<>();
        k = k % nums.length;
        for (int i = nums.length - k; i < nums.length; i++) {
            temp.add(nums[i]);
        }
        for (int i = 0; i < nums.length - k; i++) {
            temp.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp.get(i);
        }
    }
}

package LeetCode;

import java.util.*;

/**
 * @author Guohao
 * @version 1.0
 * @description 删除有序数组中的重复项
 *
 * 给你一个 升序排列 的数组 nums ，请你原地删除重复出现的元素，使每个元素只出现一次 ，返回删除后数组的新长度。元素的相对顺序应该保持一致 。
 * 然后返回 nums 中唯一元素的个数。考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 * - 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
 * - 返回 k 。
 *
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2,_]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2：
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 *
 * @create 2023/8/29 15:30
 */
public class LeetCode_0026_RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int result = removeDuplicates(nums);
        System.out.println("new length = " + result);
        for (int i = 0; i < result; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        int result = solution1(nums);
        return result;
    }

    private static int solution1(int[] nums){
        int ptBase = 0;
        for (int ptCompare = 0; ptCompare < nums.length; ptCompare++) {
            if (nums[ptBase] != nums[ptCompare]){
                ptBase ++;
            }
            nums[ptBase] = nums[ptCompare];
        }
        return ptBase+1;
    }
}

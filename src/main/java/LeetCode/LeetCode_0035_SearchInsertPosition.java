package LeetCode;

/**
 * @author Guohao
 * @version 1.0
 * @description 搜索插入位置 (简单)
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 *
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为 无重复元素 的 升序 排列数组
 * -104 <= target <= 104
 *
 * @create 2023/8/30 17:32
 */
public class LeetCode_0035_SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1,4,6,7,8,9};
        int target = 9;
        int result = searchInsert(nums, target);
        System.out.println(result);
    }

    public static int searchInsert(int[] nums, int target) {
        // 二分搜索
        int initPos = 0;
        int endPos = nums.length;
        int position = (initPos + endPos) / 2;
        while(true){
            if (target < nums[position]){
                if(target < nums[0]){
                    return 0;
                }
                if(target > nums[position-1]){
                    return position;
                }
                endPos = position;
                position = (initPos + endPos) / 2;

            }else if(target > nums[position]){
                if(target > nums[nums.length - 1]){
                    return nums.length;
                }
                if(target < nums[position+1]){
                    return position + 1;
                }
                initPos = position;
                position = (initPos + endPos)/2;

            }else {
                return position;
            }
        }
    }
}

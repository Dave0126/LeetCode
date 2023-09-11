package LeetCode;

/**
 * @author Guohao
 * @version 1.0
 * @description 三数之和(中等)
 *
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 * 输入： nums = [-1,0,1,2,-1,-4]
 * 输出： [[-1,-1,2],[-1,0,1]]
 * 解释：
 *         nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 *         nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 *         nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 *
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 *
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 *
 * 提示：
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_0015_ThreeSum {
    public static void main(String[] args) {
        int[] numList = {-2,0,1,1,2};
        List<List<Integer>> result = threeSum(numList);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length < 3 || nums == null){
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(nums);
        if(nums[0] > 0){
            return new ArrayList<List<Integer>>();
        }
        for (int ptLeft = 0; ptLeft < nums.length; ptLeft++) {
            if(ptLeft > 0 && nums[ptLeft] == nums[ptLeft - 1]){
                continue;
            }
            int ptMid = ptLeft + 1;
            int ptRight = nums.length - 1;
            while(ptMid < ptRight){
                if(nums[ptLeft] + nums[ptMid] + nums[ptRight] == 0){
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[ptLeft]);
                    temp.add(nums[ptMid]);
                    temp.add(nums[ptRight]);
                    res.add(temp);
                    ptMid++;
                    ptRight--;
                    while(ptMid < ptRight && nums[ptMid] == nums[ptMid+1]){
                        ptMid++;
                    }
                    while(ptMid < ptRight && nums[ptRight] == nums[ptRight-1]){
                        ptRight--;
                    }

                }
                if(nums[ptLeft] + nums[ptMid] + nums[ptRight] < 0){
                    ptMid++;
                }
                if(nums[ptLeft] + nums[ptMid] + nums[ptRight] > 0){
                    ptRight--;
                }
            }
        }
        return res;
    }

}

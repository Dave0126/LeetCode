package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Guohao
 * @version 1.0
 * @description 55. 跳跃游戏
 *
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 *
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 * 示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *
 *
 * 提示：
 * 1 <= nums.length <= 10^4
 * 0 <= nums[i] <= 10^5
 *
 * @create 2023/8/30 08:11
 *
 */
public class LeetCode_0055_JumpGame {
    public static void main(String[] args) {
        int[] nums = {0};
        Boolean result = canJump(nums);
        System.out.println(result);
    }

    public static boolean canJump(int[] nums) {
        int ptEnd = nums.length - 1;
        if(nums[0] >= ptEnd){
            return true;
        }
        int[] catchList = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            catchList[i] = i + nums[i];
        }
        System.out.println(catchList);
        return recJump(ptEnd, catchList);
    }

    private static boolean recJump(int ptEnd, int[] catchList){
        for (int ptPred = ptEnd - 1; ptPred >= 0; ptPred--) {
            if(catchList[ptPred] >= ptEnd){
                if(ptPred == 0) {
                    return true;
                }
                ptEnd = ptPred;
            }
        }
        return false;
    }
}

package LeetCode;

/**
 * @author Guohao
 * @version 1.0
 * @description 跳跃游戏 II (中等)
 * 关联题目：0055_JumpGame
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 *
 *
 * 示例 1:
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * 示例 2:
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 *
 *
 * 提示:
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * 题目保证可以到达 nums[n-1]
 *
 * @create 2023/8/31 11:21
 */
public class LeetCode_0045_JumpGameLv2 {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        int result = jump(nums);
        System.out.println(result);
    }

    public static int jump(int[] nums){
        int count = 0;
        int ptPred = 0;
        int ptEnd = nums.length - 1;
        int[] catchList = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            catchList[i] = i + nums[i];
        }

        if(ptEnd == 0) return 0;

        while(ptPred <= ptEnd){
            if(catchList[ptPred] >= ptEnd){
                if(ptEnd == 0) return count;
                ptEnd = ptPred;
                count++;
                ptPred = 0;
            }
            else ptPred++;
        }
        return nums.length;
    }
}

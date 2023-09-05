package LeetCode;
/*
给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。


示例1：
输入：nums = [3,2,3]
输出：3

示例2：
输入：nums = [2,2,1,1,1,2,2]
输出：2


提示：
n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109

进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/majority-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;

public class LeetCode_0169_MajorityElement {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1};
        int result = majorityElement(nums);
        System.out.println(result);
    }

    public static int majorityElement(int[] nums) {
//        int result = solution1(nums);
        int result = solution2(nums);
        return result;
    }

    public static int solution1(int[] nums){
        int res = -1;
        Arrays.sort(nums);
        int count = 1;
        float maxCount = (float) nums.length / 2;

        if (nums.length == 1) {
            res = nums[0];
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == nums[i]) {
                count++;
                if (count >= maxCount) {
                    res = nums[i];
                }
            }
            else {
                count = 1;
            }
        }
        return res;
    }

    /**
     * 思路：根据题意，可以得出当满足题意时，这个数组的排序后的中位数一定是个数超过1/2的元素
     * @param nums
     * @return
     */
    public static int solution2(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}

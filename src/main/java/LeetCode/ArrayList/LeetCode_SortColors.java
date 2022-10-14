package LeetCode.ArrayList;

import java.util.Arrays;

/**
 * 颜色分类
 * 给定一个包含红色、白色和蓝色、共n 个元素的数组nums，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库的sort函数的情况下解决这个问题。
 *
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 *
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/all-about-array/x9wv2h/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LeetCode_SortColors {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void sortColors(int[] nums) {
        int redCount = 0;
        int whiteCount = 0;
        int blueCount = 0;

        // 记录三种颜色出现的次数
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                redCount++;
            }
            else if(nums[i] == 1){
                whiteCount++;
            }
            else {
                blueCount++;
            }
        }

        // 将三种颜色填回数组
        for (int i = 0; i < redCount; i++) {
            nums[i] = 0;
        }
        for (int i = redCount; i < (redCount+whiteCount); i++) {
            nums[i] = 1;
        }
        for (int i = (redCount+whiteCount); i < nums.length; i++) {
            nums[i] = 2;
        }
    }
}

package LeetCode.ArrayList;

import java.util.Arrays;

/**
 * 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/all-about-array/x9rh8e/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class LeetCode_MoveZeros {
    public static void main(String[] args) {
        int[] num = {0};
        moveZeros(num);
    }

    public static void moveZeros(int[] num) {
        int index = 0;
        for (int i = 0; i < num.length; i++) {
            if(num[i] != 0) {
                num[index] = num[i];
                index++;
            }
        }
        for (int i = index; i < num.length; i++) {
            num[i] = 0;
        }
        System.out.println(Arrays.toString(num));
    }
}

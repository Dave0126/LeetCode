package LeetCode.ArrayList;

import java.util.*;
/**
 * 未完成
 */

/**
 * 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 *
 * 示例2:
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 *
 * 提示：
 * 1 <= k <= nums.length <= 10^5
 * -10^4<= nums[i] <= 10^4
 *
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/all-about-array/x90rpm/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class LeetCode_FindKthLargest {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4,6,8,7,7};
        int res = findKthLargest(nums, 2);
        System.out.println(res);
    }

    public static int findKthLargest(int[] nums, int k) {
        Map<Integer, Integer> tempMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(tempMap.containsKey(nums[i])){
                tempMap.put(nums[i], tempMap.get(nums[i])+1);
            } else {
                tempMap.put(nums[i], 1);
            }
        }
        System.out.println(tempMap.toString());
        List<Map.Entry<Integer,Integer>> entries = new ArrayList<>(tempMap.entrySet());
        entries.sort((obj1, obj2) -> (obj2.getKey().compareTo(obj1.getKey())));
        List<Integer> sortedNums = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e:entries) {
            for (int i = 0; i < e.getValue(); i++) {
                sortedNums.add(e.getKey());
            }
        }
        Arrays.toString(sortedNums.toArray());
        System.out.println(Arrays.toString(nums));
        return 0;
    }
}

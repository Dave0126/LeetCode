package LeetCode;
/*
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：
你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:
输入: [2,2,1]
输出:

示例2:
输入: [4,1,2,1,2]
输出: 4

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/single-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LeetCode_0136_SingleNumber {
    public static void main(String[] args) {
        int[] numList = {2,2,1};
        int res = singleNumber(numList);
        System.out.println(res);
    }

    public static int singleNumber(int[] nums) {
        int result = -1;
        HashMap<Integer, Integer> temp = new HashMap<>();
        for(int i : nums) {
            if(temp.containsKey(i)) {
                temp.put(i,0);
            }
            else{
                temp.put(i,1);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = temp.entrySet().iterator();
        while (iterator.hasNext()){
            int key = iterator.next().getKey();
           if (temp.get(key) == 1) {
               result = key;
           }
        }
        System.out.print(temp.toString() + "\t");
        return result;
    }
}

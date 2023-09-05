package LeetCode;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * @author Guohao
 * @version 1.0
 * @description 插入区间 (中等)
 *
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 *
 * 示例 1：
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 *
 * 示例 2：
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 * 示例 3：
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 *
 * 示例 4：
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 *
 * 示例 5：
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 *
 *
 * 提示：
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= intervals[i][0] <= intervals[i][1] <= 105
 * intervals 根据 intervals[i][0] 按 升序 排列
 * newInterval.length == 2
 * 0 <= newInterval[0] <= newInterval[1] <= 105
 *
 * @create 2023/8/30 19:07
 */
public class LeetCode_0057_InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1,2}, {3,5}, {6,7}, {8,10}, {12,16}};
        int[] newInterval = {16,18};
        int[][] result = insert(intervals, newInterval);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
//        int ptIntervals = 0;
        int ptNew = 0;

        for(int ptIntervals = 0; ptIntervals < intervals.length; ptIntervals++){
            if(newInterval[0] <= intervals[ptIntervals][0]){
                // TODO
            }
        }
        return new int[][]{{4, 8}};
    }

    private static int findBound(int[][] intervals, int newInterval, Boolean isUpperBound){
        int pt = isUpperBound ? 0 : 1;
        if(newInterval < intervals[0][0]){

        }
        else if(newInterval > intervals[intervals.length-1][0]){
            System.out.println("[" + intervals[intervals.length-1][0] + ", " + intervals[intervals.length-1][1] + "]");
        }
        else {
            for (int i = 0; i < intervals.length; i++) {
                System.out.println("[" + intervals[i][0] + ", " + intervals[i][1] + "]");
//                if(newInterval[0] > intervals[i][0] && newInterval[0] < intervals[i+1][0]){
//                    System.out.println("[" + intervals[i][0] + ", " + intervals[i][1] + "]");
//                }
            }
        }
        return 0;
    }
}

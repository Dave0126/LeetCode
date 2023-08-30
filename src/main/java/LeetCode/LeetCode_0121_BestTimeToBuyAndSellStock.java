package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Guohao
 * @version 1.0
 * @description 买卖股票的最佳时机 (简单)
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 *
 * 示例 1：
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * 示例 2：
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 *
 * 提示：
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 *
 * @create 2023/8/30 15:47
 */
public class LeetCode_0121_BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int result = maxProfit(prices);
    }

    public static int maxProfit(int[] prices) {
        int buy = 0;
        int profit = 0;
        buy = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (buy < prices[i]){
                // 在 buy 的右边寻找一个元素，使得 profit 最大。
                profit = Math.max(profit, prices[i] - buy);
            }
            else{
                // buy 始终是遍历过的元素中最小的
                buy = prices[i];
            }
        }
        return profit;
    }
}

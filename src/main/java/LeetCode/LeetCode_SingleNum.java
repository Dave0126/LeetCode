package LeetCode;

import java.util.Arrays;

public class LeetCode_SingleNum {
    public static void main(String[] args) {
        int[] nums = {-336,513,-560,-481,-174,101,-997,40,-527,-784,-283,-336,513,-560,-481,-174,101,-997,40,-527,-784,-283,354};
        countingSort(nums);
        System.out.println(Arrays.toString(nums));
    }


    public static void countingSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int length = array.length;

        int max = array[0];
        int min = array[0];
        for (int i = 0; i < length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
            if (min > array[i]) {
                min = array[i];
            }
        }
        // 最大最小元素之间范围[min, max]的长度
        int offset = max - min + 1;
        // 1. 计算频率，在需要的数组长度上额外加1
        int[] count = new int[offset + 1];
        for (int i = 0; i < length; i++) {
            // 使用加1后的索引，有重复的该位置就自增
            count[array[i] - min + 1]++;
        }
        // 2. 频率 -> 元素的开始索引
        for (int i = 0; i < offset; i++) {
            count[i + 1] += count[i];
        }

        // 3. 元素按照开始索引分类，用到一个和待排数组一样大临时数组存放数据
        int[] aux = new int[length];
        for (int i = 0; i < length; i++) {
            // 填充一个数据后，自增，以便相同的数据可以填到下一个空位
            aux[count[array[i] - min]++] = array[i];
        }
        // 4. 数据回写
        for (int i = 0; i < length; i++) {
            array[i] = aux[i];
        }
    }
}

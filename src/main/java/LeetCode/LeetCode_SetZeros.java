package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_SetZeros {
    public static void main(String[] args) {
        int[][] matrix = {  {0,2,3},
                            {4,5,0},
                            {7,1,9},
                            {3,9,6}};
        findClosedNumbers(new int[]{1,2,3}, new int[]{3,4,5});
    }

    public static double findClosedNumbers(int[] num1, int []num2) {
        List<int[]> list = new ArrayList<>();
        int length = num1.length > num2.length ? num1.length : num2.length;
        for(int i = 0; i<length; i++ ){
        }

        return 0;
    }
}

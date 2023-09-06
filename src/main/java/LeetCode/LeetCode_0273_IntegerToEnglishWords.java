package LeetCode;

/**
 * @author Guohao
 * @version 1.0
 * @description 整数转换英文表示(困难)
 *
 * 将非负整数 num 转换为其对应的英文表示。
 *
 *
 *
 * 示例 1：
 * 输入：num = 123
 * 输出："One Hundred Twenty Three"
 *
 * 示例 2：
 * 输入：num = 12345
 * 输出："Twelve Thousand Three Hundred Forty Five"
 *
 * 示例 3：
 * 输入：num = 1234567
 * 输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 *
 *
 * 提示：
 * 0 <= num <= 231 - 1
 *
 * @create 2023/9/6 09:56
 */
public class LeetCode_0273_IntegerToEnglishWords {
    public static void main(String[] args) {
        int num = 99999999;
        String result = numberToWords(num);
        System.out.println(result);
    }

    public static String numberToWords(int num){
        String result = "";
        if(num == 0){
            return "Zero";
        }

        int[] magnitude = {1000000000, 1000000, 1000, 1};
        String[] alphabetMag = {"Billion ", "Million ", "Thousand ", ""};
        String space;
        for (int i = 0; i < magnitude.length; i++) {
            if(num >= magnitude[i]){
                result = result + handleCoefficient(num / magnitude[i]) + " " + alphabetMag[i];
                num = num % magnitude[i];
            }
        }
        return result.substring(0, result.length()-1);
    }

    public static String handleCoefficient(int coefficient){
        String str = "";
        int[][] nums = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {10, 11, 12, 13, 14, 15, 16, 17, 18, 19},
                {100, 90, 80, 70, 60, 50, 40, 30, 20}
        };
        String[][] alphabetNum = {
                {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"},
                {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"},
                {"Hundred", "Ninety", "Eighty", "Seventy", "Sixty", "Fifty", "Forty", "Thirty", "Twenty"}
        };

        if (coefficient >= nums[2][0]){
            int hundreds = coefficient / nums[2][0];
            str = alphabetNum[0][hundreds-1] + " " + alphabetNum[2][0] + " ";
            coefficient = coefficient - hundreds * 100;
        }
        int index = 0;
        while(coefficient > 0){
            if(coefficient >= nums[2][index]){
                str = str + alphabetNum[2][index] + " ";
                coefficient -= nums[2][index];
            }
            else if(coefficient >= 10 && coefficient < 20){
                str = str + alphabetNum[1][coefficient - 10] + " ";
                coefficient -= nums[1][coefficient - 10];
            }
            else if(coefficient >= 1 && coefficient < 10){
                str = str + alphabetNum[0][coefficient - 1] + " ";
                coefficient -= coefficient;
            }
            else{
                index++;
            }
        }
        return str.substring(0, str.length()-1);
    }
}

package LeetCode;

/**
 * @author Guohao
 * @version 1.0
 * @description 整数转罗马数字(中等)
 *
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 *
 *
 * 示例 1:
 * 输入: num = 3
 * 输出: "III"
 *
 * 示例 2:
 * 输入: num = 4
 * 输出: "IV"
 *
 * 示例 3:
 * 输入: num = 9
 * 输出: "IX"
 *
 * 示例 4:
 * 输入: num = 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 *
 * 示例 5:
 * 输入: num = 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 *
 * 提示：
 * 1 <= num <= 3999
 *
 * @create 2023/9/5 18:32
 * @related 0013(EASY); 0273(DIFF);
 */
public class LeetCode_0012_IntegerToRoman {
    public static void main(String[] args) {
        int nums = 1998;
//        String result = intToRomanSol1(nums);
        String result = intToRomanSol2(nums);
        System.out.println(result);
    }

    public static String intToRomanSol1(int num){
        String result = "";
        while(num > 0){
            if(num >= 1 && num <= 3){
                num -= 1;
                result += "I";
            }
            else if(num == 4){
                num -= 4;
                result += "IV";
            }
            else if(num >= 5 && num < 9){
                num -= 5;
                result += "V";
            }
            else if(num >= 9 && num < 10){
                num -= 9;
                result += "IX";
            }
            else if(num >= 10 && num < 40){
                num -= 10;
                result += "X";
            }
            else if(num >= 40 && num < 50){
                num -= 40;
                result += "XL";
            }
            else if(num >= 50 && num < 90){
                num -= 50;
                result += "L";
            }
            else if(num >= 90 && num < 100){
                num -= 90;
                result += "XC";
            }
            else if(num >= 100 && num < 400){
                num -= 100;
                result += "C";
            }
            else if(num >= 400 && num < 500){
                num -= 400;
                result += "CD";
            }
            else if(num >= 500 && num < 900){
                num -= 500;
                result += "D";
            }
            else if(num >= 900 && num < 1000){
                num -= 900;
                result += "CM";
            }
            else{
                num -= 1000;
                result += "M";
            }
        }
        return result;
    }

    public static String intToRomanSol2(int num){
        int[] nums          = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] alphabet   = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String result = "";
        int index = 0;
        while(num > 0 && index < nums.length){
            if((num - nums[index]) >= 0){
                num -= nums[index];
                result += alphabet[index];
            }
            else{
                index ++;
            }
        }
        return result;
    }
}

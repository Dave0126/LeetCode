package LeetCode;

public class LeetCode_0125 {
    public static void main(String[] args) {

        String s = "qwertyuiop[]';lkjhgfdsazxcvbnmmnbvcxzasdfghjkl;'][poiuytrewq";
        boolean result = isPalindrome(s);
        System.out.println(result);
    }

    public static boolean isPalindrome(String s) {
        String temp = s.replaceAll("[^A-Za-z0-9]", "");  // 去除数字，英文之外的内容
        temp = temp.toLowerCase(); // 转小写；转大写为 temp.toUpperCase();
        char[] array = temp.toCharArray();

        int head = 0;
        int queue = array.length <= 0 ? 0 : (array.length - 1);

        return checkPalindrome(array, head, queue);
    }

    public static boolean checkPalindrome(char[] array, int head, int queue) {

        while ( head <= queue && queue != 0){
            if (array[head] == array[queue]) {
                System.out.println(array[head]+"\t"+ array[queue]);
                head += 1;
                queue -= 1;

            }
            else {
                System.out.println("123");
                return false;
            }
        }
        return true;
    }
}

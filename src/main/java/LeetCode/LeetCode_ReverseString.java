package LeetCode;

public class LeetCode_ReverseString {
    public static void main(String[] args) {
        String s = "leetcode";
        char[] c = s.toCharArray();
        reverseString(c);
    }
    public static void reverseString(char[] s) {
        int head = 0;
        int queue = (s.length > 0)? s.length-1 : 0;
        // char[] reverse = new char[s.length];
        char temp;
        for (int i = head; i <= queue/2; i++){
            temp = s[i];
            s[i] = s[queue - i];
            s[queue - i] = temp;
        }

        for(int i =0; i<= queue; i++){
            System.out.print(s[i]);
        }
    }
}

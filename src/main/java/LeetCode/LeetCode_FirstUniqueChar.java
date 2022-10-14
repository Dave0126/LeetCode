package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_FirstUniqueChar {

    public static void main(String[] args) {
        String s = "lleetcode";
        int result = firstUniqChar(s);
        System.out.println(result);
    }

    public static int firstUniqChar(String s) {
        char[] charList = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
         for (int i = 0; i < charList.length; i++) {
             if (map.containsKey(charList[i])) {
                 map.put(charList[i], -1);
             } else {
                 map.put(charList[i], i);
             }
         }

        System.out.println(map);

        for (int i = 0; i<charList.length; i++) {
            if ( map.containsValue(i)) {
                return i;
            }
         }
        return -1;
    }
}

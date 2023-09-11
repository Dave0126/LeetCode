package LeetCode;

/**
 * @author Guohao
 * @version 1.0
 * @description 匹配子序列的单词数(中等)
 *
 * 给定字符串 s 和字符串数组 words, 返回  words[i] 中是s的子序列的单词个数 。
 * 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。
 * 例如， “ace” 是 “abcde” 的子序列。
 *
 *
 * 示例 1:
 * 输入: s = "abcde", words = ["a","bb","acd","ace"]
 * 输出: 3
 * 解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
 *
 * Example 2:
 * 输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * 输出: 2
 *
 *
 * 提示:
 * 1 <= s.length <= 5 * 104
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 50
 * words[i]和 s 都只由小写字母组成。
 *
 * @create 2023/9/9 13:36
 */
public class LeetCode_0792_NumberOfMatchingSubsequences {
    public static void main(String[] args) {
        String s = "rwpddkvbnnuglnagtvamxkqtwhqgwbqgfbvgkwyuqkdwhzudsxvjubjgloeofnpjqlkdsqvruvabjrikfwronbrdyyjnakstqjac";
        String[] words= {"wpddkvbnn","lnagtva","kvbnnuglnagtvamxkqtwhqgwbqgfbvgkwyuqkdwhzudsxvju","rwpddkvbnnugln","gloeofnpjqlkdsqvruvabjrikfwronbrdyyj","vbgeinupkvgmgxeaaiuiyojmoqkahwvbpwugdainxciedbdkos","mspuhbykmmumtveoighlcgpcapzczomshiblnvhjzqjlfkpina","rgmliajkiknongrofpugfgajedxicdhxinzjakwnifvxwlokip","fhepktaipapyrbylskxddypwmuuxyoivcewzrdwwlrlhqwzikq","qatithxifaaiwyszlkgoljzkkweqkjjzvymedvclfxwcezqebx"};
        int result = numMatchingSubseq(s, words);
        System.out.println(result);
    }

    public static int numMatchingSubseq(String s, String[] words){
        int pt_Origin = 0;
        int[] pt_Words = new int[words.length];
        boolean[] flags = new boolean[words.length];
        int count = 0;
//        int pt_Base = 0;
//        int pt_Compare = 1;
//        String temp = "" + s.charAt(0);
//        while(pt_Compare < s.length()){
//            if(s.charAt(pt_Base) != s.charAt(pt_Compare)){
//                pt_Base = pt_Compare;
//                temp += s.charAt(pt_Base);
//            }
//            pt_Compare++;
//        }

        while(pt_Origin < s.length()){
            for (int i = 0; i < words.length; i++) {
                if(!flags[i] && words[i].charAt(pt_Words[i]) == s.charAt(pt_Origin)){
                    pt_Words[i]++;
                }
                if(!flags[i] && pt_Words[i] == words[i].length()){
                    flags[i] = true;
                    count++;
                }
            }
            pt_Origin++;
        }
        return count;
    }
}

package BILIBILI;

/**
 * 哔哩哔哩2021校园招聘后端开发方向笔试卷B 企业提供原题
 * 一个由小写字母组成的字符串可以看成一些同一字母的最大碎片组成的。
 * 例如,"aaabbaaac"是由下面碎片组成的:'aaa','bb','c'。
 * 现在给定一个字符串,请你帮助计算这个字符串的所有碎片的平均长度是多少，结果直接取整，无需保留小数
 * 输入例子1: "aaabbaaac"
 * 输出例子1: 2
 * 例子说明1: 所有碎片的平均长度= (3 + 2 + 3 + 1) / 4 = 2
 *
 */

public class BiliBili_WordsBlock {
    public static void main(String[] args) {
        String s = "aaabbaaac";
        System.out.println(GetFragment(s));

    }

    /**
     * @param str 输入的字符串
     * @return 碎片的平均长度
     */
    public static int GetFragment (String str) {
        char[] list = str.toCharArray();
        int currentIndex;
        int nextIndex;
        int[] count = new int[list.length];

        for(currentIndex=0; currentIndex<list.length; currentIndex++) {
            count[currentIndex] = 1;
            for (nextIndex=currentIndex+1; nextIndex<list.length; nextIndex++) {
                if (list[currentIndex] == list[nextIndex]){
                    count[currentIndex] += 1;
                }
                else {
                    break;
                }
            }
            currentIndex = nextIndex-1;
        }

        int sum = 0;
        int numBlock = 0;
        for (int c : count) {
            if(c != 0) {
                numBlock ++;
            }
            sum = sum + c;
//            System.out.print(c+"\t");
        }
        return (numBlock == 0? 0:sum/numBlock);
    }
}

package BILIBILI;

/**
 * 哔哩哔哩2021校园招聘后端开发方向笔试卷A
 * 面值1元、4元、16元、64元共计4种硬币，以及面值1024元的纸币。
 * 现在小Y使用1024元的纸币购买了一件价值为N(0<N≤1024)的商品，
 * 请问最少他会收到多少硬币
 * 输入例子1: "200"
 * 输出例子1: 17
 * 例子说明1: 他会收到：12枚64元   3枚16元   2枚4元	0枚1元
 */

public class BiliBili_GetCoinCount {
    public static void main(String[] args) {
        int N = 200;
        int result = GetCoinCount(N);
        System.out.println(result);
    }

    public static int GetCoinCount (int N) {
        // write code here
        int totalCharge = 1024 - N;
        int numCoin = 0;

        int[] count = {0,0,0,0};
        for(int i=0; i<4; i++) {
            int mount = (int) Math.pow(4,(3-i));
            count[i] = calCoin(totalCharge, mount);
            totalCharge = totalCharge - mount * count[i];
        }

        for (int i : count) {
            numCoin += i;
            //System.out.print(i+"\t");
        }

        return numCoin;
    }

    public static int calCoin(int reste, int mount) {
        return reste / mount;
    }
}

package BILIBILI;

import java.util.ArrayList;
import java.util.List;

/**
 * 哔哩哔哩2021校园招聘后端开发方向笔试卷B
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素
 * 输入例子1: {{1, 2, 3, 4},    {5, 6, 7, 8},   {9,10,11,12},   {13,14,15,16}}
 * 输出例子1: [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
 * 例子说明1: 按照顺时针螺旋顺序，遍历矩阵中的所有元素
 */

public class BiliBili_PrintMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9,10,11,12},{13,14,15,16} };
        int[] res = SpiralMatrix(matrix);
        for(int i:res) {
            System.out.print(i + "\t");
        }
    }

    public static List<Integer> list = new ArrayList<>();

    public static int[] SpiralMatrix (int[][] matrix){
        int length = matrix[0].length;
        int width = matrix.length;
        int[] res = new int[length * width];

        while(matrix != null) {
            matrix = extract(matrix);
        }

        for(int i=0; i< list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * 被递归调用
     * 提取第一行元素，并逆时针循转90度
     * @param matrix
     * @return
     */
    public static int[][] extract (int[][] matrix) {
        int length = matrix[0].length;
        int width = matrix.length;

        // 提取第一行元素
        for(int j=0; j<length; j++) {
            list.add(matrix[0][j]);
        }

        // 删除以一行，将矩阵内剩下的部分转存到临时矩阵 temp[][] 中
        if(matrix.length > 1){
            int [][] temp = new int[width-1][length];
            for(int i=1; i<width; i++) {
                for(int j=0; j<length; j++) {
                    temp[i-1][j] = matrix[i][j];
                }
            }
            temp = rotate(temp);
            return temp;
        }
        else {
            return null;
        }

    }

    /**
     * 将矩阵旋转90度
     * @param origin
     * @return
     */
    public static int[][] rotate(int[][] origin) {
        int lenOrigin = origin[0].length;
        int widOrigin = origin.length;
        int [][] res = new int[lenOrigin][widOrigin];

        for(int i=0; i<widOrigin; i++) {
            for(int j=0; j<lenOrigin; j++) {
//                res[j][widOrigin-i-1]= origin[i][j]; // 顺时针旋转
                res[lenOrigin-1-j][i]= origin[i][j]; // 逆时针循转
            }
        }
        return res;
    }
}

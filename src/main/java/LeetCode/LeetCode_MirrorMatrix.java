package LeetCode;

public class LeetCode_MirrorMatrix {
    public static void main(String[] args) {
        int[][] matrix = {  {0,2,3},
                            {4,5,6},
                            {7,8,9}};
        mirror(transpose(matrix));
    }

    public static int[][] transpose(int[][] matrix) {
//        int[][] temp = new int[matrix[0].length][matrix.length];
        int temp = 0;
//        System.out.println(matrix[0].length);
//        System.out.println(matrix.length);
        for (int i = 0; i<matrix.length; i++) {
            for (int j = i; j<matrix.length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
//                System.out.println(temp);
            }
        }
        return matrix;
    }

    public static void mirror(int[][] matrix) {
        int temp = 0;

        for (int i = 0; i<matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - j-1] = temp;
            }
        }

        for (int i = 0; i<matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }



}
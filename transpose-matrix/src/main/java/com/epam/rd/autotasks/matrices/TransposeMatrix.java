package com.epam.rd.autotasks.matrices;
import java.util.Arrays;

public class TransposeMatrix {
    public static int[][] transpose(int[][] matrix) {

        int r = matrix.length;
        int c = matrix[0].length;

        int [][] res = new int[c][r];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[j][i] = matrix[i][j];
            }
        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        int[][] matrix = {
                {1, 2},
                {7, -13} };

        int[][] result = transpose(matrix);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }

}

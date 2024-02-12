package com.epam.rd.autotasks.matrices;
import java.util.Arrays;

public class MultiplyMatrix {
    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {

        int r = matrix1.length;
        int c = matrix2[0].length;
        int k = matrix2.length;

        int[][] res = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = 0;
                for (int n = 0; n < k; n++) {
                    res[i][j] += matrix1[i][n] * matrix2[n][j];
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        int[][] a = {
                {0, 12345},
                {4509, 0},
                {3, 567} };

        int[][] b = {
                {653, 0, 25353},
                {0, 61, 6} };

        int[][] result = multiply(a, b);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }
}

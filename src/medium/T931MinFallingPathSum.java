package medium;
/*
    给你一个 n x n 的 方形 整数数matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。

下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列
（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是
 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1)

 */

import org.junit.Test;

import java.util.Arrays;

public class T931MinFallingPathSum {
    @Test
    public void test() {
        int[][] matrix = {{3,2},{1,3}};
        System.out.println(minFallingPathSum(matrix));
    }

    /*    以下面矩阵为例：从倒数第二行开始，考虑每个位置的下一步三种情况中的最小和，将其赋值于倒数第二行，依次推到第一行取最小值
     *          2 1 3                   2   1   3               14  13  13
     *          6 5 4           ->      13  12  12      ->
     *          7 8 9
     *
     */
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {     //左右两边的情况单独考虑
                    matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);
                } else if (j == n - 1) {
                    matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i + 1][j - 1]);
                } else {
                    matrix[i][j] += Math.min(matrix[i + 1][j], Math.min(matrix[i + 1][j - 1], matrix[i + 1][j + 1]));
                }
            }
        }
        Arrays.sort(matrix[0]);
        return matrix[0][0];
    }

}

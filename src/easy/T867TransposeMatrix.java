package easy;

import java.util.Arrays;

public class T867TransposeMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        int[][] resMatrix = transpose(matrix);
        System.out.println(Arrays.deepToString(resMatrix));
    }

    private static int[][] transpose(int[][] matrix) {
        int nr = matrix.length;
        int nc = matrix[0].length;
        int[][] resMatrix = new int[nc][nr];
        for (int i = 0; i < nc; i++) {
            for (int j = 0; j < nr; j++) {
                resMatrix[i][j] = matrix[j][i];
            }
        }
        return resMatrix;
    }
}

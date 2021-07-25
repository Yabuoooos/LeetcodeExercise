package hard;

public class T85MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(maximalRectangle(matrix));
    }

    private static int maximalRectangle(char[][] matrix) {
        int nr = matrix.length;
        if (nr == 0) return 0;
        int nc = matrix[0].length;
        int res = 0;
        //记录每个'1'处及其上方一共右多少个'1'
        int[][] heights = new int[nr][nc];
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {   //计算每个以matrix[r][c]为右下角的矩形的面积
                if (matrix[r][c] != '0') {
                    heights[r][c] = getHeight(matrix, r, c);
                    res = Math.max(res, getRec(matrix, heights, r, c));
                }
            }
        }
        return res;
    }

    private static int getRec(char[][] matrix, int[][] heights, int r, int c) {
        int left = c - 1;      //当前最左边的'1'的位置
        while (left >= 0 && matrix[r][left] != '0') {
            left--;
        }
        int res = 0;
        for (int i = left + 1; i <= c; i++) {
            int width = c - i + 1;
            int height = heights[r][c];
            for (int j = i; j <= c; j++) {
                height = Math.min(height, heights[r][j]);
            }
            res = Math.max(res, width * height);
        }
        return res;
    }

    private static int getHeight(char[][] matrix, int r, int c) {
        int top = r - 1;
        while (top >= 0 && matrix[top][c] != '0') {
            top--;
        }
        return r - top;
    }

}

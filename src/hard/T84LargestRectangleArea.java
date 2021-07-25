package hard;

public class T84LargestRectangleArea {
    public static void main(String[] args) {
        int[] heights = {};
        System.out.println(largestRectangleArea(heights));
    }

    private static int largestRectangleArea(int[] heights) {
        int res = 0;
        for (int i = 0; i < heights.length; i++) {   //  计算以当前柱子为右边界的最大矩形面积
            res = Math.max(res, getRec(heights, i));
        }
        return res;
    }

    private static int getRec(int[] heights, int index) {
        int res = heights[index];
        for (int i = 0; i < index + 1; i++) {
            int width = index - i + 1;
            int height = heights[index];
            for (int j = i; j < index + 1; j++) {
                height = Math.min(height, heights[j]);
            }
            res = Math.max(res, width * height);
        }
        return res;
    }
}

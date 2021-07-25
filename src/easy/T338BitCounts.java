package easy;

import java.util.Arrays;

public class T338BitCounts {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(30)));
    }

    private static int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            res[i] = (i % 2 == 0) ? res[i / 2] : res[i - 1] + 1;
        }
        return res;
    }
}


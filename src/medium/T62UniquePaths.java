package medium;

public class T62UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(9, 9));
    }

    private static int uniquePaths(int m, int n) {
        long x = 1, y = 1;
        for (int i = m + n - 2; i > (m >= n ? m - 1 : n - 1); i--) {
            x *= i;
            y *= (i - (m >= n ? m - 1 : n - 1));
        }
        double res = x / y;
        return (int) res;
    }
}

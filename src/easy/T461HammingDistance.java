package easy;

public class T461HammingDistance {
    public static void main(String[] args) {
        int a = 4;
        int b = 1;
        System.out.println(hammingDistance(a, b));
    }

    public static int hammingDistance(int a, int b) {
        int c = a ^ b;
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            int temp = c >> 1;
            if (2 * temp != c) {
                ret++;
            }
            c = temp;
        }
        return ret;
    }
}

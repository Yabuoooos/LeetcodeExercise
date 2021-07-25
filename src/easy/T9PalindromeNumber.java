package easy;

public class T9PalindromeNumber {
    public static void main(String[] args) {
        int x = 13231;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        //负数一定不回文
        //最后一位为0且大于0的数也一定不回文
        if (x < 0 || (x > 0 && x % 10 == 0)) return false;

        String s = "" + x;
        int res = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            res = 10 * res + x % 10;
            x = x / 10;
        }
        //if (res == x || res == x / 10) return true;
        //else return false;
        return res == x || res == x / 10;
    }
}

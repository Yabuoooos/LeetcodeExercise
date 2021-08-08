package medium;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author Wangyaobin
 * @date 2021/8/8
 */
public class T12IntToRoman {
    @Test
    public void test() {
        System.out.println(intToRoman(83));
    }

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String ans = "";
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                ans += roman[i];
                num -= values[i];
            }
        }
        return ans;
    }
}

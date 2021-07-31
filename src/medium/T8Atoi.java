package medium;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;

public class T8Atoi {
    @Test
    public void test() {
        System.out.println(myAtoi("abc"));
    }

    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        int temp = s.charAt(0) - '0';
        if (s.length() == 1) {
            return (temp >= 0 && temp <= 9) ? temp : 0;
        }
        boolean positive;
        if (s.charAt(0) == '-') {
            positive = false;
        } else if (s.charAt(0) == '+' || (temp >= 0 && temp <= 9)) {
            positive = true;

        } else {
            return 0;
        }
        if (!(s.charAt(1) - '0' >= 0 && s.charAt(1) - '0' <= 9)) {
            return (temp >= 0 && temp - '0' <= 9) ? temp : 0;
        }
        //到这一步charAt(0)要么是正负号要么是数字
        int lastIndexOfNum = 1;
        while (lastIndexOfNum < s.length() && s.charAt(lastIndexOfNum) - '0' >= 0 && s.charAt(lastIndexOfNum) - '0' <= 9) {
            lastIndexOfNum++;
        }
        BigInteger bigInteger = new BigInteger(s.substring((s.charAt(0) == '+' || s.charAt(0) == '-') ? 1 : 0, lastIndexOfNum));
        int len1 = bigInteger.toString().length();
        int len2 = ("" + Integer.MAX_VALUE).length();
        if (positive) {
            if (len1 > len2) {
                return Integer.MAX_VALUE;
            }
            if (len1 == len2) {
                String[] strs = {bigInteger.toString(), ""+Integer.MAX_VALUE};
                Arrays.sort(strs);
                return Integer.parseInt(strs[0]);
            }
            return bigInteger.intValue();
        } else {
            //bigInteger中不包含'-'号
            if (len1 > len2) {
                return Integer.MIN_VALUE;
            }
            if (len1 == len2) {
                String[] strs = {"-"+bigInteger.toString(),""+Integer.MIN_VALUE};
                Arrays.sort(strs);
                return Integer.parseInt(strs[0]);
            }
            return bigInteger.intValue() * -1;
        }
    }
}

package medium;

import java.util.Arrays;
import java.util.Comparator;

public class T1048LongestStringChain {
    public static void main(String[] args) {
        String[] strs = {"a", "b", "ba", "bdca", "bca", "bda"};
        Solution sol = new Solution();
        System.out.println(sol.longestStrChain(strs));
    }
}

class Solution {
    public int longestStrChain(String[] words) {
        //字符串数组按照各个元素的长度排序
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int len = words.length;
        int[] dp = new int[len];
        int res = 0;
        for (int i = 0; i < len; i++) {
            String a = words[i];
            for (int j = i + 1; j < len; j++) {
                String b = words[j];
                if (isPredecessor(a,b)){
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                    res = Math.max(dp[j], res);
                }
            }
        }
        return res + 1;


    }

    //判断 s1 是否是 s2 的前身
    public boolean isPredecessor(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len2 - len1 != 1) {
            return false;
        }
        for (int i = 0; i < len2; i++) {
            StringBuffer sb = new StringBuffer(s2);
            if (sb.deleteCharAt(i).toString().equals(s1)) {
                return true;
            }
        }
        return false;
    }
}
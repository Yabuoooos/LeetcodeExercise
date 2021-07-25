package medium;

import java.util.*;

public class T3LongestSubstringwithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "asdfgha";
        System.out.println(lengthOfLongestSubstring(s));
    }

    private static int lengthOfLongestSubstring(String s) {
        int res = 0;
        int n = s.length();
        HashSet<Character> hashSet = new HashSet<>();
        int rightPivot = -1;    //右指针初始设置为-1
        for (int i = 0; i < n; i++) {    //i即为左指针
            if (i != 0) {
                hashSet.remove(s.charAt(i - 1));
            }
            while (rightPivot + 1 < n && !hashSet.contains(s.charAt(rightPivot + 1))) {
                hashSet.add(s.charAt(rightPivot + 1));
                rightPivot++;
            }
            res = Math.max(res, rightPivot + 1 - i);
        }
        return res;
    }
}

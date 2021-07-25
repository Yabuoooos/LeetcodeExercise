package medium;


public class T5LongestPalindrome {
    public static void main(String[] args) {
        String s = "b";
        System.out.println(longestPalindrome(s));
    }

    private static String longestPalindrome(String s) {
        int len = s.length();
        int[] lengthAtEachIndex = new int[len];
        lengthAtEachIndex[len - 1] = 1;
        for (int i = 0; i < len - 1; i++){
            //设置初始尾部为最后一个字符
            int temp = len - 1;
            while (!judge(s,i,temp)){
                temp--;
            }
            lengthAtEachIndex[i] = temp - i + 1;
        }
        int index = 0, maxLength = 0;
        for (int i = 0; i < len; i++){
            index = maxLength >= lengthAtEachIndex[i] ? index : i;
            maxLength = Math.max(maxLength, lengthAtEachIndex[i]);
        }
        return s.substring(index, index + lengthAtEachIndex[index]);
    }

    private static boolean judge(String s, int i , int j){
        while (i <= j){
            if (s.charAt(i) == s.charAt(j)){
                return judge(s, i + 1, j - 1);
            }else {
                return false;
            }
        }
        return true;
    }
}

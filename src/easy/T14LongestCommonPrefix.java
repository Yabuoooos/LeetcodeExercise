package easy;


public class T14LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    private static String longestCommonPrefix(String[] strs) {
        //特排
        if (strs.length == 0) return null;
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            res = getCommon(res, strs[i]);
            //若已经为空串则直接返回
            if (res == "") {
                return res;
            }
        }
        return res;
    }

    //返回两个字符串的公共前缀
    private static String getCommon(String s1, String s2) {
        String ret = "";
        int i = 0;
        while (i < Math.min(s1.length(), s2.length())) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return ret;
            }
            ret += s1.charAt(i++);
        }
        return ret;
    }

}

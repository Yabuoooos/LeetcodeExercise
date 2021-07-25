package easy;

public class T1047RemoveDuplicates {
    public static void main(String[] args) {
        String s = "abbbabaaa";
        System.out.println(removeDuplicates(s));
    }

    private static String removeDuplicates(String S) {
        boolean flag = true;
        while (S.length() > 1) {
            String res = "";
            int i = 0;
            while (i < S.length()) {
                if (i == S.length() - 1) {
                    res += S.charAt(i);
                    break;
                }
                if (S.charAt(i) == S.charAt(i + 1)) i += 2;
                else {
                    res += S.charAt(i);
                    i++;
                }
            }
            if (res.equals(S)) return res;
            S = res;
        }
        return S;
    }
}

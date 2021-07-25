package easy;

public class T415AddString {
    public static void main(String[] args) {
        String num1 = "4569";
        String num2 = "123";
        System.out.println(addStrings(num1, num2));
    }
    //官方题解
    public static String addStrings(String num1, String num2) {
        StringBuffer sb = new StringBuffer();
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        while (i >= 0 || j >= 0 || add > 0) {
            int x = (i >= 0 ? num1.charAt(i) - '0' : 0);
            int y = (j >= 0 ? num2.charAt(j) - '0' : 0);
            int sum = x + y + add;
            sb.append(sum % 10);
            add = sum / 10;
            i--;
            j--;
        }
        //StringBuffer自带翻转功能
        sb.reverse();
        return sb.toString();
    }

}

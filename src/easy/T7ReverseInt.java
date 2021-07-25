package easy;

public class T7ReverseInt {
    public static void main(String[] args) {
        int x = -123;
        int res = reverse(x);
        System.out.println(res);
    }

    public static int reverse(int x) {
        String s = "" + x;
        StringBuffer res = new StringBuffer();
        //若输入的整数为负数
        if (s.charAt(0) == '-') {
            res.append('-');
            for (int i = s.length() - 1; i > 0; i--) {
                res.append(s.charAt(i));
            }
        } else {
            for (int i = s.length() - 1; i >= 0; i--) {
                res.append(s.charAt(i));
            }
        }
        //int的最大范围是[Integer.MIN_VALUE,Integer.MAX_VALUE]->[-2,147,483,648,2,147,483,647]
        try{
            int intRes = Integer.parseInt(res.toString());
            return intRes;
        }catch (NumberFormatException e){
            return 0;
        }
    }
}

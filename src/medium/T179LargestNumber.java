package medium;

public class T179LargestNumber {
    public static void main(String[] args) {
        int[] nums = {999999991,9};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        //排序规则：->  比较每个数从左数第一位,第一位大的放前面
        //         ->  第一位一样的,继续比较下一位,若没有下一位的数,其下一位仍为当前位
        //         34,343 -> 343比较到个位为3： 此时34没有下一位,其下一位为当前位(4) -> 34343 > 34334
        for (int i = 0; i < nums.length - 1; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (compare(nums[i],nums[j]) != nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        String res = "";
        for (int i = 0; i < nums.length; i++){
            res += nums[i];
        }
        return res;
    }


    private static int compare(int a, int b) {
        String s1 = Integer.toString(a);
        String s2 = Integer.toString(b);

        return Long.parseLong(s1+s2) > Long.parseLong(s2+s1) ? a : b;
    }
}

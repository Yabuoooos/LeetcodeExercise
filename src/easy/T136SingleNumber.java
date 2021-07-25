package easy;

import java.util.Arrays;

public class T136SingleNumber {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,5,8,8};
        System.out.println(singleNumber(nums));
        System.out.println(singleNumberOfficalSolution(nums));
    }

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            if (i == nums.length - 1 || nums[i] != nums[i + 1]) return nums[i];
        }
        return -1;
    }

    public static int singleNumberOfficalSolution(int[] nums){
        int single = 0;
        //任何数与0异或，都是原来的数a^0 = a
        //任何数与自身异或，都是0：a^a = 0
        //异或满足交换律结合律
        //nums逐个异或可以写成：(a1 ^ a1) ^ (a2 ^ a2)...(an ^ an) ^ an+1 = an+1
        for (int num : nums){
            single ^= num;
        }
        return single;
    }
}

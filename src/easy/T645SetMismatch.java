package easy;

import org.junit.Test;

import java.util.*;

public class T645SetMismatch {
    @Test
    public void test(){
        int[] nums = {1,2,3,3,4};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }


    public int[] findErrorNums(int[] nums) {
        int len = nums.length;
        //统计各个数字个数
        HashMap<Integer,Integer> hMap = new HashMap<Integer,Integer>();
        for (int num : nums){
            hMap.put(num, hMap.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[2];
        for (int i = 0; i < len; i++) {
            int freq = hMap.getOrDefault(i + 1,0);
            if (freq == 2){
                res[0] = i + 1;
            }
            if (freq == 0) {
                res[1] = i + 1;
            }
        }
        return res;
    }
}

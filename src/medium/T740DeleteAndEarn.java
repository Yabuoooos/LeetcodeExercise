package medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class T740DeleteAndEarn {

    @Test
    public void test() {
        int[] nums = {1 , 3};
        System.out.println(deleteAndEarn(nums));
    }

    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        //统计各个数字出现的次数
        for (int num : nums) {
            numsMap.put(num, numsMap.getOrDefault(num, 0) + 1);
        }
        int len = nums[nums.length - 1] - nums[0] + 1;
        int[] total = new int[len];

        //统计从nums的最小值到最大值范围内每个整数与其出现个数的乘积
        int temp = nums[0];
        for (int i = 0; i < len; i++) {
            total[i] = temp * numsMap.getOrDefault(temp++, 0);
        }

        //此后化为打家劫舍Ⅰ
        if (len == 1) return total[0];
        int[] dp = new int[len];
        dp[0] = total[0];
        dp[1] = Math.max(total[0], total[1]);
        for (int j = 2; j < len; j++) {
            dp[j] = Math.max(dp[j - 1], dp[j - 2] + total[j]);
        }
        return dp[len - 1];
    }

}

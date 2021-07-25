package medium;

import org.junit.Test;

public class T55JumpGame {
    @Test
    public void test(){
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }

    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len == 1) return true;
        boolean[] dp = new boolean[len];
        dp[0] = true;
        label: for (int i = 1; i < len; i++) {
            for (int j = 1; j <= i; j++) {
                if (dp[i - j] && nums[i - j] > j - 1) {
                    dp[i] = true;
                    continue label;
                }
            }
            return false;
        }
        return dp[len - 1];
    }
}

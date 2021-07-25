package medium;

public class T494FindTargetSumWays {
    public static void main(String[] args) {
        int[] nums = {2, 107, 109, 113, 127, 131, 137, 3, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 47, 53};
        int target = 100;
        System.out.println(findTargetSumWays(nums, target));
    }

    private static int findTargetSumWays(int[] nums, int target) {
        //正子集S[P],负子集S[N],数组元素相加为sum.
        //则S[P] + S[N] = sum, S[P] - S[N] = target -> S[N] = (sum - target)/2
        //原问题化为求出数组中满足上述条件的子集的数目.
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //若sum - target不为偶数，或者sum < target则无法满足条件
        if (sum < target || (sum - target) % 2 != 0) {
            return 0;
        }
        int neg = (sum - target) / 2;
        //定义dp[i][j]数组：i表示利用数组中的前i(i从1开始算)个元素来凑S[N];j表示利用前i个元素(也可以不使用)等于j的方案
        //i的取值范围为[0,nums.length],j的取值范围为[0,S[N]]
        int n = nums.length;
        int[][] dp = new int[n + 1][neg + 1];
        //当i=0,dp[0][j] = (j == 0) ? 1 : 0
        dp[0][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < neg + 1; j++) {
                //当i>0时,若j < nums[i] -> 不可以利用第i个元素来构造等于j的方案,即 dp[i][j] = dp[i - 1][j]
                //若j >= nums[i] -> 第i个元素可以被用到方案构造中(也可以不用),即 dp[i][j] = dp[i - 1][j] (不用第i个)+ dp[i - 1][j - nums[i]](用第i个)
                dp[i][j] = (j < nums[i - 1]) ? dp[i - 1][j] : dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];    //i的取值范围是[1,5],因此取nums[i - 1]
            }
        }
        return dp[n][neg];
    }
}

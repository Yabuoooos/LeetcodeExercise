package easy;

public class T53MaxSubArraySum {
    public static void main(String[] args) {
        int[] nums = {-2, 1, 3, -2, 4, -5, 3};
        System.out.println(maxSubArray(nums));
    }

    private static int maxSubArray(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    public static IntervalInfo getInfo(int[] a, int l, int r) {
        if (l == r) {
            return new IntervalInfo(a[l], a[l], a[l], a[l]);
        }
        int m = (l + r) / 2;
        IntervalInfo lInterval = getInfo(a, l, m);
        IntervalInfo rInterval = getInfo(a, m + 1, r);
        return merge(lInterval, rInterval);
    }

    //处理合并子区间
    public static IntervalInfo merge(IntervalInfo left, IntervalInfo right) {
        int lSum = Math.max(left.lSum, left.iSum + right.lSum);
        int rSum = Math.max(right.rSum, right.iSum + left.rSum);
        int iSum = left.iSum + right.iSum;
        //左区间最大子序和、右区间最大子序和、左区间右端点为终点最大子序和 + 右区间左端点为起点最大自序和 三者取最大值
        int mSum = Math.max(Math.max(left.mSum, right.mSum), left.rSum + right.lSum);
        return new IntervalInfo(lSum, rSum, iSum, mSum);
    }

    //定义一个类为区间信息
    static class IntervalInfo {
        public int lSum, rSum, iSum, mSum;

        /*  区间包括下面属性：
            lSum:左端点为起点的最大子序和
            rSum:右端点为终点的最大子序和
            iSum:区间和
            mSum:区间最大子序和
         */
        public IntervalInfo(int lSum, int rSum, int iSum, int mSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.iSum = iSum;
            this.mSum = mSum;
        }
    }

}

package hard;

import org.junit.Test;

import java.util.Arrays;

public class T4FindMedianSortedArrays {
    @Test
    public void test() {
        int[] num1 = {1,2};
        int[] num2 = {3,4};
        System.out.println(findMedianSortedArrays(num1, num2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        //数组拼接
        int[] nums = Arrays.copyOf(nums1, m + n);
        System.arraycopy(nums2, 0, nums, m, n);
        Arrays.sort(nums);
        int index = (m + n) / 2;
        if ((m + n) % 2 == 0) {
            return (double) (nums[index - 1] + nums[index]) / 2;
        } else {
            return nums[index];
        }
    }

}

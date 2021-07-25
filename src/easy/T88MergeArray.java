package easy;

import java.util.Arrays;

public class T88MergeArray {
    public static void main(String[] args) {
        int[] nums1 = {2, 0};
        int[] nums2 = {1};
        merge(nums1, 1, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n == 0) return;
        int i = 0;
        int j = 0;
        int temp = 0;
        int[] resNums = new int[m + n];
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                resNums[temp] = nums1[i];
                i++;
                temp++;
            } else {
                resNums[temp] = nums2[j];
                j++;
                temp++;
            }
        }

        if (i == m) {
            while (j < n) {
                resNums[temp] = nums2[j];
                j++;
                temp++;
            }
        } else {
            while (i < m) {
                resNums[temp] = nums1[i];
                i++;
                temp++;
            }
        }
        for (int k = 0; k < m + n; k++) {
            nums1[k] = resNums[k];
        }
        return;
    }
}

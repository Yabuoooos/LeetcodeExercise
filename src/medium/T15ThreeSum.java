package medium;

import java.util.*;

public class T15ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        HashSet<Integer> targetSet = new HashSet<>();
        for (int i = 0; i < len; i++) {
            targetSet.add(nums[i]);
        }
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (targetSet.contains(-(nums[i] + nums[j]))) {

                }
            }
        }
        return null;
    }
}

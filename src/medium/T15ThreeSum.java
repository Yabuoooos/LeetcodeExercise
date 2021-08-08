package medium;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T15ThreeSum {
    @Test
    public void test() {
        int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println(threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                twoSum(nums, -nums[i], i + 1, n - 1, ans);
            }
        }
        return ans;
    }

    private void twoSum(int[] nums, int target, int start, int end, List<List<Integer>> ans) {
        while (start < end) {
            if ((nums[start] + nums[end] == target)) {
                Integer[] temp = {-target, nums[start], nums[end]};
                List<Integer> tempList = Arrays.asList(temp);
                if (ans.isEmpty() || !ans.get(ans.size() - 1).equals(tempList)) {
                    ans.add(tempList);
                }
                start++;
                end--;
            } else if ((nums[start] + nums[end]) < target) {
                start++;
            } else {
                end--;
            }
        }
    }
}

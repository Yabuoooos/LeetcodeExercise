package easy;

import java.util.ArrayList;
import java.util.List;

public class T448FindDisappearedNumbers {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(nums));

    }

    private static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        //用数组模拟HashMap
        for (int num : nums) {
            nums[(num - 1) % 8] += n;
        }
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                res.add(i + 1);
            }
        }
        return res;
    }
}

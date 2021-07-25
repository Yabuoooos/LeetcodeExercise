package easy;

import java.util.Arrays;
import java.util.HashMap;

public class T1TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 13;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //以nums里的值作为key，index作为value，这样可以调用containsKey方法来查看是否包含目标值
            if (hMap.containsKey(target - nums[i])) {
                //int[] res = {hMap.get(target - nums[i]), i};
                return new int[] {hMap.get(target - nums[i]), i};
            }
            hMap.put(nums[i], i);
        }
        return new int[0];
    }
}

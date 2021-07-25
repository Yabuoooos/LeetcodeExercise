package medium;

import org.junit.Test;

public class T33SearchInRotatedSortedArray {
    @Test
    public void test() {
        int[] nums = {3,1};
        System.out.println(search(nums, 3));
    }

    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        int mid = 0;
        while (left <= right){
            mid = (left + right)/2;
            if (nums[mid] == target)    return mid;
            //nums[mid] > nums[left]说明左半部分有序
            //右半部分可以视为一个新的旋转排序数组
            if (nums[mid] >= nums[left]) {
                if (nums[mid] > target && nums[left] <= target){
                    right = mid - 1;
                }else { //目标值在右半无序的部分
                    left = mid + 1;
                }
            }else{  //右半部分有序
                if (nums[mid] < target && nums[right] >= target){
                    left = mid + 1;
                }else { //目标值在左半无序的部分
                    right = mid - 1;
                }

            }
        }
        return -1;

    }
}

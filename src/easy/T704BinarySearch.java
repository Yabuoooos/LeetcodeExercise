package easy;

public class T704BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 12;
        System.out.println(search(nums, target));

    }

    public static int search(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;
        return search(nums, L, R, target);
    }

    public static int search(int[] nums, int L, int R, int target) {
        if (L > R) return -1;

        int mid = (L + R) / 2;
        if (nums[mid] > target) {
            return search(nums, L, mid - 1, target);
        } else if (nums[mid] < target) {
            return search(nums, mid + 1, R, target);
        } else {
            return mid;
        }
    }

}


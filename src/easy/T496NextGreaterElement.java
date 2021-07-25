package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class T496NextGreaterElement {
    public static void main(String[] args) {
        int[] nums1 = {4, 2};
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] res1 = new int[length1];
        //对nums2中的每一个元素求出下一个最大元素
        int[] res2 = new int[length2];
        Arrays.fill(res2, -1);
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < length2; i++) {
            hashMap.put(nums2[i], i);
            int currVal = nums2[i];
            while (!stack.isEmpty() && currVal > nums2[stack.peek()]) {
                res2[stack.pop()] = currVal;
            }
            stack.push(i);
        }
        for (int i = 0; i < length1; i++) {
            res1[i] = res2[hashMap.get(nums1[i])];
        }
        return res1;
    }
}

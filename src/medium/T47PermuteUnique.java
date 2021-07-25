package medium;
/*
 *  给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列
 *  输入：num = [1,1,2]
 *  输出：[[1,1,2],
 *        [1,2,1],
 *        [2,1,1]]
 */

import org.junit.Test;

import java.util.*;

public class T47PermuteUnique {
    @Test
    public void test() {
        int[] num = {1, 3, 2};
        System.out.println(permuteUnique(num));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> arrays = new HashSet<>();
        Deque<Integer> array = new ArrayDeque<>();
        int len = nums.length;
        boolean[] isVisit = new boolean[len];
        dfs(nums, isVisit, len, 0, array, arrays);
        List<List<Integer>> res = new ArrayList<>();
        for (List list : arrays) {
            res.add(list);
        }
        return res;
    }

    public void dfs(int[] nums, boolean[] isVisited, int len, int depth, Deque array, HashSet arrays) {
        if (depth == len) {
            arrays.add(new ArrayList<>(array));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (isVisited[i]) continue;
            array.add(nums[i]);
            isVisited[i] = true;
            dfs(nums, isVisited, len, depth + 1, array, arrays);
            isVisited[i] = false;
            array.removeLast();
        }
    }
}

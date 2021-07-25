package medium;

import java.util.*;

public class T46Permute {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    private static List<List<Integer>> permute(int[] nums){
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0){
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        //定义一个状态变量用来遍历整个状态空间
        boolean[] visited = new boolean[len];
        dfs(nums, len, 0, path, res, visited);
        return res;
    }

    private static void dfs(int[] nums, int len, int depth, Deque<Integer> path, List<List<Integer>> res, boolean[] visited) {
        if (depth == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (visited[i]) continue;
            path.addLast(nums[i]);
            visited[i] = true;
            dfs(nums, len, depth + 1, path, res, visited);
            //回溯后要把改变的状态回归
            path.removeLast();
            visited[i] = false;
        }
    }
}

package easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//TreeNode类在别的题中已有定义

public class T671SecondMinNode {
    @Test
    public void test() {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        node5.left = node6;
        node5.right = node7;
        System.out.println(findSecondMinimumValue(node1));
    }


    public int findSecondMinimumValue(TreeNode root) {
        HashSet<Integer> set = new HashSet<>();
        dfs(root, set);
        if (set.size() < 2) {
            return -1;
        }
        List<Integer> list = new ArrayList<>(set);
//        list.sort((o1, o2) -> o1 - o2);
        return list.get(1);
    }

    void dfs(TreeNode node, HashSet<Integer> set) {
        if (node == null) {
            return;
        }
        set.add(node.val);
        dfs(node.left, set);
        dfs(node.right, set);
    }

}


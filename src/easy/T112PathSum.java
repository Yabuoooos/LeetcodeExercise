package easy;

import java.util.*;

public class T112PathSum {
    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(5);
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(8);
        TreeNode n3 = new TreeNode(11);
        TreeNode n4 = new TreeNode(13);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(7);
        TreeNode n7 = new TreeNode(2);
        setLeftRight(n0, n1, n2);
        setLeftRight(n1, n3, null);
        setLeftRight(n2, n4, n5);
        setLeftRight(n3, n6, n7);
        System.out.println(hasPathSum2(n0, 23));
    }

    private static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        //当前结点没有子结点
        if (root.left == null && root.right == null) return root.val == targetSum;
        //对于当前结点的子结点，判断以子结点为根结点的树中是否存在一条路径和为(targetSum - root.val)
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    private static boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) return false;
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        Queue<Integer>  values = new LinkedList<Integer>();
        nodes.offer(root);
        values.offer(root.val);
        while(!nodes.isEmpty()){
            if (nodes.peek().left == null && nodes.peek().right == null){   //遍历到了叶子结点
                if (values.peek() == targetSum) return true;    //若相等则返回true，不相等继续寻找
            }
            TreeNode currNode = nodes.poll();
            int currVal = values.poll();
            if (currNode.left != null){
                nodes.offer(currNode.left);
                values.offer(currVal+currNode.left.val);
            }
            if (currNode.right != null){
                nodes.offer(currNode.right);
                values.offer(currVal+currNode.right.val);
            }
        }
        return false;
    }



    private static void setLeftRight(TreeNode t1, TreeNode t2, TreeNode t3) {
        t1.left = t2;
        t1.right = t3;
    }
}

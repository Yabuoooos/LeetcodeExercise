package easy;

public class T110BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(4,new TreeNode(7),null)
                ,new TreeNode(5)),new TreeNode(3,null, new TreeNode(6,null,new TreeNode(8))));
        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(TreeNode root) {
        TreeNode curr = root;
        if (curr == null)   return true;
        if (Math.abs(leftHeight(curr) - rightHeight(curr)) > 1)  return false;
        else {
            if (curr.left != null){
                curr = curr.left;
                return isBalanced(curr);
            }
            if (curr.right != null){
                curr = curr.right;
                return isBalanced(curr);
            }
            return true;
        }
    }

    private static int height(TreeNode node){
        return Math.max(node.left == null ? 0 : height(node.left), node.right == null ? 0 : height(node.right))+1;
    }

    private static int leftHeight(TreeNode node){
        return node.left == null ? 0 : height(node.left);
    }

    private static int rightHeight(TreeNode node){
        return node.right == null ? 0 : height(node.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode()  {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

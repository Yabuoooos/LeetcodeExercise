package easy;

public class T101SymmetricBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, (new TreeNode(2, null, new TreeNode(3))), (new TreeNode(2, null, new TreeNode(3))));
        System.out.println(isSymmetric(root));

    }

    private static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return judgeLeftRight(root.left, root.right);
    }

    private static boolean judgeLeftRight(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 != null && node2 != null) {
            return node1.val == node2.val && judgeLeftRight(node1.left, node2.right) && judgeLeftRight(node1.right, node2.left);
        }
        return false;

    }

}

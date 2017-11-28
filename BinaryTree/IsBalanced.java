package BinaryTree;

//Program to check whether given binary tree is height balanced
public class IsBalanced {
    private static TreeNode root, prev;

    public static void main(String[] args) {
        root = new TreeNode(4);
        root.leftChild = new TreeNode(2);
        root.rightChild = new TreeNode(5);
        root.leftChild.leftChild = new TreeNode(1);
        root.leftChild.rightChild = new TreeNode(3);
        root.leftChild.leftChild.leftChild = new TreeNode(0);
        boolean isBST = isBal(root);
        System.out.print(isBST);
    }

    private static boolean isBal(TreeNode root) {
        if (root == null) return true;
        int leftHeight = height((root.leftChild));
        int rightHeight = height(root.rightChild);
        return (Math.abs(leftHeight - rightHeight) <= 1 && isBal(root.leftChild) && isBal(root.rightChild));

    }

    private static int height(TreeNode root) {
        if (root == null)
            return 0;
        int height = 0;
        return (1 + Math.max(height(root.leftChild), height(root.rightChild)));
    }

}

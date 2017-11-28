package BinaryTree;

//Program to check whether given binary tree is BST or not
public class IsValidBST {

    private static TreeNode root, prev;

    public static void main(String[] args) {
        root = new TreeNode(4);
        root.leftChild = new TreeNode(2);
        root.rightChild = new TreeNode(5);
        root.leftChild.leftChild = new TreeNode(1);
        root.leftChild.rightChild = new TreeNode(3);
        boolean isBST = isBST(root);
        System.out.print(isBST);
    }

    private static boolean isBST(TreeNode root) {
        if (root != null) {
            if (!isBST(root.leftChild))
                return false;

            if (prev != null && root.key <= prev.key)
                return false;
            prev = root;

            return isBST(root.rightChild);
        }
        return true;
    }
}

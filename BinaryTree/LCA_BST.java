package BinaryTree;

public class LCA_BST {
    private static TreeNode root;

    public static void main(String[] args) {
        root = new TreeNode(20);
        root.leftChild = new TreeNode(8);
        root.rightChild = new TreeNode(22);
        root.leftChild.leftChild = new TreeNode(4);
        root.leftChild.rightChild = new TreeNode(12);
        root.leftChild.rightChild.leftChild = new TreeNode(10);
        root.leftChild.rightChild.rightChild = new TreeNode(14);
        TreeNode node = findLCA(root, 10, 14);
        System.out.print(node.key);
    }

    private static TreeNode findLCA(TreeNode root, int i, int j) {
        if (root == null)
            return null;

        if (root.key < i && root.key < j)
            return findLCA(root.rightChild, i, j);

        if (root.key > i && root.key > j) {
            return findLCA(root.leftChild, i, j);
        } else return root;
    }
}

package BinaryTree;

import java.util.Scanner;

public class KthSmallest {
    private static TreeNode root;
    static int i = 0;

    public static void main(String[] args) {
        root = new TreeNode(20);
        root.leftChild = new TreeNode(8);
        root.rightChild = new TreeNode(22);
        root.leftChild.leftChild = new TreeNode(4);
        root.leftChild.rightChild = new TreeNode(12);
        root.leftChild.rightChild.leftChild = new TreeNode(10);
        root.leftChild.rightChild.rightChild = new TreeNode(14);

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        TreeNode node = findKth(root, k);
        System.out.print(node.key);
    }

    private static TreeNode findKth(TreeNode root, int k) {
        // Do inorder traversal and keep track of count

        if (root == null)
            return null;
        TreeNode left = findKth(root.leftChild, k);
        if (left != null) return left;
        if (++i == k) {
            return root;
        }
        return findKth(root.rightChild, k);
    }

}

package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

//Prints Level order traversal per line
public class LevelOrderByLine {

    private static TreeNode root;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.leftChild = new TreeNode(10);
        root.rightChild = new TreeNode(15);
        root.leftChild.leftChild = new TreeNode(20);
        root.leftChild.rightChild = new TreeNode(25);
        root.rightChild.leftChild = new TreeNode(30);
        root.rightChild.rightChild = new TreeNode(35);
        printLevelOrder(root);
    }

    private static void printLevelOrder(TreeNode root) {
        int levelNodes = 0;
        if (root == null) {
            return;
        } else if (root.leftChild == null && root.rightChild == null) {
            System.out.print(root.key);
            return;
        } else {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                levelNodes = queue.size();
                while (levelNodes > 0) {
                    TreeNode node = queue.poll();
                    System.out.print(node.key + " ");
                    if (node.leftChild != null)
                        queue.add(node.leftChild);
                    if (node.rightChild != null)
                        queue.add(node.rightChild);
                    levelNodes--;
                }
                System.out.println("");
            }
        }
    }
}

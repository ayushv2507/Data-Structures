package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BInaryTree {
    private static TreeNode root;

    public static void main(String[] args) {
      /*  root = new TreeNode(2);
        root.leftChild = new TreeNode(7);
        root.rightChild = new TreeNode(5);
        root.leftChild.rightChild = new TreeNode(6);
        root.leftChild.rightChild.leftChild = new TreeNode(1);
        root.leftChild.rightChild.rightChild = new TreeNode(11);
        root.rightChild.rightChild = new TreeNode(9);
        root.rightChild.rightChild.leftChild = new TreeNode(3);*/
        root = new TreeNode(1);
        root.leftChild = new TreeNode(2);
        root.rightChild = new TreeNode(3);
        root.leftChild.leftChild = new TreeNode(4);
        root.leftChild.rightChild = new TreeNode(5);
        root.rightChild.leftChild = new TreeNode(6);
        root.rightChild.rightChild = new TreeNode(7);

       /* int max = findMax(root);
        System.out.print(max);
        int size = size(root);
        System.out.print(size);
        int height = height(root);
        System.out.print(height);

        int leaves = countLeaves(root);
        System.out.print(leaves);

        int sum = sumOfElements(root);
        System.out.print(sum);*/
        /*int diameter = diameter(root);
        System.out.print(diameter);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();*/
       /* BFS(root,n);
          DFS(root,n); */
       /* int level = maxSumLevel(root);
        System.out.print(level);*/
       /* TreeNode lca = findLCA(root,4,5);
        System.out.print(lca.key);*/
        boolean isPath = findPathSum(root, 9);
        System.out.print(isPath);

    }

    //Replace Math.max with Math.min and init variables with Integer.MAX_VALUE to find min
    private static int findMax(TreeNode root) {
        int result = 0, max = 0;
        int leftMax = 0, rightMax = 0;

        if (root == null)
            return 0;
        int rootValue = root.key;
        if (root.leftChild != null) {
            leftMax = findMax(root.leftChild);
        }
        if (root.rightChild != null) {
            rightMax = findMax(root.rightChild);
        }

        max = Math.max(leftMax, rightMax);
        result = Math.max(max, rootValue);
        return result;
    }

    private static int size(TreeNode root) {
        if (root == null)
            return 0;
        int size = 0;
        return (1 + size(root.leftChild) + size(root.rightChild));
    }

    private static int height(TreeNode root) {
        if (root == null)
            return 0;
        int height = 0;
        return (1 + Math.max(height(root.leftChild), height(root.rightChild)));
    }

    private static int diameter(TreeNode root) {
        if (root == null)
            return 0;
        int height = 0;
        int leftDiameter = diameter(root.leftChild);
        int rightDiameter = diameter(root.rightChild);
        int rootDiameter = 1 + height(root.leftChild) + height(root.rightChild);

        return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
    }

    private static int countLeaves(TreeNode root) {
        if (root == null)
            return 0;
        if (root.leftChild == null && root.rightChild == null)
            return 1;
        else {
            int count = 0;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                TreeNode temp = q.poll();
                if (temp.rightChild == null && temp.leftChild == null) {
                    count++;
                } else {
                    if (temp.leftChild != null)
                        q.add(temp.leftChild);
                    if (temp.rightChild != null) {
                        q.add(temp.rightChild);
                    }
                }
            }
            return count;

            //Using recursion
            //return countLeaves(root.rightChild)+ countLeaves(root.leftChild);
        }
    }

    private static int sumOfElements(TreeNode root) {
        if (root == null)
            return 0;
        if (root.leftChild == null && root.rightChild == null)
            return root.key;
        else {
            int sum = 0;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                TreeNode temp = q.poll();
                sum += temp.key;

                if (temp.leftChild != null)
                    q.add(temp.leftChild);
                if (temp.rightChild != null) {
                    q.add(temp.rightChild);
                }
            }
            return sum;
        }
    }

    private static void BFS(TreeNode root, int val) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp.key == val) {
                System.out.print("Value Exists in the tree");
                return;
            }
            if (temp.leftChild != null)
                q.add(temp.leftChild);
            if (temp.rightChild != null) {
                q.add(temp.rightChild);
            }
        }
        System.out.print("Value not in tree");
    }


    private static void reverseBFS(TreeNode root, int val) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp.key == val) {
                System.out.print("Value Exists in the tree");
                return;
            }
            if (temp.rightChild != null) {
                q.add(temp.rightChild);
            }
            if (temp.leftChild != null)
                q.add(temp.leftChild);
        }
        System.out.print("Value not in tree");
    }

    private static void DFS(TreeNode root, int val) {
        Stack<TreeNode> q = new Stack<>();
        q.push(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.pop();
            if (temp.key == val) {
                System.out.print("Value Exists in the tree");
                return;
            }
            if (temp.leftChild != null)
                q.push(temp.leftChild);
            if (temp.rightChild != null) {
                q.push(temp.rightChild);
            }
        }
        System.out.print("Value not in tree");
    }

    private static int maxSumLevel(TreeNode root) {
        if (root == null)
            return 0;
        if (root.leftChild == null && root.rightChild == null)
            return 1;
        else {
            int sum = 0, maxSum = 0, level = 0, maxLevel = 0;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                TreeNode temp = q.poll();
                if (temp == null) {
                    if (sum > maxSum) {
                        maxSum = sum;
                        maxLevel = level;
                        sum = 0;
                        level++;
                    }
                    if (!q.isEmpty())
                        q.add(null);
                } else {
                    sum += temp.key;


                    if (temp.leftChild != null)
                        q.add(temp.leftChild);
                    if (temp.rightChild != null) {
                        q.add(temp.rightChild);
                    }
                }
            }
            return maxLevel;
        }
    }

    private static TreeNode findLCA(TreeNode root, int a, int b) {

        TreeNode left = null, right = null;

        if (root == null)
            return null;
        int rootValue = root.key;
        if (rootValue == a || rootValue == b) {
            return root;
        }
        // Look for keys in left and right subtrees
        left = findLCA(root.leftChild, a, b);
        right = findLCA(root.rightChild, a, b);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left != null && right != null) {
            return root;
        } else
            // Otherwise check if left subtree or right subtree is LCA
            return left == null ? right : left;
    }

    //checks if there is a path from the root down to a leaf with given sum

    private static boolean findPathSum(TreeNode root, int sum) {
        boolean found = false;

        if (root == null)
            return false;
        int remainingSum = sum - root.key;

        if (remainingSum == 0 && root.leftChild == null && root.rightChild == null) {
            return true;
        } else if (findPathSum(root.leftChild, remainingSum))
            found = true;
        if (!found)
            return findPathSum(root.rightChild, remainingSum);

        return found;
    }

    //Function that outputs mirror of given binary tree
    void mirrorTree(TreeNode root) {
        if (root == null)
            return;
        mirrorTree(root.leftChild);
        mirrorTree(root.rightChild);
        TreeNode temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }
}

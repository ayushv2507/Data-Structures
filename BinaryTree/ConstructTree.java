package BinaryTree;

//Program to construct tree from given pre order and inorder traversals
public class ConstructTree {
    static int x = 0;

    public static void main(String args[]) {
        int in[] = new int[]{4, 8, 2, 5, 1, 6, 3, 7};
        int pre[] = new int[]{1, 2, 4, 8, 5, 3, 6, 7};
        int len = in.length;


        TreeNode root = buildTree(in, pre, 0, len - 1);

        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        printInorder(root);
    }

    private static TreeNode buildTree(int[] in, int[] pre, int i, int i1) {


        TreeNode root = new TreeNode(pre[x++]);
        if (i == i1) {
            return root;
        }
        int index = search(root.key, in);
        root.leftChild = buildTree(in, pre, i, index - 1);
        root.rightChild = buildTree(in, pre, index + 1, i1);

        return root;
    }

    private static int search(int c, int[] in) {
        for (int i = 0; i < in.length - 1; i++) {
            if (in[i] == c)
                return i;
        }
        return 0;
    }

    /* This funtcion is here just to test buildTree() */
    static void printInorder(TreeNode node) {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.leftChild);

        /* then print the data of node */
        System.out.print(node.key + " ");

        /* now recur on right child */
        printInorder(node.rightChild);
    }
}

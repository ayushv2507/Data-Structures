package LinkedList;

public class Node {
    int val;
    Node next;

    Node(int x) {
        val = x;
        next = null;
    }

    // prints content of double linked list
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}

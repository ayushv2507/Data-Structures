package LinkedList;

public class MergeTwoSortedLists {
    private static Node head1, head2;

    public static void main(String args[]) {
        // creating first linked list
        head1 = new Node(3);
        head1.next = new Node(6);
        head1.next.next = new Node(15);
        head1.next.next.next = new Node(15);
        head1.next.next.next.next = new Node(30);
        // creating second linked list
        head2 = new Node(10);
        head2.next = new Node(15);
        head2.next.next = new Node(30);
        head2.next.next.next = new Node(40);
        head2.next.next.next.next = new Node(50);

        Node result = merge(head1, head2);
        Node.printList(result);
    }

    private static Node merge(Node head1, Node head2) {
        Node result;
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        if (head1.val < head2.val) {
            result = head1;
            result.next = merge(head1.next, head2);
        } else {
            result = head2;
            result.next = merge(head1, head2.next);
        }

        return result;
    }
}

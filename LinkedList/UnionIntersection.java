package LinkedList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// Program to find Union and Intersection of two Linked lists
public class UnionIntersection {

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

        findUnionIntersection(head1, head2);
    }

    private static void findUnionIntersection(Node head1, Node head2) {
        List<Node> union = new ArrayList();
        List<Node> intersection = new ArrayList();
        HashSet<Integer> set = new HashSet<>();

        //traverse first list and add everything to union list
        while (head1 != null) {
            set.add(head1.val);
            union.add(head1);

            head1 = head1.next;
        }

        //traverse second list and if node is not in set add to union list otherwise add to intersection list
        while (head2 != null) {
            if (set.contains(head2.val)) {
                intersection.add(head2);
            } else {
                union.add(head2);
            }
            head2 = head2.next;
        }

        System.out.println("Union");
        for (Node n : union) {
            System.out.print(n.val + " ");
        }
        System.out.println("");
        System.out.println("Intersection");
        for (Node n : intersection) {
            System.out.print(n.val + " ");
        }
    }
}

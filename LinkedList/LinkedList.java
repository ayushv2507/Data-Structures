package LinkedList;

import java.util.HashSet;
import java.util.Scanner;

public class LinkedList {

    private static Node head, head1, head2;

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        /*
        head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(25);
*/
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

       /* // Creating a loop for testing
        head.next.next.next.next.next = head.next.next;*/
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        findNthFromLast(n);*/
        // findLoop();
        // reverse();
        // findMiddle();
        // findMergingPoint(head1,head2);
        removeDuplicates(head1);
    }

    public void push(int new_data) {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    private static void findNthFromLast(int n) {
        Node current = head;
        Node result = head;
        int count = 0;

        while (count < n) {
            current = current.next;
            count++;
        }
        while (current != null) {
            result = result.next;
            current = current.next;
        }
        System.out.print(result.val);
    }

    private static boolean findLoop() {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                System.out.println("Loop exists");
                //  System.out.print(findStartOfLoop(fast));
                // System.out.print(findLengthOfLoop(fast));
                return true;
            }

        }
        return false;
        // System.out.print("No Loop");
    }

    private static int findStartOfLoop(Node fast) {
        Node slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.val;
    }

    private static int findLengthOfLoop(Node fast) {
        Node slow = head;
        int length = 0;
        while (slow != fast) {
            slow = slow.next;
            length++;
        }
        return length;
    }

    private static void reverse() {
        System.out.println("Given Linked list");
        Node.printList(head);
        System.out.println("");

        Node nextnode, prev = null, current = head;
        while (current != null) {
            nextnode = current.next;
            current.next = prev;
            prev = current;
            current = nextnode;
        }
        head = prev;
        System.out.println("Reversed linked list ");
        Node.printList(head);
    }


    private static int findMiddle() {

        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.print(slow.val);
        return slow.val;
    }


    private static void findMergingPoint(Node head1, Node head2) {
        int l1 = 0, l2 = 0, diff = 0;
        boolean bigger = false;
        l1 = getCount(head1);
        l2 = getCount(head2);

        if (l1 > l2) {
            bigger = true;
            diff = l1 - l2;
        } else diff = l2 - l1;

        if (bigger) {
            for (int i = 0; i < diff; i++) {
                if (head1 == null) {
                    return;
                }
                head1 = head1.next;

            }
            while (head1 != null && head2 != null) {
                if (head1.val == head2.val) {
                    System.out.print(head1.val);
                    return;
                }
                head1 = head1.next;
                head2 = head2.next;

            }
        }
    }

    private static int getCount(Node head) {
        Node current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    private static void removeDuplicates(Node head1) {

        //Unsorted list

        Node prev = null;
        HashSet<Integer> set = new HashSet<>();
        while (head1 != null) {

            if (!set.contains(head1.val)) {
                set.add(head1.val);
                prev = head1;
            } else prev.next = head1.next;

            head1 = head1.next;
        }
        for (Integer aSet : set) {
            System.out.print(aSet);
            System.out.print(" ");
        }

        //Works best for a sorted list
       /* Node p = head1;
        while(p!=null && p.next!=null){
            if(p.val == p.next.val)
                p.next = p.next.next;
            else p = p.next;
        }
        Node.printList(head1);*/
    }

}

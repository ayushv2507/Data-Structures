package LinkedList;

import java.util.Scanner;

//Rotate a linked list to the right by k steps
//Remember to start count from 1 in Linked Lists!!!!

//50->20->15->4->10->25
//k=4
//traverse till k store k.next in temp
//then traverse till null and make current.next = head
//make head = temp.next
//make temp.next =null

public class Rotate {
    private static Node head;

    public static void main(String[] args) {
        head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(25);
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        System.out.println("Original list");
        Node.printList(head);
        rotate(k);


    }

    private static void rotate(int k) {
        Node current = head;
        int count = 1;
        while (count < k) {
            count++;
            current = current.next;
        }
        Node temp = current;

        while (current.next != null) {
            current = current.next;
        }
        current.next = head;
        head = temp.next;
        temp.next = null;

        System.out.println("Rotated list");
        Node.printList(head);
    }


}

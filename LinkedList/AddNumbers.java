package LinkedList;

//Program to add two numbers represented as Linked lists

public class AddNumbers {

    private static Node head1, head2;

    public static void main(String args[]) {
        // creating first linked list
        head1 = new Node(3);
        head1.next = new Node(6);
        head1.next.next = new Node(1);

        // creating second linked list
        head2 = new Node(1);
        head2.next = new Node(5);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);


        Node result = add(head1, head2);
        Node.printList(result);
    }

    private static Node add(Node head1, Node head2) {
        int sum = 0, carry = 0;
        Node temp = null, prev = null;

        Node result = null;
        while (head1 != null || head2 != null) {

            // Calculate value of next digit in resultant list.
            // The next digit is sum of following things
            // (i)  Carry
            // (ii) Next digit of first list (if there is a next digit)
            // (ii) Next digit of second list (if there is a next digit)
            sum = carry + ((head1 != null ? head1.val : 0) + (head2 != null ? head2.val : 0));

            // update carry for next calulation
            carry = sum >= 10 ? 1 : 0;

            // update sum if it is greater than 10
            sum = sum % 10;

            // Create a new node with sum as data
            temp = new Node(sum);

            // if this is the first node then set it as head of
            // the resultant list
            if (result == null) {
                result = temp;
            } else { // If this is not the first node then connect it to the rest.
                prev.next = temp;
            }

            // Set prev for next insertion
            prev = temp;

            if (head1 != null)
                head1 = head1.next;
            if (head2 != null)
                head2 = head2.next;
        }
        if (carry > 0)
            temp.next = new Node(carry);

        return result;
    }
}

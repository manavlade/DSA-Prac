import java.util.HashSet;

public class LinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    class Linedlist {
        Node head;

        Linedlist() {
            this.head = null;
        }

        void append(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        void display() {
            Node current = head;
            while (current != null) {
                System.out.println(current.data + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }

        // Code to find length of a given singly linked list.
        int findlength(Linedlist list) {
            int length = 0;
            Node current = list.head;
            while (current != null) {
                length++;
                current = current.next;
            }
            return length;

        }
    }

    public static void removeLoop(Node head) {
        /*
        imp question
         * Question
         * Given a linked list of N nodes such that it may contain a loop.
         * 
         * A loop here means that the last node of the link list is connected to the
         * node at position X(1-based index). If the link list does not have any loop,
         * X=0.
         * Remove the loop from the linked list, if it is present, i.e. unlink the last
         * node which is forming the loop.
         */
        // remove the loop without losing any nodes
        HashSet<Node> hs = new HashSet<>();
        if(head.next == null){
            return;
        }
        Node currentNode = head;
        Node prev = null;

        while (currentNode != null) {
            if(hs.contains(currentNode)){
                prev.next = null;
                break;
            }
            else {
                hs.add(currentNode);
            }
            prev = currentNode;
            currentNode = currentNode.next;
        }
    }

    int intersectPoint(Node head1, Node head2) {
        /*
        imp question
         * Question
         * Internship Alert!
         * Become an SDE Intern by topping this monthly leaderboard!
         * banner
         * Given two singly linked lists of size N and M, write a program to get the
         * point where two linked lists intersect each other.
         * Example
         * LinkList1 = 3->6->9->common
         * LinkList2 = 10->common
         * common = 15->30->NULL
         * Output: 15
         */
        if(head1 == null || head2 == null){
            return -1;
        }

        Node l1 = head1;
        Node l2 = head2;

        while (l1 != l2) {
            l1 = l1 == null ? head2 : l1.next;
            l2 = l2 == null ? head1 : l2.next;
        }

        if(l1 == null || l2 == null) return -1;

        return l1.data;
    }

}

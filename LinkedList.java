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
         * imp question
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
        if (head.next == null) {
            return;
        }
        Node currentNode = head;
        Node prev = null;

        while (currentNode != null) {
            if (hs.contains(currentNode)) {
                prev.next = null;
                break;
            } else {
                hs.add(currentNode);
            }
            prev = currentNode;
            currentNode = currentNode.next;
        }
    }

    int intersectPoint(Node head1, Node head2) {
        /*
         * imp question
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
        if (head1 == null || head2 == null) {
            return -1;
        }

        Node l1 = head1;
        Node l2 = head2;

        while (l1 != l2) {
            l1 = l1 == null ? head2 : l1.next;
            l2 = l2 == null ? head1 : l2.next;
        }

        if (l1 == null || l2 == null)
            return -1;

        return l1.data;
    }

    // class Node {
    //     public int data;
    //     public Node next;

    //     Node() {
    //         this.data = 0;
    //         this.next = null;
    //     }

    //     Node(int data) {
    //         this.data = data;
    //         this.next = null;
    //     }

    //     Node(int data, Node next) {
    //         this.data = data;
    //         this.next = next;
    //     }
    // }

    public static Node findMiddle(Node head) {
        /*
         * EXTREMELY IMPORTANT QUESTION ASKED IN MORE THAN 75 COMPANIES
         * DIFFICULTY LEVEL EASY
         * Question
         * Given a singly linked list of 'N' nodes. The objective is to determine the
         * middle node of a singly linked list. However, if the list has an even number
         * of nodes, we return the second middle node.
         * Example
         * 5
         * 1 2 3 4 5
         * Sample Output 1 :
         * 3 4 5
         * DRY RUN
         * Dry Run with Example Linked List: 1 -> 2 -> 3 -> 4 -> 5
         * 
         * Initialization:
         * 
         * head points to the first node (1).
         * slow and fast both point to the first node (1).
         * First Iteration:
         * 
         * Condition: fast != null and fast.next != null (True)
         * fast moves two steps: fast = fast.next.next (points to 3)
         * slow moves one step: slow = slow.next (points to 2)
         * Current positions:
         * 
         * slow -> 2
         * fast -> 3
         * Second Iteration:
         * 
         * Condition: fast != null and fast.next != null (True)
         * fast moves two steps: fast = fast.next.next (points to 5)
         * slow moves one step: slow = slow.next (points to 3)
         * Current positions:
         * 
         * slow -> 3
         * fast -> 5
         * Third Iteration:
         * 
         * Condition: fast != null and fast.next != null (False, because fast.next is
         * null)
         * Exit the loop
         * Return the middle node:
         * 
         * The slow pointer now points to the middle node (3).
         * Output:
         * 
         * The middle node is the node with value 3.
         */
        if (head == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

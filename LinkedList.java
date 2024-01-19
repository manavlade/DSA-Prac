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

}

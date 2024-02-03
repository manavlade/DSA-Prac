import java.util.Stack;
import java.util.*;

/*
 Question
Given a singly linked list of integers. Your task is to return the head of the reversed linked list.
For example:
The given linked list is 1 -> 2 -> 3 -> 4-> NULL. Then the reverse linked list is
4 -> 3 -> 2 -> 1 -> NULL and the head of the reversed linked list will be 4.
Follow Up :
Can you solve this problem in O(N) time and O(1) space complexity?
 */
public class ReversingLinked {
     public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) 
    {
        Stack<LinkedListNode<Integer>> stack = new Stack<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            head = stack.pop();

            LinkedListNode<Integer> current = head;

            while (!stack.isEmpty()) {
                current.next = stack.pop();
                current = current.next;
            }
            current.next = null;
        }
        return head;
    }

    // With less space complexity
    // public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) {
    //     LinkedListNode<Integer> prev = null;
    //     LinkedListNode<Integer> current = head;
    //     LinkedListNode<Integer> next = null;

    //     while (current != null) {
    //         next = current.next; // Save the next node
    //         current.next = prev; // Reverse the link
    //         prev = current; // Move one step forward
    //         current = next; // Move one step forward
    //     }

    //     // 'prev' is the new head of the reversed list
    //     return prev;
    // }
}

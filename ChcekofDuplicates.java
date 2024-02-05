import java.util.HashSet;
import java.util.Set;

/*
 Question
 Given an unsorted linked list of N nodes. The task is to remove duplicate elements
  from this unsorted Linked List. When a value appears in multiple nodes, the node 
  which appeared first should be kept, all others duplicates are to be removed.
 */
public class ChcekofDuplicates {
      public Node removeDuplicates(Node head) 
    {
         if(head == null || head.next == null){
            return head;
         }
         Set<Integer> ll = new HashSet<>();
         Node current = head;
         Node prev = null;

         while (current != null) {
            if(ll.contains(current.data)){
                prev.next = current.next;
            }
            else {
                ll.add(current.data);
                prev = current;
            }
            current = current.next;
         }
         return head;
    }
}

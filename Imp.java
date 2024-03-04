/*
   * Question
   * Given a binary tree
   * 
   * struct Node {
   * int val;
   * Node *left;
   * Node *right;
   * Node *next;
   * }
   * Populate each next pointer to point to its next right node. If there is no
   * next right node, the next pointer should be set to NULL.
   * 
   * Initially, all next pointers are set to NULL.
   * Input: root = [1,2,3,4,5,null,7]
   * Output: [1,#,2,3,#,4,5,7,#]
   * Explanation: Given the above binary tree (Figure A), your function should
   * populate each
   * next pointer to point to its next right node, just like in Figure B. The
   * serialized
   * output is in level order as connected by the next pointers, with '#'
   * signifying the end
   * of each level. 
   */

import java.util.Arrays;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Imp {
    private boolean hasChildren(Node node) {
        return node.left != null || node.right != null;
    }

    private Node getNextParent(Node root) {
        Node next = root.next;
        while (next != null && hasChildren(next))
            next = next.next;
        return next;
    }

    private void connectCousins(Node root) {
        if (!hasChildren(root))
            return;
        Node nextParent = getNextParent(root);
        if (nextParent == null)
            return;

        Node rootChild = root.right == null ? root.left : root.right;
        Node nextChild = nextParent.left == null ? nextParent.right : nextParent.left;

        if (rootChild.next != null)
            rootChild.next = nextChild;
        connectCousins(nextParent);
    }

    private void traverse(Node root) {
        if (root == null)
            return;

        if (root.left != null && root.left.next != null || root.right != null && root.right.next != null)
            connectCousins(root);
        traverse(root.left);
        traverse(root.right);

    }

    private void connectChildren(Node root) {
        if (root == null)
            return;
        if (root.left != null && root.right != null)
            root.left.next = root.right;
        connectChildren(root.left);
        connectChildren(root.right);
    }

    public Node connect(Node root) {
        connectChildren(root);
        traverse(root);
        return root;
    }

/*
 * Question
 * For a given integer array/list 'ARR' of size 'N' containing all distinct
 * values, find the total number of 'Inversions' that may exist.
 * An inversion is defined for a pair of integers in the array/list when the
 * following two conditions are met.
 * A pair ('ARR[i]', 'ARR[j]') is said to be an inversion when:
 * 1. 'ARR[i] > 'ARR[j]'
 * 2. 'i' < 'j'
 * Where 'i' and 'j' denote the indices ranging from [0, 'N').
 */
    public static long getInversions(long arr[], int n) 
    {
        long count = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = arr.length-1; j > i; j--) {
                if(arr[i] > arr[j]){
                    count++;
                }
            }
        } 
        return count;  
    }

    public static int kthSmallest(int[] arr, int l, int r, int k) 
    {
        Arrays.sort(arr);
        for (int i = l; i <= r; i++) {
            if(i == k - 1){
                return arr[i];
            }
            
        }
        return -1;
    }
    
}


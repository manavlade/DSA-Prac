/*
You are given the root of a binary tree containing digits from 0 to 9 only.
Each root-to-leaf path in the tree represents a number.
For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that 
the answer will fit in a 32-bit integer. A leaf node is a node with no children.
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class SumRoot {
    int sum;

    public int sumNumbers(TreeNode root) {
        traverse(root, 0);
        return sum;
    }

    public void traverse(TreeNode root, int prev) {
        int cur = prev * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += cur;
            return;
        }
        if (root.left != null) {
            traverse(root.left, cur);
        }
        if (root.right != null) {
            traverse(root.right, cur);
        }
    }

    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }

        return 1 + (num - 1) % 9;
    }

    public static boolean isValidParenthesis(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((ch == '}' && top != '{') || (ch == ']' && top != '[') || (ch == ')' && top != '(')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /*
     * Question
     * You are given two Singly Linked Lists of integers, which may have an
     * intersection point.
     * Your task is to return the first intersection node. If there is no
     * intersection, return NULL.
     * Example:-
     * The Linked Lists, where a1, a2, c1, c2, c3 is the first linked list and b1,
     * b2, b3, c1, c2, c3 is the second linked list, merging at node c1.
     */
    public static int findIntersection(Node firstHead, Node secondHead) {
        // Write your code here
        Node tempA = firstHead;
        Node tempB = secondHead;
        while (tempA != tempB) {
            tempA = tempA == null ? secondHead : tempA.next;
            tempB = tempB == null ? firstHead : tempB.next;
        }
        return tempA.data;
    }

    class MyStack {
        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.add(x);
        }

        public int pop() {
            int size = queue.size();
            for (int i = 0; i < size - 1; i++) {
                queue.add(queue.remove());
            }
            return queue.remove();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            if (queue.isEmpty()) {
                return true;
            } else
                return false;
        }
    }

}

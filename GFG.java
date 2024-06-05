import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;

public class GFG {
    /*
     * Question
     * Given an array arr[] of size N and an integer K. Find the maximum for each
     * and every contiguous subarray of size K.
     * Example 1:
     * Input:
     * N = 9, K = 3
     * arr[] = 1 2 3 1 4 5 2 3 6
     * Output:
     * 3 3 4 5 5 5 6
     * Explanation:
     * 1st contiguous subarray = {1 2 3} Max = 3
     * 2nd contiguous subarray = {2 3 1} Max = 3
     * 3rd contiguous subarray = {3 1 4} Max = 4
     * 4th contiguous subarray = {1 4 5} Max = 5
     * 5th contiguous subarray = {4 5 2} Max = 5
     * 6th contiguous subarray = {5 2 3} Max = 5
     * 7th contiguous subarray = {2 3 6} Max = 6
     * 
     */
    // BAAKI HAI YE QUESTION REVISE QUEUE CONCEPT
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        // Your code here
        ArrayList<Integer> list = new ArrayList<>();

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // remove any out of bounds
            if (!dq.isEmpty() && dq.peek() == i - k) {
                dq.poll();
            }

            // remove samller element befor adding

            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }

            // add i
            dq.offer(i);

            if (i >= k - 1) {
                list.add(arr[dq.peek()]);
            }
        }

        return list;
    }

    public int longestPalindrome(String s) {
        /*
         * Question
         * Given a string s which consists of lowercase or uppercase letters, return the
         * length of the longest
         * palindrome
         * that can be built with those letters.
         * 
         * Letters are case sensitive, for example, "Aa" is not considered a palindrome.
         */
        HashSet<Character> set = new HashSet<>();

        int length = 0;

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                length += 2;
            } else {
                set.add(c);
            }
        }

        if (!set.isEmpty()) {
            length += 1;
        }

        return length;
    }

   
}

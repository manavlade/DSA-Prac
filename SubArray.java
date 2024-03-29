/*
 Question 
You are given an array 'arr' of length 'n', consisting of integers.
A subarray is a contiguous segment of an array. In other words, a subarray can be 
formed by removing 0 or more integers from the beginning and 0 or more integers from 
the end of an array. Find the sum of the subarray (including empty subarray) having 
maximum sum among all subarrays. The sum of an empty subarray is 0.
Example
Sample Input 1 :
9
1 2 7 -4 3 2 -10 9 1
Sample Output 1 :
11
Explanation for Sample 1 :
The subarray yielding the maximum sum is [1, 2, 7, -4, 3, 2].
 */

import java.util.HashMap;

public class SubArray {
    public static long maxSubarraySum(int[] arr, int n) {
        long maSum = Long.MAX_VALUE;
        long currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += arr[i];
            if (currentSum < 0) {
                currentSum = 0;
            }
            if (currentSum > maSum) {
                maSum = currentSum;
            }
        }
        return maSum;
    }

    /*
     * Given an array A of N elements. Find the majority element in the array. A
     * majority element in an array A of size N is an element that appears strictly
     * more than N/2 times in the array.
     * Example 1:
     * Input:
     * N = 3
     * A[] = {1,2,3}
     * Output:
     * -1
     * Explanation:
     * Since, each element in
     * {1,2,3} appears only once so there
     * is no majority element.
     */
    static int majorityElement(int a[], int size) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        for (int i : map.keySet()) {
            if (map.get(i) > size / 2) {
                return i;
            }
        }
        return -1;
    }
}

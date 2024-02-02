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
public class SubArray {
    public static long maxSubarraySum(int[] arr, int n) {
        long maSum =  Long.MAX_VALUE;
        long currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += arr[i];
            if(currentSum < 0){
                currentSum = 0;
            }
            if(currentSum > maSum){
                maSum =  currentSum;
            }
        }
        return maSum;
    }
}

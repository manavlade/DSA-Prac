import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class CodingNinjas {

    /*
     * Question
     * You have been given an integer array/list (ARR) of size N. You have to return
     * an array/list PRODUCT such that PRODUCT[i] is equal to the product of all the
     * elements of ARR except ARR[i]
     * Note :
     * Each product can cross the integer limits, so we should take modulo of the
     * operation.
     * Take MOD = 10^9 + 7 to always stay in the limits.
     * Follow up :
     * Can you try solving the problem in O(1) space?
     */
    public static int[] getProductArrayExceptSelf(int[] arr) {
        int n = arr.length;
        int MOD = 1000000007;

        int output[] = new int[n];
        if (n < 1)
            return output;

        int product = 1;
        for (int i = 0; i < n; i++) {
            product = (int) (((long) product * arr[i]) % MOD);
            output[i] = product;
        }

        int products = 1;
        for (int i = n - 1; i > 0; i--) {
            output[i] = (int) (((long) output[i - 1] * products) % MOD);
            products = (int) (((long) products * arr[i]) % MOD);
        }
        output[0] = products;

        return output;
    }

    public static int maximumMeetings(int[] start, int[] end) {
        /*
         * Question
         * You are given the schedule of 'N' meetings with their start time 'Start[i]'
         * and end time 'End[i]'.
         * You have only 1 meeting room. So, you need to return the maximum number of
         * meetings you can organize.
         * Note:
         * The start time of one chosen meeting can’t be equal to the end time of the
         * other chosen meeting.
         * For example:
         * 'N' = 3, Start = [1, 3, 6], End = [4, 8, 7].
         * You can organize a maximum of 2 meetings. Meeting number 1 from 1 to 4,
         * Meeting number 3 from 6 to 7.
         */
        int n = start.length;
        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[1]));

        int numberOfMeetings = 1;
        int currentEnd = meetings[0][1];

        for (int i = 1; i < n; i++) {
            if (meetings[i][0] > currentEnd) {
                numberOfMeetings++;
                currentEnd = meetings[i][1];
            }
        }
        return numberOfMeetings;
    }

    public static int firstMissing(int[] arr, int n) {
        /*
         * Question
         * You are given an array 'ARR' of integers of length N. Your task is to find
         * the first missing positive integer in linear time and constant space. In
         * other words, find the lowest positive integer that does not exist in the
         * array. The array can have negative numbers as well.
         * 
         * For example, the input [3, 4, -1, 1] should give output 2 because it is the
         * smallest positive number that is missing in the input array.
         */
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            while (arr[i] > 0 && arr[i] <= size && arr[arr[i] - 1] != arr[i] ) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }
        for (int i = 0; i < size; i++) {
            if(arr[i] != i +1){
                return i + 1;
            }
        }
        return size + 1;
    }
    
      public static boolean subsetSumToK(int n, int k, int arr[]){
        /*
         * Question
         * You are given an array/list ‘ARR’ of ‘N’ positive integers and an integer
         * ‘K’. Your task is to check if there exists a subset in ‘ARR’ with a sum equal
         * to ‘K’.
         * Note: Return true if there exists a subset with sum equal to ‘K’. Otherwise,
         * return false.
         * For Example :
         * If ‘ARR’ is {1,2,3,4} and ‘K’ = 4, then there exists 2 subsets with sum = 4.
         * These are {1,3} and {4}. Hence, return true.
         */
        boolean [][] sum = new boolean[n+1][k+1];

        for (int i = 0; i <= k; i++) {
            sum[0][i] = false;
        }

        for (int i = 0; i <= n; i++) {
            sum[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for(int j = 1; j <= k; j++){
                if(arr[i-1] <= j){
                    sum[i][j] = sum[i-1][j-arr[i-1]] || sum[i-1][j];
                }
                else {
                    sum[i][j] = sum[i-1][j];
                }
            }
        }
        return sum[n][k];
    }

    //imp Question 
    public static final int MOD = 1000000007;
    public static long countDistinctWayToClimbStair(int nStairs) {
        /*
         * Question
         * You have been given a number of stairs. Initially, you are at the 0th stair,
         * and you need to reach the Nth stair.
         * Each time, you can climb either one step or two steps.
         * You are supposed to return the number of distinct ways you can climb from the
         * 0th step to the Nth step.
         * Example :
         * N=3
         * We can climb one step at a time i.e. {(0, 1) ,(1, 2),(2,3)} or we can climb
         * the first two-step and then one step i.e. {(0,2),(1, 3)} or we can climb
         * first one step and then two step i.e. {(0,1), (1,3)}.
         */
		if(nStairs == 0 || nStairs == 1 ){
            return 1;
        }
        int n = (int)nStairs;
        int [] dp =  new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        int count = countWays(n, dp);
        return count;

	}
    public static int countWays(long n, int [] dp){

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] % MOD + dp[i-2] %MOD;    
        }
        return dp[dp.length-1] % MOD;
    }

     public static List<int[]> pairSum(int[] arr, int s) {
        /*
         * Question
         * You are given an integer array 'ARR' of size 'N' and an integer 'S'. Your
         * task is to return the list of all pairs of elements such that each sum of
         * elements of each pair equals 'S'.
         * Note:
         * Each pair should be sorted i.e the first value should be less than or equals
         * to the second value.
         * Return the list of pairs sorted in non-decreasing order of their first value.
         * In case if two pairs have the same first value, the pair with a smaller
         * second value should come first.
         */
        List<int[]> pairs = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] + arr[j] == s){
                    pairs.add(new int[]{arr[i], arr[j]});
                }
            }
        }
        return pairs;
     }

     //Ye vala thoda baaki hai imp hai 
     static boolean isFeasible(int n, int m, int[] time, long mid) {
        /*
         * Question
         * Ayush is studying for ninjatest which will be held after 'N' days, And to
         * score good marks he has to study 'M' chapters and the ith chapter requires
         * TIME[i] seconds to study. The day in Ayush’s world has 100^100 seconds. There
         * are some rules that are followed by Ayush while studying.
         * 
         * 1. He reads the chapter in a sequential order, i.e. he studies i+1th chapter
         * only after he studies ith chapter.
         * 
         * 2. If he starts some chapter on a particular day he completes it that day
         * itself.
         * 
         * 3. He wants to distribute his workload over 'N' days, so he wants to minimize
         * the maximum amount of time he studies in a day.
         * 
         * Your task is to find out the minimal value of the maximum amount of time for
         * which Ayush studies in a day, in order to complete all the 'M' chapters in no
         * more than 'N' days.
         * 
         * For example
         * 
         * if Ayush want to study 6 chapters in 3 days and the time that each chapter
         * requires is as follows:
         * Chapter 1 = 30
         * Chapter 2 = 20
         * Chapter 3 = 10
         * Chapter 4 = 40
         * Chapter 5 = 5
         * Chapter 6 = 45
         * 
         * Then he will study the chapters in the following order
         */
         int days = 1;
         long sum = 0;

         for (int i = 0; i < m; i++) {
             if (sum + time[i] > mid) {
                 sum = time[i];
                 days++;
             } else {
                 sum += time[i];
             }
         }

         return days <= n;
     }

     static long maximum(int[] time) {
         long min = time[0];
         for (int i = 1; i < time.length; i++) {
             min = Math.max(time[i], min);
         }
         return min;
     }

     public static long ayushGivesNinjatest(int n, int m, int[] time) {
         // Write your code here.

         long min = (long) maximum(time);
         long max = 0L;
         for (int i = 0; i < m; i++) {
             max += time[i];
         }

         long res = Integer.MAX_VALUE;

         while (min <= max) {
             long mid = (min + max) / 2;
             if (isFeasible(n, m, time, mid)) {
                 max = mid - 1;
                 res = mid;
             } else {
                 min = mid + 1;
             }
         }

         return res;
     }

     public static void reverseStack(Stack<Integer> stack) {
        /*
         * Question
         * Reverse a given stack of 'N' integers using recursion. You are required to
         * make changes in the input parameter itself.
         * Note: You are not allowed to use any extra space other than the internal
         * stack space used due to recursion.
         * Example:
         * Input: [1,2,3,4,5]
         * Output: [5,4,3,2,1]
         */
        
         // Thoda logic tricky hai revise once
         if(!stack.isEmpty()){
            int top = stack.pop();
            reverseStack(stack);
            insertBottom(stack, top);
        }
     }
     public static void insertBottom(Stack<Integer> stack,int elemnt){
        if(stack.isEmpty()){
            stack.push(elemnt);
        }
        else {
            int top = stack.pop();
            insertBottom(stack, elemnt);
            stack.push(top);
        }
     }
     
    /*
     * Time Complexity: O(N)
     * Space complexity: O(1)
     * 
     * Where N is the length of the array.
     */

    public static int flipBits(int[] arr, int n) {
        /*
         * Question
         * You are given an array of integers ARR[] of size N consisting of zeros and
         * ones. You have to select a subset and flip bits of that subset. You have to
         * return the count of maximum one’s that you can obtain by flipping chosen
         * sub-array at most once.
         * 
         * A flip operation is one in which you turn 1 into 0 and 0 into 1.
         * 
         * For example:
         * If you are given an array {1, 1, 0, 0, 1} then you will have to return the
         * count of maximum one’s you can obtain by flipping anyone chosen sub-array at
         * most once, so here you will clearly choose sub-array from the index 2 to 3
         * and then flip it's bits. So, the final array comes out to be {1, 1, 1, 1, 1}
         * which contains five ones and so you will return 5.
         * 
         * FLIPKART AMDOCS PYQ
         */
        int totalOnes = 0;

        // Initialize overall maximum difference for any subArray
        int max = 0;

        // Initialize current difference
        int currMax = 0;

        for (int i = 0; i < n; i++) {

            if (arr[i] == 1) {
                totalOnes++;
            }

            // Value to be considered for finding maximum sum
            int val = 0;
            if (arr[i] == 1) {
                val = -1;
            } else {
                val = 1;
            }

            currMax = Math.max(val, currMax + val);
            max = Math.max(max, currMax);
        }
        max = Math.max(0, max);
        int result = totalOnes + max;
        return result;
    }

    private static class Pair{
        /*
         * Question
         * You are given a string of lowercase characters. Your task is to rearrange
         * (reorder) the string in such a way that no two adjacent characters are the
         * same.
         * 
         * You have to return the rearranged string. If there exists more than one
         * solution you can return any of them.If there is no such string you have to
         * return “NO SOLUTION”. If your returned value is correct the program will
         * print ‘CORRECT’ else ‘INCORRECT’.
         * 
         * For example :
         * 
         * If we are given a string "aabb", then the possible solutions are:
         * 
         * (i) abab
         * (ii) baba
         */
        char alphabet;
        int freq;

        Pair(char alphabet, int freq){
            this.alphabet = alphabet;
            this.freq = freq;
        }
    }
    public static String rearrangeString(String str) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.freq - a.freq);

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (Character key : map.keySet()) {
            pq.add(new Pair(key, map.get(key)));
        }

        char [] res = new char[str.length()];

        int i = 0;

        while (pq.size() > 0) {
            Pair pair = pq.poll();
            if(pair.freq > (str.length() + 1) / 2){
                return "NO SOLUTION";
            }

            while (pair.freq > 0) {
                if( i >= res.length){
                    i = 1;
                }
                res[i] = pair.alphabet;
                i += 2;
                pair.freq--;
            }
        }
        String result = new String(res);
        return result;
    }

    public static List<String> findPermutations(String s) {
        /*
         * Question
         * You are given an input string 'S'. Your task is to find and return all
         * possible permutations of the input string.
         * Note:
         * 1. The input string may contain the same characters, so there will also be
         * the same permutations.
         * 2. The order of permutation does not matter.
         * Sample Input 1:
         * cba
         * Sample Output 1:
         * abc
         * acb
         * bac
         * bca
         * cab
         * cba
         * Explanation for Sample Output 1:
         * All the possible permutations for string "cba" will be "abc", "acb", "bac",
         * "bca", "cab" and "cba".
         */
         List<String> solution = new ArrayList<>();
         solver(solution, s, 0, "", new boolean[s.length()]);
         return solution;

    }
    private static void solver(List<String> solution,String s,int index, String temp, boolean visited []){
        if(index == s.length()){
            solution.add(temp);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            solver(solution, s, index+ 1, temp + String.valueOf(s.charAt(i)), visited);
            visited[i] = false;
        }
    }
    static int largestElement(int[] arr, int n) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}


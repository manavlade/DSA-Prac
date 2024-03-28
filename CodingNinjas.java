import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
}


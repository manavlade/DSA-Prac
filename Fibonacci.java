public class Fibonacci {
    /*
     * Question
     * You are given an integer ‘N’, your task is to find and return the N’th
     * Fibonacci number using matrix exponentiation.
     * Since the answer can be very large, return the answer modulo 10^9 +7.
     * Fibonacci number is calculated using the following formula:
     * F(n) = F(n-1) + F(n-2),
     * Where, F(1) = F(2) = 1.
     * For Example:
     * For ‘N’ = 5, the output will be 5.
     * link
     * https://www.codingninjas.com/studio/problems/nth-fibonacci-number_1115780?
     * interviewProblemRedirection=true&leftPanelTabValue=PROBLEM  
     * NEED TO REVISE ONCE 
     */
    private static final int MOD = 1000000007;

    public static int fibonacciNumber(int n) {
        if (n <= 0) {
            return 0;
        }

        int[][] base = { { 1, 1 }, { 1, 0 } };
        int[][] result = { { 1, 0 }, { 0, 1 } }; // Identity matrix

        while (n > 0) {
            if (n % 2 == 1) {
                result = multiply(result, base);
            }
            base = multiply(base, base);
            n /= 2;
        }

        return result[0][1];
    }

    private static int[][] multiply(int[][] a, int[][] b) {
        int rowA = a.length;
        int colA = a[0].length;
        int colB = b[0].length;

        int[][] result = new int[rowA][colB];

        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                for (int k = 0; k < colA; k++) {
                    result[i][j] = (int) ((result[i][j] + (long) a[i][k] * b[k][j]) % MOD);
                }
            }
        }

        return result;
    }
}

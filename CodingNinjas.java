import java.util.ArrayList;

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
        for (int i = n-1; i > 0; i--) {
            output[i] = (int) (((long) output[i-1] *  products) % MOD);
            products = (int) (((long) products *  arr[i]) % MOD);
        }
        output[0] = products;

        return output;
    }

}

import java.util.Arrays;

public class Kadanesalgorithm {
    public static int maxSumRectangle(int[][] arr, int n, int m) {
    int maxSum = Integer.MIN_VALUE;

    // Iterate through each column as the left boundary of the rectangle
    for (int left = 0; left < m; left++) {
        // Create a temporary array to store the sum of each row's elements
        int[] temp = new int[n];
        Arrays.fill(temp, 0);

        // Iterate through each column as the right boundary of the rectangle
        for (int right = left; right < m; right++) {
            // Update the temporary array with the sum of each row's elements within the boundaries
            for (int i = 0; i < n; i++) {
                temp[i] += arr[i][right];
            }

            // Use Kadane's algorithm to find the maximum sum subarray in the temporary array
            int currentSum = 0, maxSumRow = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                currentSum += temp[i];
                maxSumRow = Math.max(maxSumRow, currentSum);
                
                // Reset currentSum to 0 if it becomes negative
                if (currentSum < 0) {
                    currentSum = 0;
                }
            }

            // Update the overall maximum sum
            maxSum = Math.max(maxSum, maxSumRow);
        }
    }

    return maxSum;
}

}
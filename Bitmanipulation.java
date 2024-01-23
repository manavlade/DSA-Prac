public class Bitmanipulation {
    public static int countBits(int n){
        int count = 0;
        while (n >  0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
    // Given an array of integers where every element appears twice except for one,
    // find that single element.
    public static int single(int [] nums){
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }
        return result;
    }

    // Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND
    // of all numbers in this range, inclusive.

    public static int range(int m, int n){
        int shift = 0;
        while (m < n) {
            m >>= 1;
            n >>= 1;
            shift++;
        }
        return m << shift;
    }
    public static void main(String[] args) {
       int n = 1000;
       System.out.println("The number of bits are " + n + ":"+ countBits(n));
    }

    // With working 
    // public static int countSetBits(int num) {
    //     int count = 0;
    //     while (num > 0) {
    //         System.out.println("Current num: " + num);
    //         System.out.println("Binary representation of num: " + Integer.toBinaryString(num));
    //         System.out.println("Adding " + (num & 1) + " to count");

    //         count += num & 1;
    //         num >>= 1;

    //         System.out.println("After right shift, num is now: " + num);
    //         System.out.println("Count is now: " + count);
    //         System.out.println("-----------");
    //     }
    //     return count;
    // }

    // public static void main(String[] args) {
    //     int num = 5;
    //     System.out.println("Number of set bits in " + num + ": " + countSetBits(num));
    // }
}

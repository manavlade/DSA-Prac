import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Leetcode {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /*
         * Question
         * There are a total of numCourses courses you have to take, labeled from 0 to
         * numCourses - 1. You are given an array prerequisites where prerequisites[i] =
         * [ai, bi] indicates that you must take course bi first if you want to take
         * course ai.
         * For example, the pair [0, 1], indicates that to take course 0 you have to
         * first take course 1.
         * Return true if you can finish all courses. Otherwise, return false.
         */
        int[] count = new int[numCourses];
        boolean[] visited = new boolean[prerequisites.length];

        for (int i = 0; i < prerequisites.length; i++) {
            count[prerequisites[i][1]]++;
        }

        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < prerequisites.length; i++) {
                if (!visited[i]) {
                    if (count[prerequisites[i][0]] == 0) {
                        visited[i] = true;
                        count[prerequisites[i][1]]--;
                        flag = true;
                    }
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public int scoreOfString(String s) {
        /*
         * Question
         * You are given a string s. The score of a string is defined as the sum of the
         * absolute difference between the ASCII values of adjacent characters.
         * 
         * Return the score of s.
         */
        int ASCIIADD = 0;
        int[] ascii = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            ascii[i] = (int) s.charAt(i);
        }
        for (int i = 0; i < ascii.length - 1; i++) {

            ASCIIADD += Math.abs(ascii[i] - ascii[i + 1]);
        }
        return ASCIIADD;
    }

    public void reverseString(char[] s) {
        /*
         * Question
         * Write a function that reverses a string. The input string is given as an
         * array of characters s.
         * You must do this by modifying the input array in-place with O(1) extra
         * memory.
         * Example 1:
         * Input: s = ["h","e","l","l","o"]
         * Output: ["o","l","l","e","h"]
         */
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    // public List<String> commonChars(String[] words) {
    // return;
    // }

    // Need to practice once
    public boolean handofStraights(int[] hand, int groupSize, int i, int n) {
        int f = hand[i] + 1;
        hand[i] = -1;
        int count = 1;
        i += 1;
        while (i < n && count < groupSize) {
            if (hand[i] == f) {
                hand[i] = -1;
                count++;
            }
            i++;
        }
        if (count != groupSize)
            return false;
        else
            return true;

    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }

        Arrays.sort(hand);
        for (int i = 0; i < n; i++) {
            if (hand[i] >= 0) {
                if (!handofStraights(hand, groupSize, i, n))
                    return false;
            }
        }
        return true;
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        /*
         * Question
         * Given an integer array nums and an integer k, return true if nums has a good
         * subarray or false otherwise.
         * 
         * A good subarray is defined as:
         * 
         * Its length is at least two.
         * The sum of the elements of the subarray is a multiple of k.
         */
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int runTotal = 0;

        for (int i = 0; i < nums.length; i++) {
            runTotal += nums[i];

            int mod = runTotal % k;
            if(map.containsKey(mod)){
                if(i - map.get(mod) > 1){
                    return true;
                }
                else {
                    map.put(mod, i);
                }
            }
        }
        return false;
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
            if (map.containsKey(mod)) {
                if (i - map.get(mod) > 1) {
                    return true;
                } else {
                    map.put(mod, i);
                }
            }
        }
        return false;
    }

    // Need to revise the concept of sub arrays also need to practice once
    public int subarraysDivByK(int[] nums, int k) {
        /*
         * Question
         * Given an integer array nums and an integer k, return the number of non-empty
         * subarrays that have a sum divisible by k.
         * 
         * A subarray is a contiguous part of an array.
         * Example 1:
         * Input: nums = [4,5,0,-2,-3,1], k = 5
         * Output: 7
         * Explanation: There are 7 subarrays with a sum divisible by k = 5:
         * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
         * Example 2:
         * Input: nums = [5], k = 9
         * Output: 0
         */
        int count = 0, sum = 0, rem;
        int md[] = new int[k];

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            rem = sum % k;
            if (rem < 0)
                rem += k; // Adjust negative remainders to be positive
            md[rem]++;
        }

        for (int i = 0; i < k; i++) {
            if (md[i] > 1)
                count += (md[i] * (md[i] - 1)) / 2; // Calculate pairs of subarrays with the same remainder
        }

        count += md[0]; // Add subarrays starting from the beginning which are directly divisible by k

        return count;
    }

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int heightChecker(int[] heights) {
        int[] expected = heights.clone();

        Arrays.sort(expected);

        int count = 0;

        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        return count;
    }

    public int search(int[] nums, int target) {
        /*
         * Question
         * There is an integer array nums sorted in ascending order (with distinct
         * values).
         * 
         * Prior to being passed to your function, nums is possibly rotated at an
         * unknown pivot index k (1 <= k < nums.length) such that the resulting array is
         * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
         * (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3
         * and become [4,5,6,7,0,1,2].
         * 
         * Given the array nums after the possible rotation and an integer target,
         * return the index of target if it is in nums, or -1 if it is not in nums.
         * 
         * You must write an algorithm with O(log n) runtime complexity.
         * 
         * 
         * 
         * Example 1:
         * 
         * Input: nums = [4,5,6,7,0,1,2], target = 0
         * Output: 4
         */
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int minIncrementForUnique(int[] nums) {
        /*
         * Question
         * You are given an integer array nums. In one move, you can pick an index i
         * where 0 <= i < nums.length and increment nums[i] by 1.
         * Return the minimum number of moves to make every value in nums unique.
         * The test cases are generated so that the answer fits in a 32-bit integer.
         */
        Arrays.sort(nums);
        int moves = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int increment = nums[i - 1] - nums[i] + 1;
                nums[i] += increment;
                moves += increment;
            }
        }
        return moves;
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = profits.length;

        for (int i = 0; i < n; i++) {
            map.put(profits[i], capital[i]);
        }

    }

    public int[] searchRange(int[] nums, int target) {
        /*
         * Question
         * Given an array of integers nums sorted in non-decreasing order, find the
         * starting and ending position of a given target value.
         * 
         * If target is not found in the array, return [-1, -1].
         * 
         * You must write an algorithm with O(log n) runtime complexity.
         * 
         * 
         * 
         * Example 1:
         * 
         * Input: nums = [5,7,7,8,8,10], target = 8
         * Output: [3,4]
         */
        int[] ans = new int[2];
        Arrays.fill(ans, -1);
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                ans[0] = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                ans[1] = mid;
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int findMin(int[] a) {
        /*
         * Question
         * Suppose an array of length n sorted in ascending order is rotated between 1
         * and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
         * 
         * [4,5,6,7,0,1,2] if it was rotated 4 times.
         * [0,1,2,4,5,6,7] if it was rotated 7 times.
         * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results
         * in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
         * 
         * Given the sorted rotated array nums of unique elements, return the minimum
         * element of this array.
         * You must write an algorithm that runs in O(log n) time.
         * Example 1:
         * Input: nums = [3,4,5,1,2]
         * Output: 1
         * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
         */
        int low = 0;
        int right = a.length - 1;

        while (low < right) {
            int mid = (right + low) / 2;

            if (a[mid] < a[right]) {
                right = mid;
            } else {
                low = mid + 1;
            }
        }
        return a[low];
    }

    
}

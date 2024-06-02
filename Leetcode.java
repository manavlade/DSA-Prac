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
        int [] ascii = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            ascii[i] = (int) s.charAt(i);
        }
        for (int i = 0; i < ascii.length-1; i++) {
            
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
        int left = 0, right = s.length-1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}

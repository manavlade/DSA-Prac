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
}

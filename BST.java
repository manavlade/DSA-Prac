import java.util.ArrayDeque;
import java.util.Deque;

public class BST {
    /*
     * Question
     * Given the root of a Binary Search Tree (BST), return the minimum absolute
     * difference between the values of any two different nodes in the tree.
     */
    public int getMinimumDifference(TreeNode root) {
        int ans = Integer.MAX_VALUE;
        int prev = -1;
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev >= 0)
                ans = Math.min(ans, root.val - prev);
            prev = root.val;
            root = root.right;
        }

        return ans;
    }
}

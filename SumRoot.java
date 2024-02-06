/*
You are given the root of a binary tree containing digits from 0 to 9 only.
Each root-to-leaf path in the tree represents a number.
For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that 
the answer will fit in a 32-bit integer. A leaf node is a node with no children.
 */
public class SumRoot {
    int sum;

    public int sumNumbers(TreeNode root) {
        traverse(root, 0);
        return sum;
    }

    public void traverse(TreeNode root, int prev) {
        int cur = prev * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += cur;
            return;
        }
        if (root.left != null) {
            traverse(root.left, cur);
        }
        if (root.right != null) {
            traverse(root.right, cur);
        }
    }
}

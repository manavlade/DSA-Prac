public class Treepyq {
    /*
     * Question
     * Given the root of a binary tree, flatten the tree into a "linked list":
     * The "linked list" should use the same TreeNode class where the right child
     * pointer points to the next node in the list and the left child pointer is
     * always null.
     * The "linked list" should be in the same order as a pre-order traversal of the
     * binary tree.
     * Example
     * Input: root = [1,2,5,3,4,null,6]
     * Output: [1,null,2,null,3,null,4,null,5,null,6]
     */
    public void flatten(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if(current.left != null){
                TreeNode runner = current.left;
                while (runner.right != null) runner = runner.right;
                runner.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }
}

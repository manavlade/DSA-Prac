import java.util.Stack;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
  this.val = val;
  this.left = left;
  this.right = right;
  }
  }

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

/*
 * Imp question
 * Implement the BSTIterator class that represents an iterator over the in-order
 * traversal of a binary search tree (BST):
 * 
 * BSTIterator(TreeNode root) Initializes an object of the BSTIterator class.
 * The root of the BST is given as part of the constructor. The pointer should
 * be initialized to a non-existent number smaller than any element in the BST.
 * boolean hasNext() Returns true if there exists a number in the traversal to
 * the right of the pointer, otherwise returns false.
 * int next() Moves the pointer to the right, then returns the number at the
 * pointer.
 * Notice that by initializing the pointer to a non-existent smallest number,
 * the first call to next() will return the smallest element in the BST.
 * 
 * You may assume that next() calls will always be valid. That is, there will be
 * at least a next number in the in-order traversal when next() is called.
 */

    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
       stack = new Stack<>();
       TreeNode tree = root;
       update(root);
    }

    public int next() {
        TreeNode toRemove = stack.pop();
        update(toRemove.right);
        return toRemove.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
    private void update (TreeNode node){
        while (node != null) {
            stack.add(node);
            node =node.left;
        }
    }



    /*
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
     * in the tree.
     * According to the definition of LCA on Wikipedia: “The lowest common ancestor
     * is defined between two nodes p and q as the lowest node in T that has both p
     * and q as descendants (where we allow a node to be a descendant of itself).”
     */
      public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(root == p || root == q){
            return root;
        }

        TreeNode leftR = lowestCommonAncestor(root.left, p, q);
        TreeNode rightR = lowestCommonAncestor(root.right, p, q);

        if(leftR != null && rightR != null){
            return root;
        }

        return (leftR != null) ? leftR : rightR;
    }

}

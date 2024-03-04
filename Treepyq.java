import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.w3c.dom.Node;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

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
            if (current.left != null) {
                TreeNode runner = current.left;
                while (runner.right != null)
                    runner = runner.right;
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

    public void BSTIterator(TreeNode root) {
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

    private void update(TreeNode node) {
        while (node != null) {
            stack.add(node);
            node = node.left;
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
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode leftR = lowestCommonAncestor(root.left, p, q);
        TreeNode rightR = lowestCommonAncestor(root.right, p, q);

        if (leftR != null && rightR != null) {
            return root;
        }

        return (leftR != null) ? leftR : rightR;
    }

    /*
     * Given the root of a binary tree, return the average value of the nodes on
     * each level in the form of an array. Answers within 10-5 of the actual answer
     * will be accepted.
     * Example 1:
     * Input: root = [3,9,20,null,null,15,7]
     * Output: [3.00000,14.50000,11.00000]
     * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5,
     * and on level 2 is 11.
     * Hence return [3, 14.5, 11].
     */
    private List<Long> sum = new ArrayList<>();
    private List<Integer> count = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        dfs(root, 0);
        List<Double> ans = new ArrayList<>();
        for (int i = 0; i < sum.size(); ++i) {
            ans.add(sum.get(i) * 1.0 / count.get(i));
        }
        return ans;
    }

    private void dfs(TreeNode root, int i) {
        if (root == null) {
            return;
        }

        if (sum.size() == i) {
            sum.add((long) root.val);
            count.add(1);
        } else {
            sum.set(i, sum.get(i) + root.val);
            count.set(i, count.get(i) + 1);
        }
        dfs(root.left, i + 1);
        dfs(root.right, i + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int levelSize = que.size();
            List<Integer> ans = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = que.poll();
                ans.add(current.val);

                if (current.left != null) {
                    que.add(current.left);
                }
                if (current.right != null) {
                    que.add(current.right);
                }

                list.add(ans);
            }
        }
        return list;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        /*
         * Question
         * Given the root of a binary tree, return the zigzag level order traversal of
         * its nodes' values. (i.e., from left to right, then right to left for the next
         * level and alternate between).
         * Example
         * Input: root = [3,9,20,null,null,15,7]
         * Output: [[3],[20,9],[15,7]]
         */
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelvalues = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curreny = queue.poll();

                if (reverse) {
                    levelvalues.add(0, curreny.val);
                } else {
                    levelvalues.add(curreny.val);
                }
                if (curreny.left != null) {
                    queue.add(curreny.left);
                }
                if (curreny.right != null) {
                    queue.add(curreny.right);
                }
            }
            result.add(levelvalues);
            reverse = !reverse;
        }
        return result;
    }

    int max = Integer.MIN_VALUE;

    public int maxPath(TreeNode root) {
        /*
         * Question
         * A path in a binary tree is a sequence of nodes where each pair of adjacent
         * nodes in the sequence has an edge connecting them. A node can only appear in
         * the sequence at most once. Note that the path does not need to pass through
         * the root.
         * The path sum of a path is the sum of the node's values in the path.
         * Given the root of a binary tree, return the maximum path sum of any non-empty
         * path.
         * Input: root = [-10,9,20,null,null,15,7]
         * Output: 42
         * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7
         * = 42.
         */
        if (root == null)
            return 0;
        int value = root.val;
        int left_sum = Math.max(maxPath(root.left), 0);
        int right_sum = Math.max(maxPath(root.right), 0);
        max = Math.max(max, left_sum + right_sum + value);
        return Math.max(left_sum, right_sum) + value;
    }

    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return max;
    }

    ArrayList<Integer> findSpiral(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        if (root != null) {
            return arr;
        }
        Queue<Node> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        boolean reverse = false;

        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node curent = queue.poll();
                if (reverse) {
                    stack.push(curent.data);
                } else {
                    arr.add(curent.data);
                }

                if (curent.left != null) {
                    queue.add(curent.left);
                }

                if (curent.right != null) {
                    queue.add(curent.right);
                }
            }
            while (!stack.isEmpty()) {
                arr.add(stack.pop());
            }
            reverse = !reverse;
        }
        return arr;
    }

    public int kthSmallest(TreeNode root, int k) {
        /*
         * Question
         * Given the root of a binary search tree, and an integer k, return the kth
         * smallest value (1-indexed) of all the values of the nodes in the tree.
         * Input: root = [3,1,4,null,2], k = 1
         * Output: 1
         * First create a arraylist of integer type
         * Add all tree elemts
         * Get the kth number from arraylist
         */
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root, arr, k);
        return (k > 0 && k <= arr.size()) ? arr.get(k - 1) : -1;
    }

    private void inorder(TreeNode root, ArrayList<Integer> arr, int k) {
        if (root == null || arr.size() >= k) {
            return;
        }
        inorder(root.left, arr, k);
        arr.add(root.val);
        inorder(root.right, arr, k);
    }

    public boolean isBstHelper(TreeNode root, Integer min, Integer max){
        if(root == null){
            return true;
        }

        if((min != null && root.val<= min ) || (max != null &&  root.val >= max)){
            return false;
        }

        return isBstHelper(root.left, min, root.val) && isBstHelper(root.right, root.val, max);
    }
    public boolean isValidBST(TreeNode root) {
        /*
         * Question
         * Given the root of a binary tree, determine if it is a valid binary search
         * tree (BST).
         * A valid BST is defined as follows:
         * The left
         * subtree
         * of a node contains only nodes with keys less than the node's key.
         * The right subtree of a node contains only nodes with keys greater than the
         * node's key.
         * Both the left and right subtrees must also be binary search trees.
         */
        return isBstHelper(root, null, null);
    }
}

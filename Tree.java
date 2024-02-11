import java.util.*;
import java.util.LinkedList;;
class TreeNode {
    int value;
    TreeNode left;
    TreeNode Right;

    public TreeNode(int value) {
        this.value = value;
        left = null;
        Right = null;
    }
}

 class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class TREE {
    TreeNode root;

    public TREE() {
        root = null;
    }

    public void insert(int value) {
        root = insertNode(root, value);
    }

    private TreeNode insertNode(TreeNode node, int value) {
        if (node == null) {
            node = new TreeNode(value);
            return node;
        }
        if (value < node.value) {
            node.left = insertNode(node.left, value);
        } else if (value > node.value) {
            node.Right = insertNode(node.Right, value);
        }
        return node;
    }

    // public class Tree {

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {
            if (idx + 1 >= nodes.length || nodes[idx + 1] == -1) {
                return null;
            }
            idx++;

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");

        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data);
    }

    public static void levelOrder(Node root) {

        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currentNode = q.remove();
            if (currentNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currentNode.data + " ");
                if (currentNode.left != null) {
                    q.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    q.add(currentNode.right);
                }
            }
        }
    }

    boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (Math.abs(rightHeight - leftHeight) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

}

public class Tree {
    public static void main(String[] args) {
        TREE t = new TREE();
        t.insert(5);
        t.insert(25);
        t.insert(20);
        int nodes[] = { 4, 5, 8, 4, 5, 67, 0 };
        // BinaryTree tree = new BinaryTree();
        // Node root = tree.buildTree(nodes);
        // System.out.println(root.data);
        // // preOrder(root);
        // // inOrder(root);
        // // postOrder(root);
        // levelOrder(root);
    }
}

// Tree Node creation

// public static void main(String[] args) {
// }
// }

// Backtracking

// public class Tree {
// public static void printPermutation(String str, String perm, int indx){
// if(str.length() == 0){
// System.out.println(perm);
// return;
// }
// for (int i = 0; i < str.length(); i++) {
// char currChar = str.charAt(i);
// String newstr = str.substring(0, i) + str.substring(i+1);
// printPermutation(newstr, perm + currChar, indx+1);
// }
// }
// public static void main(String[] args) {
// String str = "ABC";
// printPermutation(str, "", 0);
// }
// }

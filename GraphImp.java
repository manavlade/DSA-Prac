import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
// Baaaki hai
public class GraphImp {
    /*
     * Question
     * Given a reference of a node in a connected undirected graph.
     * 
     * Return a deep copy (clone) of the graph.
     * 
     * Each node in the graph contains a value (int) and a list (List[Node]) of its
     * neighbors.
     * 
     * class Node {
     * public int val;
     * public List<Node> neighbors;
     *  Test case format:
     * For simplicity, each node's value is the same as the node's index
     * (1-indexed). For example, the first node with val == 1, the second node with
     * val == 2, and so on. The graph is represented in the test case using an
     * adjacency list.
     *  An adjacency list is a collection of unordered lists used to represent a
     * finite graph. Each list describes the set of neighbors of a node in the
     * graph. The given node will always be the first node with val = 1. You must return
     * the copy of the given node as a reference to the cloned graph. 
     */
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public Node cloneGraph(Node node) {
        HashMap<Integer,Node> visitedMap = new HashMap<Integer,Node>();
       return doCloneGraph(node,visitedMap);
    }

    public Node doCloneGraph(Node node,HashMap<Integer,Node> visitedMap){
        if(node == null){
            return node;
        }
        if(visitedMap.get(node.val) != null){
            return visitedMap.get(node.val);
        }
        Node cloneNode = new Node();
        cloneNode.val = node.val;
        visitedMap.put(node.val,cloneNode);
        if(node.neighbors != null){
            cloneNode.neighbors = new ArrayList<Node>();
            for(Node eachNode : node.neighbors){
                cloneNode.neighbors.add(doCloneGraph(eachNode,visitedMap));
            }
        }
        return cloneNode;
        
    }

    public int findCenter(int[][] edges) {
        /*
         * Question
         * There is an undirected star graph consisting of n nodes labeled from 1 to n.
         * A star graph is a graph where there is one center node and exactly n - 1
         * edges that connect the center node with every other node.
         * 
         * You are given a 2D integer array edges where each edges[i] = [ui, vi]
         * indicates that there is an edge between the nodes ui and vi. Return the
         * center of the given star graph.
         */
        /*
         * Approach 
         * The approach used in the given code is to check if the first element of the first edge is present in the second edge. 
         * If it is, then the first element of the first edge is the center of the star graph. 
         * If not, then the second element of the first edge is the center of the star graph.
         */
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }

    public long maximumImportance(int n, int[][] roads) {
        /*
         * Question
         * You are given an integer n denoting the number of cities in a country. The
         * cities are numbered from 0 to n - 1.
         * 
         * You are also given a 2D integer array roads where roads[i] = [ai, bi] denotes
         * that there exists a bidirectional road connecting cities ai and bi.
         * 
         * You need to assign each city with an integer value from 1 to n, where each
         * value can only be used once. The importance of a road is then defined as the
         * sum of the values of the two cities it connects.
         * 
         * Return the maximum total importance of all roads possible after assigning the
         * values optimally.
         */
        int degree [] = new int[n];

        for (int [] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }

        Integer cities [] = new Integer[n];

        for (int i = 0; i < n; i++) {
            cities[i] = i;
        }

        Arrays.sort(cities, new Comparator<Integer>() {
            public int compare(Integer a, Integer b){
                return Integer.compare(degree[b], degree[a]);
            }
        });

        long totalIMP = 0;

        for (int i = 0; i < n; i++) {
            totalIMP += (long) (n-i) * degree[cities[i]];
        }
        return totalIMP;
    }
}

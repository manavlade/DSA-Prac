import java.util.ArrayList;
import java.util.PriorityQueue;

public class MST {
    public static class Edge {
        int src;
        int destination;
        int weight; // for dijstras algorithm

        public Edge(int s, int d, int w) {
            this.src = s;
            this.destination = d;
            this.weight = w; // for dijktras algorithm
        }
    }
        public static void CreateGraph( ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1,10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0,10));
        graph[1].add(new Edge(1, 3,40));

        graph[2].add(new Edge(2, 0,15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }
    
    public static class Pair implements Comparable<Pair>  {
        int node;
        int cost;

        public Pair(int n, int d){
            this.node = n;
            this.cost = d;
        }
        
        @Override
        public int compareTo(Pair P2) {
            return this.cost - P2.cost; // ascending
        }
    }

    public static void MST(ArrayList<Edge> graph[], int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean visited [] = new boolean[V];
        pq.add(new Pair(0, 0));
        int mxtSum = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!visited[curr.node]){
                visited[curr.node] = true;
                mxtSum += curr.cost;

                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    if(!visited[e.destination]){
                        pq.add(new Pair(e.destination, e.weight));
                    }
                }
            }
        }
        System.out.println(" The cost is =" + mxtSum);
    }
    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        CreateGraph(graph);
        MST(graph, v);
    }
}
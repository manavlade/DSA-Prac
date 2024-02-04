import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijsktras {
   public static class Edge {
        int start;
        int destination;
        int weight; // for dijstras algorithm

        public Edge(int s, int d, int w) {
            this.start = s;
            this.destination = d;
            this.weight = w; // for dijktras algorithm
        }
    }

    public static void CreateGraph( ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1,2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3,7));
        graph[1].add(new Edge(1, 2,1));

        graph[2].add(new Edge(2, 4,3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3,2));
        graph[4].add(new Edge(4, 5,5));
    }

    public static class Pair implements Comparable<Pair>  {
        int node;
        int dist;

        public Pair(int n, int d){
            this.node = n;
            this.dist = d;
        }
        
        @Override
        public int compareTo(Pair P2) {
            return this.dist - P2.dist ;
        }
    }
    //O(E + ELogV)
    public static void Dijsktras(ArrayList<Edge> graph[], int src, int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean vis [] = new boolean[V];
        int dist [] = new int[V];
        for (int i = 0; i < V; i++) {
            if(i != src){
                dist[i]= Integer.MAX_VALUE;
            }
        }
        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.node]){
                vis[curr.node] = true;
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.start;
                    int v = e.destination;
                    if(dist[u] + e.weight < dist[v]){
                        dist[v] = dist[u] + e.weight;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int V= 6;
         ArrayList<Edge> graph[]= new ArrayList[V];
         CreateGraph(graph);
         Dijsktras(graph, 0, V);
    }
}

import java.util.ArrayList;

public class BellmonFord {
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
        graph[0].add(new Edge(0, 1,2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2,-4));

        graph[2].add(new Edge(2, 3,2));


        graph[3].add(new Edge(3, 4, 4));


        graph[4].add(new Edge(4, 1,-1));
    }

    public static void Bellmongord(ArrayList<Edge> graph[], int src, int V){
        int dist [] = new int[V];
        for (int i = 0; i < V; i++) {
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        for (int k = 0; k < V-1; k++) { //for vertices
            for (int i = 0; i < V; i++) { // For edges
                for (int j = 0; j < graph[i].size(); j++) {
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.destination;
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + e.weight < dist[v]){
                        dist[v] = dist[u]+ e.weight;
                    }
                }
            }
        }

        // For detecting negative weight
        for (int k = 0; k < V - 1; k++) { // for vertices
            for (int i = 0; i < V; i++) { // For edges
                for (int j = 0; j < graph[i].size(); j++) {
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v = e.destination;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + e.weight < dist[v]) {
                        System.out.println("Negative weight cycle found");
                    }
                }
            }
        }

        

        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        CreateGraph(graph);
        Bellmongord(graph, 0, V);
    }
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Graph Creation 
public class Graph {
    static class Edge {
        int start;
        int destination;

        public Edge(int s, int d) {
            this.start = s;
            this.destination = d;
        }
    }

    public static void CreateGraph( ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));
    }

    public static void bFS(ArrayList<Edge> graph[], int V, boolean vis[], int start){
        Queue<Integer> q = new LinkedList<>();
        
        q.add(start);

       while (!q.isEmpty()) {
        int curr = q.remove();
        if(vis[curr] = false){
            System.out.print(curr + " ");
            vis[curr] = true;
        }
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e =graph[curr].get(i);
            q.add(e.destination);
        }
       }
       
    }

    public static void dFS(ArrayList<Edge> graph[], int curr, boolean vis []){
        System.out.print(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            dFS(graph, e.destination, vis);
        }
    }

    public static void allPair(ArrayList<Edge> graph[],boolean vis [], int current, String path, int tar){
        if(current ==  tar){
            return;
        }
        for (int i = 0; i < graph[current].size(); i++) {
            Edge e = graph[current].get(i);
            if(!vis[current]){
                vis[current] = true;
                allPair(graph, vis, e.destination, path + e.destination, tar);
                vis[current] = false;
            }
        }
    }

    public static boolean allCycle(ArrayList<Edge> graph[],boolean vis [], boolean rec [], int current){
        vis[current] = true;
        rec[current] =  true;
       for (int i = 0; i < graph[current].size(); i++) {
           Edge e = graph[current].get(i);
           if(rec[e.destination]){
            return true;
           }
           else if(!vis[e.destination]){
            if(allCycle(graph, vis, rec, e.destination)){
                return true;
            }
           }
       }
       rec[current]= false;
       return false;
    }
     public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[]  = new ArrayList[V];
        CreateGraph(graph);
        // Ye part tabhi add karna jab graph tukdo mei bata hoga
        // boolean vis [] = new boolean[V];
        // for (int i = 0; i < V; i++) {
        //     if(vis[i] == false){
        //         bFS(graph, V, vis, i);
        //     }
        // }
  
        // System.out.println();



        // Printing neughbours of 2
        // for (int i = 0; i < graph.length; i++) {
        // Edge e = graph[2].get(i);
        // System.out.println(e.destination);
        // }

        // Cycle detection ke liye
        boolean visited [] = new boolean[V];
        boolean recursion [] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if(!visited[i]){
               boolean iscycle =  allCycle(graph, visited, recursion, 0);
               if(iscycle){
                System.out.println(iscycle);
                break;
               }
            }
        }
    }
}

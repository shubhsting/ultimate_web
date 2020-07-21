import java.util.*;

public class L001 {

    public static class Graph_Edge {
        int dest = 0;
        int weight = 0;

        Graph_Edge(int dest, int weight) {
            this.weight = weight;
            this.dest = dest;
        }
    }

    public static void addEdge(ArrayList<Graph_Edge>[] graph, int parent, int dest, int weight) {
        graph[parent].add(new Graph_Edge(dest, weight));
        graph[dest].add(new Graph_Edge(parent, weight));
    }

    public static void display(ArrayList<Graph_Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + " -> ");
            for (Graph_Edge e : graph[i]) {
                System.out.print("(" + e.dest + " " + e.weight + ")");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayList<Graph_Edge>[] graph = new ArrayList[7];
        for (int i = 0; i < 7; i++)
            graph[i] = new ArrayList<>();
        addEdge(graph, 1, 2, 0);
        addEdge(graph, 3, 5, 10);
        addEdge(graph, 6, 4, 7);
        display(graph);
    }

    
}
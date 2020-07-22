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

    public static int findEdge(ArrayList<Graph_Edge>[] graph, int node1, int node2) {
        int index = 0;
        for (int i = 0; i < graph[node1].size(); i++) {
            if (graph[node1].get(i).dest == node2)
                return index = i;
        }
        return -1;
    }

    public static void removeEdge(ArrayList<Graph_Edge>[] graph, int node1, int node2) {
        int idx1 = findEdge(graph, node1, node2);
        int idx2 = findEdge(graph, node2, node1);
        graph[node1].remove(idx1);
        graph[node2].remove(idx2);
    }

    public static void removenode(ArrayList<Graph_Edge>[] graph, int node) {
        for (int i = 0; i < graph[node].size(); i++)
            removeEdge(graph, node, graph[node].get(i).dest);
    }

    public static boolean hasPath(ArrayList<Graph_Edge>[] graph, int start, int end, boolean[] vis) {
        if (start == end)
            return true;
        vis[start] = true;
        boolean res = false;
        for (Graph_Edge ed : graph[start])
            if (!vis[ed.dest])
                res = res || hasPath(graph, ed.dest, end, vis);
        return res;
    }

    public static int allPath(ArrayList<Graph_Edge>[] graph, int start, int end, boolean[] vis) {
        if (start == end)
            return 1;
        vis[start] = true;
        int count = 0;
        for (Graph_Edge ed : graph[start])
            if (!vis[ed.dest])
                count += allPath(graph, ed.dest, end, vis);
        vis[start] = false;
        return count;
    }

    public static void main(String[] args) {
        // ArrayList<Graph_Edge>[] graph = new ArrayList[7];
        // for (int i = 0; i < 7; i++)
        // graph[i] = new ArrayList<>();
        // addEdge(graph, 1, 2, 0);
        // addEdge(graph, 3, 5, 10);
        // addEdge(graph, 6, 4, 7);
        // display(graph);
        int[] arr = { 10, 20, 30 };
        for (int i = 0; i < 3; i++)
            System.out.print(arr[i] + " ");

        for (int ele : arr)
            System.out.println(ele + " ");
    }

}
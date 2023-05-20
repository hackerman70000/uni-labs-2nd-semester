import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Graph {
    int vertices;
    List<Edge> edges;

    public Graph(int vertices) {
        this.vertices = vertices;
        edges = new ArrayList<>();
    }

    public void addEdge(int source, int destination, double weight) {
        Edge edge = new Edge(source, destination, weight);
        edges.add(edge);
    }

    private int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex)
            return find(parent, parent[vertex]);
        return vertex;
    }

    private void union(int[] parent, int x, int y) {
        int xSet = find(parent, x);
        int ySet = find(parent, y);
        parent[xSet] = ySet;
    }

    public List<Edge> kruskalMST() {
        List<Edge> minimumSpanningTree = new ArrayList<>();

        // Sort edges by weight in ascending order
        Collections.sort(edges);

        int[] parent = new int[vertices];
        for (int i = 0; i < vertices; i++)
            parent[i] = i;

        int edgeCount = 0;
        int index = 0;
        while (edgeCount < vertices - 1) {
            Edge edge = edges.get(index++);
            int sourceParent = find(parent, edge.source);
            int destinationParent = find(parent, edge.destination);

            if (sourceParent != destinationParent) {
                minimumSpanningTree.add(edge);
                edgeCount++;
                union(parent, sourceParent, destinationParent);
            }
        }

        return minimumSpanningTree;
    }
}
import java.util.Stack;

public class BellmanFordAlg {
    private double[] distTo; // dlugosc sciezki s->v
    private DirectEdge[] edgeTo; // ostatnia krawedzsciezki s->v
    private boolean[] onQueue; // obecnośc v w kolejce
    private ListQueue<Integer> queue; // wierzcholki wkolejce

    public BellmanFordAlg(DigraphWeighted G, int s) {
        distTo = new double[G.V()];
        edgeTo = new DirectEdge[G.V()];
        onQueue = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;
//Algorytm Bellmana-Forda
        queue = new ListQueue<Integer>();
        queue.enqueue(s);
        onQueue[s] = true;
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            onQueue[v] = false;
            relax(G, v);
        }
    }

    private void relax(DigraphWeighted G, int v) {
        for (DirectEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (!onQueue[w]) {
                    queue.enqueue(w);
                    onQueue[w] = true;
                }
            }
        }
    }


    public double distTo(int v) {
        validateVertex(v);
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        validateVertex(v);
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectEdge> pathTo(int v) {
        validateVertex(v);
        if (!hasPathTo(v))
            return null;
        Stack<DirectEdge> path = new Stack<DirectEdge>();
        for (DirectEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }

        Stack<DirectEdge> reversedPath = new Stack<DirectEdge>();
        while (!path.isEmpty()) {
            reversedPath.push(path.pop());
        }

        return reversedPath;
    }


    private void validateVertex(int v) {
        int V = distTo.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("Blad! wierzcholek nie nalezy do grafu.");
    }
}

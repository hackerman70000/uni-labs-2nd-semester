class Edge implements Comparable<Edge> {
    int source, destination;
    double weight;

    public Edge(int source, int destination, double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge edge) {
        return Double.compare(this.weight, edge.weight);
    }

    public double getWeight() {
        return weight;
    }
}
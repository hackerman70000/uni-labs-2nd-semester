import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;


public class main {
    public static void main(String[] args) {
        File file = new File("lab4/task1/g250.txt");

        try {
            Scanner scanner = new Scanner(file);

            int numberOfVertices = Integer.parseInt(scanner.nextLine());
            int numberOfEdges = Integer.parseInt(scanner.nextLine());

            Graph graph = new Graph(numberOfVertices);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                int source = Integer.parseInt(parts[0]);
                int destination = Integer.parseInt(parts[1]);
                double weight = Double.parseDouble(parts[2]);
                graph.addEdge(source, destination, weight);
            }


            scanner.close();

            List<Edge> minimumSpanningTree = graph.kruskalMST();

            System.out.println("Minimum spanning tree:");
            for (Edge edge : minimumSpanningTree) {
                System.out.println(edge.source + " - " + edge.destination + ", weight: " + edge.weight);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File + " + file.getName() + " not found.");
        }
    }
}


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        File file = new File("lab4/task2/g10.txt");
        String outputFile = "lab4/task2/output.txt";

        try {
            Scanner scanner = new Scanner(file);
            PrintWriter writer = new PrintWriter(new FileWriter(outputFile));

            int numberOfVertices = Integer.parseInt(scanner.nextLine());
            int numberOfEdges = Integer.parseInt(scanner.nextLine());

            DigraphWeighted graph = new DigraphWeighted(numberOfVertices);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                int source = Integer.parseInt(parts[0]);
                int destination = Integer.parseInt(parts[1]);
                double weight = Double.parseDouble(parts[2]);
                graph.addEdge(new DirectEdge(source, destination, weight));
            }
            scanner.close();

            System.out.println("What is the destination?");
            int d = new Scanner(System.in).nextInt();
            int s = 0;
            BellmanFordAlg bf = new BellmanFordAlg(graph, s);
            for (int v = 0; v < graph.V(); v++) {
                if (v == d) {
                    if (bf.hasPathTo(v)) {
                        System.out.printf("%d to %d (%5.2f) ", s, v, bf.distTo(v));
                        writer.printf("%d to %d (%5.2f) ", s, v, bf.distTo(v));
                        for (DirectEdge e : bf.pathTo(v)) {
                            System.out.print(e + " ");
                            writer.print(e + " ");
                        }
                        writer.println();
                        System.out.println();
                    } else {
                        System.out.printf("%d to %d no path\n", s, v);
                        writer.printf("%d to %d no path\n", s, v);
                    }
                }
            }

            writer.close();
            System.out.println("Output saved to " + outputFile);

        } catch (FileNotFoundException e) {
            System.out.println("File + " + file.getName() + " not found.");
        } catch (IOException e) {
            System.out.println("Error writing to the output file.");
        }
    }
}

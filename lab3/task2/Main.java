import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[][] pixels = {
                {0, 0, 1, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 0, 1, 1},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0}
        };

        ImageGenerator(pixels);
        pixels = LoadImage();

        Map<Integer, ArrayList<Integer>> graph = GraphGenerator(pixels);

        printGraph(graph);
        findpaths(graph, 0, 24, 16);

    }

    public static void printGraph(Map<Integer, ArrayList<Integer>> graph) {
        for (int Vertex : graph.keySet()) {
            System.out.println(Vertex + "->" + graph.get(Vertex).toString());
        }
    }


    public static Map<Integer, ArrayList<Integer>> GraphGenerator(int pixels[][]) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();


        int width = pixels[0].length;
        int height = pixels.length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // jeśli wartość w macierzy to 0, utwórz wierzchołek i dodaj go do grafu
                if (pixels[i][j] == 0) {
                    int vertex = i * width + j;
                    graph.put(vertex, new ArrayList<Integer>());
                }
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // jeśli wartość w macierzy to 0, utwórz wierzchołek i dodaj go do grafu
                if (pixels[i][j] == 0) {
                    int vertex = i * width + j;

                    if (i > 0 && pixels[i - 1][j] == 0) { // górne pole
                        int neighbor = (i - 1) * width + j;
                        graph.get(vertex).add(neighbor);
                        //graph.get(neighbor).add(vertex);
                    }
                    if (i < height - 1 && pixels[i + 1][j] == 0) { // dolne pole
                        int neighbor = (i + 1) * width + j;
                        graph.get(vertex).add(neighbor);
                    }
                    if (j > 0 && pixels[i][j - 1] == 0) { // lewe pole
                        int neighbor = i * width + j - 1;
                        graph.get(vertex).add(neighbor);
                    }
                    if (j < pixels[0].length - 1 && pixels[i][j + 1] == 0) { // prawe pole
                        int neighbor = i * width + j + 1;
                        graph.get(vertex).add(neighbor);
                    }
                }
            }
        }

        return graph;
    }

    public static void ImageGenerator(int[][] pixels) throws RuntimeException {

        int width = pixels[0].length;
        int height = pixels.length;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
        Graphics2D g2d = image.createGraphics();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (pixels[y][x] == 1) {
                    g2d.setColor(Color.BLACK);
                } else {
                    g2d.setColor(Color.WHITE);
                }
                g2d.fillRect(x, y, 1, 1);
            }
        }

        g2d.dispose();

        File output = new File("image.bmp");
        try {
            ImageIO.write(image, "bmp", output);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int[][] LoadImage() {

        int[][] matrix = new int[0][];
        try {
            File file = new File("image.bmp");
            BufferedImage image = ImageIO.read(file);
            int width = image.getWidth();
            int height = image.getHeight();

            matrix = new int[height][width];

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    Color color = new Color(image.getRGB(x, y));
                    if (color.getRed() == 0 && color.getGreen() == 0 && color.getBlue() == 0) {
                        matrix[y][x] = 1;
                    } else {
                        matrix[y][x] = 0;
                    }
                }
            }

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    System.out.print(matrix[y][x] + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matrix;
    }

    static List<Integer> findpaths(Map<Integer, ArrayList<Integer>> map, int src, int dst, int v) {
        Queue<List<Integer>> queue = new LinkedList<>();

        List<Integer> path = new ArrayList<>();
        path.add(src);
        queue.offer(path);

        while (!queue.isEmpty()) {
            path = queue.poll();
            int last = path.get(path.size() - 1);

            if (last == dst) {
                printPath(path);
            }

            List<Integer> lastNode = map.get(last);
            for (int i = 0; i < lastNode.size(); i++) {
                if (isNotVisited(lastNode.get(i), path)) {
                    List<Integer> newpath = new ArrayList<>(path);
                    newpath.add(lastNode.get(i));
                    queue.offer(newpath);
                }
            }
        }
        return path;
    }


    private static void printPath(List<Integer> path) {
        int size = path.size();
        for (Integer v : path) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    private static boolean isNotVisited(int x, List<Integer> path) //czy był juz odwiedzony
    {
        int size = path.size();
        for (int i = 0; i < size; i++)
            if (path.get(i) == x)
                return false;

        return true;
    }
}
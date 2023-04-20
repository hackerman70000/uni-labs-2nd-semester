import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PathFinderTest {

    @Test
    public void testGraphGenerator() {
        int[][] pixels = {
                {0, 0, 1, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 0, 1, 1},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0}
        };

        Map<Integer, ArrayList<Integer>> graph = PathFinder.GraphGenerator(pixels);

        assertNotNull(graph);
        assertEquals(16, graph.size());
        assertTrue(graph.get(0).contains(1));
        assertTrue(graph.get(1).contains(0));
        assertTrue(graph.get(5).contains(10));
        assertTrue(graph.get(17).contains(12));
        assertFalse(graph.get(0).contains(6));
        assertFalse(graph.get(1).contains(3));
    }

    @Test
    public void testFindPath() {
        int[][] pixels = {
                {0, 0, 1, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 0, 1, 1},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0}
        };

        Map<Integer, ArrayList<Integer>> graph = PathFinder.GraphGenerator(pixels);

        //Testowanie polega na sprawdzaniu długości ścieżki zwróconej przez funkcje findpaths
        List<Integer> firstPath = PathFinder.findPath(graph,0,10,graph.size());
        assertEquals(3,firstPath.size());
        List<Integer> secondPath = PathFinder.findPath(graph,15,12,graph.size());
        assertEquals(4,secondPath.size());

        //Jeśli ścieżka nie istanieje to findpaths zwraca null
        List<Integer> thirdPath = PathFinder.findPath(graph,4,20,graph.size());
        assertNull(thirdPath);
    }
}

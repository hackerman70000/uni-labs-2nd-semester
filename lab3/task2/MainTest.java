import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainTest {

    @Test
    public void testGraphGenerator() {
        int[][] pixels = {
                {0, 0, 1, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 0, 1, 1},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0}
        };

        Map<Integer, ArrayList<Integer>> graph = Main.GraphGenerator(pixels);

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
    public void testFindPaths() {
       // będzie dodane



    }
}

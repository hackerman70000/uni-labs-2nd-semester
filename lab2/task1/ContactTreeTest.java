package task1;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Klasa do testów jednostkowych klasy BinaryTree (dla zwykłego oraz zdegenerowanego drzewa binarnego)
 */
public class ContactTreeTest {

    BinaryTree<Integer> bt = new BinaryTree<>();

    /**
     * Test dla zwykłego drzewa binarnego
     */
    @Test
    public void testTree(){
        bt.add(5);
        bt.add(3);
        bt.add(7);
        bt.add(2);
        bt.add(4);
        bt.add(6);
        bt.add(8);

        int[] expected = {2, 3, 4, 5, 6, 7, 8};
        int i = 0;
        for (BinaryTree<Integer>.Node current : bt) {
            assertEquals(expected[i], current.getValue());
            i++;
        }
    }

    /**
     * Test dla zdegenerowanego drzewa binarnego
     */
    @Test
    public void testDegenerateTree(){
        bt.add(7);
        bt.add(6);
        bt.add(5);
        bt.add(4);
        bt.add(3);
        bt.add(2);
        bt.add(1);

        int[] expected = {1, 2, 3, 4, 5, 6, 7};
        int i = 0;
        for (BinaryTree<Integer>.Node current : bt) {
            assertEquals(expected[i], current.getValue());
            i++;
        }
    }
}

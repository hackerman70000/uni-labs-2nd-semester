import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LRUCacheTest {

    @Test
    public void testPutAndGet() throws Exception {
        LRUCache<Integer, String> cache = new LRUCache<>(2);
        cache.put(1, "apple");
        cache.put(2, "banana");
        assertEquals("apple", cache.get(1));
        assertEquals("banana", cache.get(2));
    }

    @Test
    public void testPutWithSameKey() throws Exception {
        LRUCache<Integer, String> cache = new LRUCache<>(2);
        cache.put(1, "apple");
        cache.put(1, "orange");
        assertEquals("orange", cache.get(1));
    }

    @Test
    public void testGetNonExistentKey() {
        LRUCache<Integer, String> cache = new LRUCache<>(2);
        assertThrows(Exception.class, () -> cache.get(1));
    }

    @Test
    public void testLRU() throws Exception {
        LRUCache<Integer, String> cache = new LRUCache<>(2);
        cache.put(1, "apple");
        cache.put(2, "banana");
        cache.put(3, "orange");
        assertEquals("banana", cache.get(2));
        assertEquals("orange", cache.get(3));
    }

    @Test
    public void testIncreasingCapacity() throws Exception {
        LRUCache<Integer, String> cache = new LRUCache<>(2);
        cache.put(1, "apple");
        cache.put(2, "banana");
        cache.setCapacity(3);
        cache.put(3, "orange");
        assertEquals("apple", cache.get(1));
        assertEquals("banana", cache.get(2));
        assertEquals("orange", cache.get(3));
    }

    @Test
    void testDecreasingCapacity() throws Exception {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "apple");
        cache.put(2, "banana");
        cache.put(3, "orange");

        // Decrease capacity to 2
        cache.setCapacity(2);
        assertEquals(2, cache.getCapacity());


        assertThrows(Exception.class, () -> cache.get(1)); // apple should have been removed due to LRU policy
        assertEquals("banana", cache.get(2));
        assertEquals("orange", cache.get(3));

        // Decrease capacity to 1
        cache.setCapacity(1);
        assertEquals(1, cache.getCapacity());

        assertThrows(Exception.class, () -> cache.get(2));
        assertThrows(Exception.class, () -> cache.get(1));
        assertEquals("orange", cache.get(3));
    }

}

// https://www.interviewcake.com/concept/java/lru-cache
// https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html
// https://www.javatpoint.com/java-linkedhashmap

import java.util.Iterator;
import java.util.LinkedHashMap;

public class LRUCache<K, V> {

    private int capacity;
    LinkedHashMap cache = new LinkedHashMap(0, 0.75f, true);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        setCapacity(capacity);
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
            cache.put(key, value);
        } else {
            if (cache.size() == capacity) {
                cache.remove(cache.keySet().iterator().next());
            }
            cache.put(key, value);
        }
    }

    public V get(K key) throws Exception {
        if (cache.containsKey(key)) {
            return (V) cache.get(key);
        }
        throw new Exception("There is no such element as " + key);
    }

    public int getCapacity() {
        return capacity;
    }


    public void setCapacity(int capacity) {
        this.capacity = capacity;
        LinkedHashMap<K, V> newCache = new LinkedHashMap<>(capacity, 0.75f, true);
        // Remove the oldest elements if the new capacity is smaller than the old one
        if (cache.size() > capacity) {
            Iterator<K> iterator = cache.keySet().iterator();
            for (int i = 0; i < cache.size() - capacity; i++) {
                iterator.next();
                iterator.remove();
            }
        }
        newCache.putAll(cache);
        cache = newCache;
    }


    @Override
    public String toString() {
        return cache.toString();
    }

}

package task2;

import java.util.HashMap;
import java.util.Map;

public class Node {
    Map<Character, Node> children;
    boolean ifEnd;


    public Node() {
        children = new HashMap<>();
        ifEnd = false;
    }

    public void insert(String word) {
        Node current = this;

        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            Node node = current.children.get(character);
            if (node == null) {
                node = new Node();
                current.children.put(character, node);
            }
            current = node;
        }
        current.ifEnd = true;
    }

}


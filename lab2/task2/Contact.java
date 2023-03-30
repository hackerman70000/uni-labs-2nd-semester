package task2;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    private final Node root;

    public Contact() {
        root = new Node();
    }

    public void add(String contact) {
        root.insert(contact);
    }

    public List<String> find(String prefix) {
        List<String> foundContacts = new ArrayList<>();
        Node current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char character = prefix.charAt(i);
            Node node = current.children.get(character);
            if (node == null) {
                return foundContacts;
            }
            current = node;
        }
        findContacts(current, prefix, foundContacts);
        return foundContacts;
    }

    private void findContacts(Node node, String prefix, List<String> contacts) {
        if (node.ifEnd) {
            contacts.add(prefix);
        }
        for (Character character : node.children.keySet()) {
            findContacts(node.children.get(character), prefix + character, contacts);
        }
    }

}

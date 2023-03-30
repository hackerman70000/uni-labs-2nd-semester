package task2;

import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ContactTest {
    private Contact c;

    @Before
    public void testAdd() {
        c = new Contact();
        c.add("abc");
        c.add("abcd");
        c.add("abcde");
    }

    @Test
    public void testFindContacts() {
        List<String> contacts = c.find("a");

        assertTrue(contacts.contains("abc"));
        assertTrue(contacts.contains("abcd"));
        assertTrue(contacts.contains("abcde"));

        contacts = c.find("abcde");
        assertTrue(contacts.contains("abcde"));
        assertEquals(1, contacts.size());
    }

    @Test
    public void testFindContactsNull() {
        List<String> contacts = c.find("fdsjfbsd");
        assertEquals(0, contacts.size());
    }

}

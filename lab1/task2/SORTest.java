package task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SORTest {

    @Test
    public void testAddPatient() {
        SOR queue = new SOR();

        queue.addPatient(new Patient("Emilia", 2));
        assertEquals("Emilia - priority: 2\n", queue.toString());

    }

    @Test
    public void testInvalidPriority() {
        SOR queue = new SOR();

        queue.addPatient(new Patient("Emilia", 0));
        queue.addPatient(new Patient("Arnold", 3));
        queue.addPatient(new Patient("Barbara", 9));
        assertEquals("Emilia - priority: 1\nArnold - priority: 3\nBarbara - priority: 4\n", queue.toString());
    }

    @Test
    public void testGetNextPatient() {
        SOR queue = new SOR();

        Patient Anna = new Patient("Anna", 2);
        Patient Janusz = new Patient("Bob", 1);
        Patient Basia = new Patient("Charlie", 3);

        queue.addPatient(Anna);
        queue.addPatient(Janusz);
        queue.addPatient(Basia);

        assertEquals(Janusz, queue.getNextPatient());
        assertEquals(Anna, queue.getNextPatient());
        assertEquals(Basia, queue.getNextPatient());
        assertNull(queue.getNextPatient());
    }

    @Test
    public void testGetSize() {
        SOR queue = new SOR();

        Patient Anna = new Patient("Anna", 2);
        Patient Janusz = new Patient("Bob", 1);
        Patient Basia = new Patient("Charlie", 3);

        queue.addPatient(Anna);
        queue.addPatient(Janusz);
        queue.addPatient(Basia);

        assertEquals(3, queue.getSize());
        queue.getNextPatient();
        assertEquals(2, queue.getSize());
        queue.getNextPatient();
        assertEquals(1, queue.getSize());
        queue.getNextPatient();
        assertEquals(0, queue.getSize());
        queue.getNextPatient();
        assertEquals(0, queue.getSize());
    }
}


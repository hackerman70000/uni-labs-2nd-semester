package task2;

public class Main {

    public static void main(String[] args) {
        SOR queue = new SOR();

        queue.addPatient(new Patient("Emilia", 2));
        queue.addPatient(new Patient("Patryk", 1));
        queue.addPatient(new Patient("Bartek", 3));
        queue.addPatient(new Patient("Anastazja", 1));
        queue.addPatient(new Patient("Janusz", 4));
        queue.addPatient(new Patient("Stanisław", 3));
        queue.addPatient(new Patient("Michał", 4));

        System.out.println(queue.toString());

        Patient nextPatient = queue.getNextPatient();
        System.out.println("Next patient: " + nextPatient.toString());
        System.out.println(queue.toString());
    }

}

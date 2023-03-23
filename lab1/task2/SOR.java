package task2;

import java.util.LinkedList;

public class SOR {

    private LinkedList<Patient> queue;

    public SOR() {
        queue = new LinkedList<>();
    }

    public void addPatient(Patient patient) {
        if (queue.isEmpty()) {
            queue.add(patient);
        } else {
            int index = 0;
            for (Patient p : queue) {
                if (patient.compareTo(p) < 0) {
                    queue.add(index, patient);
                    return;
                }
                index++;
            }
            queue.addLast(patient);
        }
    }

    public Patient getNextPatient() {
        return queue.poll();
    }

    public int getSize() {
        return queue.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Patient p : queue) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }

}


package task2;

public class Patient implements Comparable<Patient> {

    private String name;

    private int priority;

    public Patient(String name, int priority) {
        this.name = name;

        if (priority > 4) {
            priority = 4;
            System.out.println("Error : Invalid priority");
        }
        if (priority < 1) {
            priority = 1;
            System.out.println("Error : Invalid priority");
        }
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public int compareTo(Patient other) {
        if (this.priority != other.priority) {
            return this.priority - other.priority;
        } else {
            return 0;
        }
    }

    public boolean equals(Object other) {
        if (other instanceof Patient) {
            Patient p = (Patient) other;
            return this.name.equals(p.name) && this.priority == p.priority;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return name.hashCode() + priority;
    }

    public String toString() {
        return name + " - priority: " + priority;
    }

}


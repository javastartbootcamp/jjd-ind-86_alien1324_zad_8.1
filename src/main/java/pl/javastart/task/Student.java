package pl.javastart.task;

public class Student extends UniPerson {
    private int[] groups = new int[2];

    public Student(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    public void printInfo() {
        System.out.println(getId() + " " + getFirstName() + " " + getLastName());
    }
}

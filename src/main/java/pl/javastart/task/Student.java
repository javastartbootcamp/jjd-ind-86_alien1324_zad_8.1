package pl.javastart.task;

public class Student extends UniPerson {
    int[] groups = new int[2];

    public Student(int id, String firstName, String lastName, int[] groups) {
        super(id, firstName, lastName);
        this.groups = groups;
    }
}

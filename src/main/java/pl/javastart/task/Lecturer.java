package pl.javastart.task;

public class Lecturer extends UniPerson {
    private String degree;

    public Lecturer(int id, String degree, String firstName, String lastName) {
        super(id, firstName, lastName);
        this.degree = degree;
    }

    public void printInfo() {
        System.out.println(getDegree() + " " + getFirstName() + " " + getLastName());
    }

    public String getDegree() {
        return degree;
    }
}

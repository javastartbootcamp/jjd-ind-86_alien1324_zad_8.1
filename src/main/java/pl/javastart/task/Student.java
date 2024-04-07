package pl.javastart.task;

public class Student extends UniPerson {
    private Grade[] grades = new Grade[2];
    private int gradesIndex = 0;

    public Student(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    public void newGrade(Grade grade) {
        if (gradesIndex >= grades.length) {
            Grade[] newGrades = new Grade[grades.length * 2];
            System.arraycopy(grades, 0, newGrades, 0, grades.length);
            grades = newGrades;
        }
        grades[gradesIndex] = grade;
        gradesIndex++;
    }

    public boolean hasGrade(String groupCode) {
        for (int i = 0; i < gradesIndex; i++) {
            if (grades[i].getGroupCode() == groupCode) {
                return true;
            }
        }
        return false;
    }

    public void printInfo() {
        System.out.print(getId() + " " + getFirstName() + " " + getLastName());
    }

    public void printGrades() {
        for (int i = 0; i < gradesIndex; i++) {
            System.out.println(grades[i].getGroupName() + ": " + grades[i].getGrade());
        }
    }

    public void printGrade(String groupCode) {
        for (int i = 0; i < gradesIndex; i++) {
            if (grades[i].getGroupCode() == groupCode) {
                System.out.println(grades[i].getGrade());
            }
        }
    }
}

package pl.javastart.task;

public class Group {
    private String code;
    private String name;
    private Lecturer lecturer;
    private Student[] students = new Student[2];
    private int studentsIndex = 0;

    public Group(String code, String name, Lecturer lecturer) {
        this.code = code;
        this.name = name;
        this.lecturer = lecturer;
    }

    public void addStudent(Student student) {
        if (studentsIndex >= students.length) {
            Student[] newStudents = new Student[students.length * 2];
            System.arraycopy(newStudents, 0, students, 0, students.length);
            students = newStudents;
        }
        students[studentsIndex] = student;
        studentsIndex++;
    }

    public void printStudents() {
        for (int i = 0; i < studentsIndex; i++) {
            students[i].printInfo();
        }
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }
}

package pl.javastart.task;

public class UniversityDatabase {
    private Student[] students = new Student[2];
    private int studentsIndex = 0;
    private Lecturer[] lecturers = new Lecturer[2];
    private int lecturersIndex = 0;
    private Group[] groups = new Group[2];
    private int groupsIndex = 0;

    public void newGroup(Group group) {
        groups[groupsIndex] = group;
        groupsIndex++;
        if (groupsIndex >= groups.length) {
            Group[] newGroups = new Group[groups.length * 2];
            System.arraycopy(newGroups, 0, groups, 0, groups.length);
            groups = newGroups;
        }
    }

    public boolean groupExist(String code) {
        for (int i = 0; i < groupsIndex; i++) {
            if (groups[i].getCode() == code) {
                return true;
            }
        }
        return false;
    }

    public Group getGroup(String code) {
        for (int i = 0; i < groupsIndex; i++) {
            if (groups[i].getCode() == code) {
                return groups[i];
            }
        }
        return null;
    }

    public void newStudent(Student student) {
        if (studentsIndex >= students.length) {
            Student[] newStudents = new Student[students.length * 2];
            System.arraycopy(newStudents, 0, students, 0, students.length);
            students = newStudents;
        }
        students[studentsIndex] = student;
        studentsIndex++;
    }

    public boolean studendExist(int id) {
        for (int i = 0; i < studentsIndex; i++) {
            if (students[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

    public Student getStudent(int id) {
        for (int i = 0; i < studentsIndex; i++) {
            if (students[i].getId() == id) {
                return students[i];
            }
        }
        return null;
    }

    public void printStudents() {
        for (int i = 0; i < studentsIndex; i++) {
            students[i].printInfo();
        }
    }

    public void newLecturer(Lecturer lecturer) {
        if (lecturersIndex >= lecturers.length) {
            Lecturer[] newLecturers = new Lecturer[lecturers.length * 2];
            System.arraycopy(newLecturers, 0, lecturers, 0, lecturers.length);
            lecturers = newLecturers;
        }
        lecturers[lecturersIndex] = lecturer;
        lecturersIndex++;
    }

    public boolean lecturerExist(int id) {
        for (int i = 0; i < lecturersIndex; i++) {
            if (lecturers[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

    public Lecturer getLecturer(int id) {
        for (int i = 0; i < lecturersIndex; i++) {
            if (lecturers[i].getId() == id) {
                return lecturers[i];
            }
        }
        return null;
    }
}

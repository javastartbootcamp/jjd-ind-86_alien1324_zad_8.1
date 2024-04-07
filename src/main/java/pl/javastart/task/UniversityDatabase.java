package pl.javastart.task;

public class UniversityDatabase {
    Student[] students = new Student[2];
    int studentsIndex = 0;
    Lecturer[] lecturers = new Lecturer[2];
    int lecturersIndex = 0;
    Group[] groups = new Group[2];
    int groupsIndex = 0;

    void newGroup(Group g) {
        groups[groupsIndex] = g;
        groupsIndex++;
        if (groupsIndex >= groups.length) {
            Group[] newgroups = new Group[groups.length * 2];
            System.arraycopy(newgroups, 0, groups, 0, groups.length);
            groups = newgroups;
        }
    }

    boolean groupExist(String code) {
        for (int i = 0; i < groupsIndex; i++) {
            if (groups[i].getCode() == code) {
                return true;
            }
        }
        return false;
    }

    void newStudent(Student g) {
        students[studentsIndex] = g;
        studentsIndex++;
        if (studentsIndex >= students.length) {
            Student[] newstudents = new Student[students.length * 2];
            System.arraycopy(newstudents, 0, students, 0, students.length);
            students = newstudents;
        }
    }

    void newLecturer(Lecturer g) {
        lecturers[lecturersIndex] = g;
        lecturersIndex++;
        if (lecturersIndex >= lecturers.length) {
            Lecturer[] newlecturers = new Lecturer[lecturers.length * 2];
            System.arraycopy(newlecturers, 0, lecturers, 0, lecturers.length);
            lecturers = newlecturers;
        }
    }

    boolean lecturerExist(int id) {
        for (int i = 0; i < lecturersIndex; i++) {
            if (lecturers[i].getId() == id) {
                return true;
            }
        }
        return false;
    }
}

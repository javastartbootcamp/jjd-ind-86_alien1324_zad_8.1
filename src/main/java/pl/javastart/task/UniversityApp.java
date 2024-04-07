package pl.javastart.task;

public class UniversityApp {
    private UniversityDatabase uniData = new UniversityDatabase();
    /**
     * Tworzy prowadzącego zajęcia.
     * W przypadku gdy prowadzący z zadanym id już istnieje, wyświetlany jest komunikat:
     * "Prowadzący z id [id_prowadzacego] już istnieje"
     *
     * @param id        - unikalny identyfikator prowadzącego
     * @param degree    - stopień naukowy prowadzącego
     * @param firstName - imię prowadzącego
     * @param lastName  - nazwisko prowadzącego
     */

    public void createLecturer(int id, String degree, String firstName, String lastName) {
        if (uniData.lecturerExist(id)) {
            System.out.println("Prowadzący z id " + id + " już istnieje");
        } else {
            Lecturer lecturer = new Lecturer(id, degree, firstName, lastName);
            uniData.newLecturer(lecturer);
        }
    }

    /**
     * Tworzy grupę zajęciową.
     * W przypadku gdy grupa z zadanym kodem już istnieje, wyświetla się komunikat:
     * "Grupa [kod grupy] już istnieje"
     * W przypadku gdy prowadzący ze wskazanym id nie istnieje wyświetla się komunikat:
     * "Prowadzący o id [id prowadzacego] nie istnieje"
     *
     * @param code       - unikalny kod grupy
     * @param name       - nazwa przedmiotu (np. "Podstawy programowania")
     * @param lecturerId - identyfikator prowadzącego. Musi zostać wcześniej utworzony za pomocą metody {@link #createLecturer(int, String, String, String)}
     */
    public void createGroup(String code, String name, int lecturerId) {
        if (uniData.groupExist(code)) {
            System.out.println("Grupa " + code + " już istnieje");
        } else if (!uniData.lecturerExist(lecturerId)) {
            System.out.println("Prowadzący o id " + lecturerId + " nie istnieje");
        } else {
            Group group = new Group(code, name, uniData.getLecturer(lecturerId));
            uniData.newGroup(group);
        }
    }

    /**
     * Dodaje studenta do grupy zajęciowej.
     * W przypadku gdy grupa zajęciowa nie istnieje wyświetlany jest komunikat:
     * "Grupa [kod grupy] nie istnieje
     *
     * @param index     - unikalny numer indeksu studenta
     * @param groupCode - kod grupy utworzonej wcześniej za pomocą {@link #createGroup(String, String, int)}
     * @param firstName - imię studenta
     * @param lastName  - nazwisko studenta
     */
    public void addStudentToGroup(int index, String groupCode, String firstName, String lastName) {
        if (!uniData.groupExist(groupCode)) {
            System.out.println("Grupa " + groupCode + " nie istnieje");
        } else if (uniData.getGroup(groupCode).studentInGroup(index)) {
            System.out.println("Student o indeksie " + index + " jest już w grupie " + groupCode);
        } else {
            Student student;
            if (!uniData.studendExist(index)) {
                student = new Student(index, firstName, lastName);
                uniData.newStudent(student);
            } else {
                student = uniData.getStudent(index);
            }
            Group group = uniData.getGroup(groupCode);
            group.addStudent(student);
        }
    }

    /**
     * Wyświetla informacje o grupie w zadanym formacie.
     * Oczekiwany format:
     * Kod: [kod_grupy]
     * Nazwa: [nazwa przedmiotu]
     * Prowadzący: [stopień naukowy] [imię] [nazwisko]
     * Uczestnicy:
     * [nr indeksu] [imie] [nazwisko]
     * [nr indeksu] [imie] [nazwisko]
     * [nr indeksu] [imie] [nazwisko]
     * W przypadku gdy grupa nie istnieje, wyświetlany jest komunikat w postaci: "Grupa [kod] nie znaleziona"
     *
     * @param groupCode - kod grupy, dla której wyświetlić informacje
     */
    public void printGroupInfo(String groupCode) {
        if (!uniData.groupExist(groupCode)) {
            System.out.println("Grupa " + groupCode + " nie znaleziona");
        } else {
            Group group = uniData.getGroup(groupCode);
            System.out.println("Kod: " + group.getCode());
            System.out.println("Nazwa: " + group.getName());
            System.out.print("Prowadzący: ");
            group.getLecturer().printInfo();
            System.out.println("Uczestnicy:");
            group.printStudents();
        }

    }

    /**
     * Dodaje ocenę końcową dla wskazanego studenta i grupy.
     * Student musi być wcześniej zapisany do grupy za pomocą {@link #addStudentToGroup(int, String, String, String)}
     * W przypadku, gdy grupa o wskazanym kodzie nie istnieje, wyświetlany jest komunikat postaci:
     * "Grupa pp-2022 nie istnieje"
     * W przypadku gdy student nie jest zapisany do grupy, wyświetlany jest komunikat w
     * postaci: "Student o indeksie 179128 nie jest zapisany do grupy pp-2022"
     * W przypadku gdy ocena końcowa już istnieje, wyświetlany jest komunikat w postaci:
     * "Student o indeksie 179128 ma już wystawioną ocenę dla grupy pp-2022"
     *
     * @param studentIndex - numer indeksu studenta
     * @param groupCode    - kod grupy
     * @param grade        - ocena
     */
    public void addGrade(int studentIndex, String groupCode, double grade) {
        if (!uniData.groupExist(groupCode)) {
            System.out.println("Grupa " + groupCode + " nie istnieje");
        } else if (!uniData.getGroup(groupCode).studentInGroup(studentIndex)) {
            System.out.println("Student o indeksie " + studentIndex + " nie jest zapisany do grupy " + groupCode);
        } else if (uniData.getStudent(studentIndex).hasGrade(groupCode)) {
            System.out.println("Student o indeksie " + studentIndex + " ma już wystawioną ocenę dla grupy " + groupCode);
        } else {
            uniData.getStudent(studentIndex).newGrade(new Grade(grade, groupCode, uniData.getGroup(groupCode).getName()));
        }

    }

    /**
     * Wyświetla wszystkie oceny studenta.
     * Przykładowy wydruk:
     * Podstawy programowania: 5.0
     * Programowanie obiektowe: 5.5
     *
     * @param index - numer indesku studenta dla którego wyświetlić oceny
     */
    public void printGradesForStudent(int index) {
        if (!uniData.studendExist(index)) {
            System.out.println("Student o indeksie " + index + " nie istnieje");
        } else {
            uniData.getStudent(index).printGrades();
        }
    }

    /**
     * Wyświetla oceny studentów dla wskazanej grupy.
     * Przykładowy wydruk:
     * 179128 Marcin Abacki: 5.0
     * 179234 Dawid Donald: 4.5
     * 189521 Anna Kowalska: 5.5
     *
     * @param groupCode - kod grupy, dla której wyświetlić oceny
     */
    public void printGradesForGroup(String groupCode) {
        if (!uniData.groupExist(groupCode)) {
            System.out.println("Grupa " + groupCode + " nie istnieje");
        } else {
            uniData.getGroup(groupCode).printGrades();
        }
    }

    /**
     * Wyświetla wszystkich studentów. Każdy student powinien zostać wyświetlony tylko raz.
     * Każdy student drukowany jest w nowej linii w formacie [nr_indesku] [imie] [nazwisko]
     * Przykładowy wydruk:
     * 179128 Marcin Abacki
     * 179234 Dawid Donald
     * 189521 Anna Kowalska
     */
    public void printAllStudents() {
        uniData.printStudents();
    }
}

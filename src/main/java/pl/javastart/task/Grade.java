package pl.javastart.task;

public class Grade {
    private double grade;
    private String groupCode;
    private String groupName;

    public Grade(double grade, String groupCode, String groupName) {
        this.grade = grade;
        this.groupCode = groupCode;
        this.groupName = groupName;
    }

    public double getGrade() {
        return grade;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public String getGroupName() {
        return groupName;
    }
}

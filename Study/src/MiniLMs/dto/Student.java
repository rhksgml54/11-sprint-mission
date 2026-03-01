package MiniLMs.dto;

public class Student {
    private String ID;
    private String name;
    private int grade;
    private String major;
    private String gender;

    public Student(String ID, String name, int grade, String major, String gender) {
        this.ID = ID;
        this.name = name;
        this.grade = grade;
        this.major = major;
        this.gender = gender;
    }
}

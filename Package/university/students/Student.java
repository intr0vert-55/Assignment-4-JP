package university.students;

public class Student {
    private String studentId;
    private String name;
    private String dep;

    public Student(String studentId, String name, String dep) {
        this.studentId = studentId;
        this.name = name;
        this.dep = dep;
    }

    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getDep() { return dep; }
}

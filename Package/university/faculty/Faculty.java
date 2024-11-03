package university.faculty;

public class Faculty {
    private String facultyId;
    private String name;
    private String department;

    public Faculty(String facultyId, String name, String department) {
        this.facultyId = facultyId;
        this.name = name;
        this.department = department;
    }

    public String getFacultyId() { return facultyId; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
}

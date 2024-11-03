import university.students.Student;
import university.courses.Course;
import university.faculty.Faculty;

public class UniversityManagement {
    public static void main(String[] args) {
        Student student = new Student("S001", "Mukesh", "Computer Science");
        Course course = new Course("CS101", "Introduction to Programming", 4);
        Faculty faculty = new Faculty("F001", "Jeny Love", "Computer Science");

        System.out.println("Student: " + student.getName() + ", Major: " + student.getDep());
        System.out.println("Course: " + course.getCourseName() + ", Credits: " + course.getCredits());
        System.out.println("Faculty: " + faculty.getName() + ", Department: " + faculty.getDepartment());
    }
}

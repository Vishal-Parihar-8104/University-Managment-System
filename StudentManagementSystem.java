import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    // Add a new student
    public void addStudent(Student student) {
        students.add(student);
    }

    // Remove a student by ID
    public boolean removeStudent(int id) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    // Update student details
    public boolean updateStudent(int id, String name, String course, double grade) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(name);
                student.setCourse(course);
                student.setGrade(grade);
                return true;
            }
        }
        return false;
    }

    // Display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                student.displayDetails();
                System.out.println("----------------------------");
            }
        }
    }

    // Get all students
    public List<Student> getStudents() {
        return students;
    }
}

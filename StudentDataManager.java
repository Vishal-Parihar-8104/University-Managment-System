import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class StudentDataManager {

    // Save the students list to a file
    public static void saveStudents(List<Student> students, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
            System.out.println("Student data saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving student data: " + e.getMessage());
        }
    }

    // Load the students list from a file
    public static List<Student> loadStudents(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading student data: " + e.getMessage());
            return new ArrayList<>(); // Return an empty list if there is an error
        }
    }
}

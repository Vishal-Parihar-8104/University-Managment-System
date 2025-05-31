import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "students.dat";

    public static void main(String[] var0) {
        Scanner var1 = new Scanner(System.in);
        StudentManagementSystem var2 = new StudentManagementSystem();

        // Load students, or initialize to an empty list if the file doesn't exist
        var2.getStudents().addAll(StudentDataManager.loadStudents(FILE_NAME));

        while (true) {
            System.out.println("----- University Student Management System -----");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Update Student Details");
            System.out.println("5. Save and Exit");
            System.out.print("Enter your choice: ");
            int var3 = -1;

            // Input validation for menu choice
            while (!var1.hasNextInt()) {
                System.out.print("Please enter a valid integer for your choice: ");
                var1.next(); // discard invalid input
            }
            var3 = var1.nextInt();
            var1.nextLine(); // Consume the newline character

            switch (var3) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int var4 = var1.nextInt();
                    var1.nextLine(); // Consume the newline character
                    System.out.print("Enter Name: ");
                    String var5 = var1.nextLine();
                    System.out.print("Enter Course: ");
                    String var6 = var1.nextLine();

                    // Input validation for grade (double)
                    double var7 = -1;
                    while (true) {
                        System.out.print("Enter Grade: ");
                        if (var1.hasNextDouble()) {
                            var7 = var1.nextDouble();
                            break; // Exit loop if valid input is entered
                        } else {
                            System.out.println("Invalid input! Please enter a valid grade (numeric).");
                            var1.next(); // Discard invalid input
                        }
                    }

                    var2.addStudent(new Student(var4, var5, var6, var7));
                    break;
                case 2:
                    System.out.print("Enter Student ID to remove: ");
                    int var9 = var1.nextInt();
                    boolean var10 = var2.removeStudent(var9);
                    if (var10) {
                        System.out.println("Student removed successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    var2.displayAllStudents();
                    break;
                case 4:
                    System.out.print("Enter Student ID to update: ");
                    int var11 = var1.nextInt();
                    var1.nextLine(); // Consume the newline character
                    System.out.print("Enter New Name: ");
                    String var12 = var1.nextLine();
                    System.out.print("Enter New Course: ");
                    String var13 = var1.nextLine();

                    // Input validation for grade (double)
                    double var14 = -1;
                    while (true) {
                        System.out.print("Enter New Grade: ");
                        if (var1.hasNextDouble()) {
                            var14 = var1.nextDouble();
                            break; // Exit loop if valid input is entered
                        } else {
                            System.out.println("Invalid input! Please enter a valid grade (numeric).");
                            var1.next(); // Discard invalid input
                        }
                    }

                    boolean var16 = var2.updateStudent(var11, var12, var13, var14);
                    if (var16) {
                        System.out.println("Student updated successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    StudentDataManager.saveStudents(var2.getStudents(), FILE_NAME);
                    System.out.println("Changes saved. Exiting...");
                    var1.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

 
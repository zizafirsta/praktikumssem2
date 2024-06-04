import java.util.*;

public class Admin {
    static boolean loginAdmin = false;

    public static void addStudent() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = input.nextLine();
        System.out.print("Enter student NIM: ");
        String nim = input.next();

        if (nim.length() != 15 || !nim.matches("\\d+")) {
            System.out.println("Invalid NIM!");
            return;
        }

        input.nextLine();
        System.out.print("Enter student faculty: ");
        String faculty = input.nextLine();
        System.out.print("Enter student program: ");
        String program = input.nextLine();

        Main.dataStudent[Main.jumlahStudent] = new String[]{name, faculty, nim, program};
        Main.jumlahStudent++;

        System.out.println("Student successfully registered.");
    }

    public static void displayStudents() {
        if (Main.dataStudent.length != 0) {
            System.out.println("List of Registered Students: ");
            for (String[] student : Main.dataStudent) {
                if(student[0] != null) {
                    System.out.println("Name: " + student[0]);
                    System.out.println("Faculty: " + student[1]);
                    System.out.println("NIM: " + student[2]);
                    System.out.println("Program: " + student[3] + "\n");
                }
            }
        } else {
            System.out.println("There is no student registered.");
        }
    }
}

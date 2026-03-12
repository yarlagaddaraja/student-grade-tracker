import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GradeManager gm = new GradeManager();
        gm.loadFromFile();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nMENU");
            System.out.println("1 . Add student");
            System.out.println("2 . show report");
            System.out.println("3 . Exit");
            System.out.println("4 . Total students");
            System.out.println("5 . Search student");
            System.out.println("6 . Delete student");
            System.out.println("7 . Update student marks");
            System.out.println("8 . Sort students by marks");
            System.out.println("enter your choice:");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("enter the student name:");
                    String name = sc.nextLine();
                    System.out.println("enter the student marks:");
                    int marks = sc.nextInt();
                    gm.addStudent(name, marks);
                     System.out.print("Student added Successfully!");
                    break;
                case 2:
                    gm.displayReport();
                    break;
                case 3:
                    System.out.println("programme Exited");
                    sc.close();
                    System.exit(0);
                case 4:
                    System.out.println("Total stuents:" +gm.getTotalStudents());
                    break;
                case 5:
                   System.out.println("Search for student");
                   String searchname =sc.nextLine();
                   gm.searchstudent(searchname);
                   break;
                case 6:
                  System.out.println("Delete student by name");
                  String deletename=sc.nextLine();
                  gm.deleteStudent(deletename);
                  break;
                case 7:
                  System.out.println("Enter student name:");
                  String updateName = sc.nextLine();
                  System.out.println("Enter new marks:");
                  int newMarks = sc.nextInt();
                  sc.nextLine();
                  gm.updateStudentMarks(updateName, newMarks);
                  break;
                case 8:
                  gm.sortStudentsByMarks();
                  break;
                default:
                    System.out.println("Invalid choice. Try Again.");
            }
        }
    }
}
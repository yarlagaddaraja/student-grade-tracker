import java.util.ArrayList;
import java.io.*;

public class GradeManager {

    private final ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(String studentname, int studentgrade) {
        Student s = new Student(studentname, studentgrade);
        students.add(s);
        saveToFile();
    }

    public void findTopStudent() {

        if (students.isEmpty()) {
            System.out.println("There are no students");
            return;
        }

        Student topStudent = students.get(0);

        for (Student s : students) {
            if (s.getStudentgrade() > topStudent.getStudentgrade()) {
                topStudent = s;
            }
        }

        System.out.println("Top Student: " + topStudent.getStudentname()
                + " (" + topStudent.getStudentgrade() + ")");
    }

    public void calculateAverage() {

        if (students.isEmpty()) {
            System.out.println("There are no students");
            return;
        }

        int total = 0;

        for (Student s : students) {
            total += s.getStudentgrade();
        }

        int average = total / students.size();

        System.out.println("Average Grade: " + average);
    }

    public void findHighest() {

        if (students.isEmpty()) {
            System.out.println("No students available");
            return;
        }

        int highest = students.get(0).getStudentgrade();

        for (Student s : students) {
            if (s.getStudentgrade() > highest) {
                highest = s.getStudentgrade();
            }
        }

        System.out.println("Highest Grade: " + highest);
    }

    public void findLowest() {

        if (students.isEmpty()) {
            System.out.println("No students available");
            return;
        }

        int lowest = students.get(0).getStudentgrade();

        for (Student s : students) {
            if (s.getStudentgrade() < lowest) {
                lowest = s.getStudentgrade();
            }
        }

        System.out.println("Lowest Grade: " + lowest);
    }

    public int getTotalStudents() {
        return students.size();
    }

    public void searchstudent(String name) {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (Student s : students) {

            if (s.getStudentname().equalsIgnoreCase(name)) {

                System.out.println("Student found");
                System.out.println("Name: " + s.getStudentname());
                System.out.println("Marks: " + s.getStudentgrade());
                return;
            }
        }

        System.out.println("Student not found");
    }

    public void deleteStudent(String name) {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getStudentname().equalsIgnoreCase(name)) {

                students.remove(i);
                saveToFile();
                System.out.println("Student deleted successfully.");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public void updateStudentMarks(String name, int newMarks) {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (Student s : students) {

            if (s.getStudentname().equalsIgnoreCase(name)) {

                s.setStudentgrade(newMarks);
                saveToFile();
                System.out.println("Student marks updated successfully.");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public void sortStudentsByMarks() {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        students.sort((s1, s2) -> s2.getStudentgrade() - s1.getStudentgrade());

        System.out.println("Students sorted by marks (Highest to Lowest).");
    }

    // Save students to file
    public void saveToFile() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"))) {

            for (Student s : students) {

                writer.write(s.getStudentname() + "," + s.getStudentgrade());
                writer.newLine();
            }

        } catch (IOException e) {

            System.out.println("Error saving to file");
        }
    }

    // Load students from file
    public void loadFromFile() {

        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                String name = parts[0];
                int marks = Integer.parseInt(parts[1]);

                students.add(new Student(name, marks));
            }

        } catch (IOException e) {

            System.out.println("No previous student data found.");
        }
    }

    public void displayReport() {

        System.out.println("Student Report");
        System.out.println("--------------");

        for (Student s : students) {

            System.out.println(s.getStudentname() + " : " + s.getStudentgrade());
        }

        System.out.println();

        calculateAverage();
        findHighest();
        findLowest();
        System.out.println("Total students: " + getTotalStudents());
        findTopStudent();
    }
}
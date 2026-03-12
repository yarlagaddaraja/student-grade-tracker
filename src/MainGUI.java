import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainGUI {

    private final  static GradeManager gm = new GradeManager();
    private static JTextArea displayArea;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Grade Tracker");

        frame.setSize(500,400);
        frame.setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Student Name:");
        JTextField nameField = new JTextField(15);

        JLabel marksLabel = new JLabel("Marks:");
        JTextField marksField = new JTextField(5);

        JButton addButton = new JButton("Add Student");
        JButton reportButton = new JButton("Show Report");
        JButton searchButton = new JButton("Search Student");
        JButton deleteButton = new JButton("Delete Student");

        displayArea = new JTextArea(10,40);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(marksLabel);
        frame.add(marksField);

        frame.add(addButton);
        frame.add(reportButton);
        frame.add(searchButton);
        frame.add(deleteButton);

        frame.add(scrollPane);

        // ADD STUDENT
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = nameField.getText();
                int marks = Integer.parseInt(marksField.getText());

                gm.addStudent(name, marks);

                displayArea.setText("Student Added Successfully\n");

                nameField.setText("");
                marksField.setText("");
            }
        });

        // SHOW REPORT
        reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                displayArea.setText("Student Report\n");
                displayArea.append("---------------------\n");

                for(Student s : gm.getStudents()){
                    displayArea.append(s.getStudentname() + " : " + s.getStudentgrade() + "\n");
                }
            }
        });

        // SEARCH STUDENT
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = nameField.getText();

                for(Student s : gm.getStudents()){
                    if(s.getStudentname().equalsIgnoreCase(name)){
                        displayArea.setText("Student Found\n");
                        displayArea.append("Name: "+s.getStudentname()+"\n");
                        displayArea.append("Marks: "+s.getStudentgrade());
                        return;
                    }
                }

                displayArea.setText("Student not found");
            }
        });

        // DELETE STUDENT
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = nameField.getText();

                for(int i=0;i<gm.getStudents().size();i++){
                    if(gm.getStudents().get(i).getStudentname().equalsIgnoreCase(name)){
                        gm.getStudents().remove(i);
                        displayArea.setText("Student Deleted");
                        return;
                    }
                }

                displayArea.setText("Student not found");
            }
        });

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
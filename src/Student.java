public class Student {
    String studentname;
    int studentgrade;

    public Student(String studentname, int studentgrade) {
        this.studentname = studentname;
        this.studentgrade=studentgrade;
    }

    public String getStudentname() {
        return studentname;
    }

    public int getStudentgrade() {
        return studentgrade;
    }
    public void setStudentgrade(int studentgrade){
        this.studentgrade=studentgrade;
    }
}

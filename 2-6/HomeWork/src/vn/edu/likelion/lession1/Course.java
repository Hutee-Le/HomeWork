package vn.edu.likelion.lession1;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int courseId;
    private String courseName;
    private String mentorName;
    private int credit;
    private List<Student> students;

    public Course(){
        this.courseId = 0;
        this.courseName = "";
        this.mentorName = "";
        this.credit = 0;
        this.students = new ArrayList<>();
    }

    public Course(int courseId, String courseName, String mentorName, int credit) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.mentorName = mentorName;
        this.credit = credit;
        this.students = new ArrayList<>();
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void displayDetailCourse() {
        System.out.println("Course Id: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Mentor Name: " + mentorName);
        System.out.println("Credit: " + credit);
    }

    public void displayStudents() {
        System.out.println("Students registered in " + courseName + ":");
        for(Student student: students){
            student.displayStudent();
            System.out.println();
        }
    }
}

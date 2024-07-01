package vn.edu.likelion.lession2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private String className;
    private LocalDateTime startTime;
    private static final int MAX_SEATS = 10;
    private Teacher teacher;
    private List<Student> students;
    private List<Student> dropStudentList;

    public Classroom() {
    }

    public Classroom(String className, Teacher teacher) {
        this.className = className;
        this.teacher = teacher;
        this.students = new ArrayList<>();
        this.dropStudentList = new ArrayList<>();
    }

    public void registerStudent(Student student) {
        if (!isValidAge(student)) {
            System.out.println("Student " + student.getStudentName() + "age must between 18 and 20 years old).");
            return;
        }

        if (!hasAvailableSeats()) {
            System.out.println("Classroom is full. Cannot register.");
            return;
        }

        students.add(student);
        student.setClassroom(this);
        student.setRegisTime(LocalDateTime.now());
        System.out.println("Student " + student.getStudentName() + " registered successfully.");

        if (students.size() == MAX_SEATS) {
            startClass();
        }
    }

    private void startClass() {
        startTime = LocalDateTime.now();
        System.out.println("Class " + className + " has started at " + startTime);
    }

    private boolean isValidAge(Student student) {
        int age = Period.between(student.getDateOfBirth(), LocalDate.now()).getYears();
        return (age >= 18 && age <= 20);
    }

    private boolean hasAvailableSeats() {
        return students.size() < MAX_SEATS;
    }

    public void viewStudents() {
        for (Student student : students) {
            System.out.println("Student: " + student.getStudentName() + ", Date of Birth: " + student.getDateOfBirth() +
                    ", CCCD: " + student.getCccd());
        }
    }

    public void updateStudentInfo(Student student, String newName, String newCccd) {
        student.setStudentName(newName);
        student.setCccd(newCccd);
        System.out.println("Updated student successfully.");
    }

    public void addDropout(Student student) {
        students.remove(student);
        dropStudentList.add(student);
        student.setStudying(false);
        System.out.println("Student " + student.getStudentName() + " dropped out ");
    }

    public void viewStudentsByTeacher() {
        System.out.println("Students in " + teacher.getTeacherName() + "'s classes:");
        for (Classroom classroom : teacher.getClassrooms()) {
            for (Student student : classroom.getStudents()) {
                System.out.println("Student: " + student.getStudentName() + ", Date of Birth: " + student.getDateOfBirth() +
                        ", CCCD: " + student.getCccd());
            }
        }
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getDropStudentList() {
        return dropStudentList;
    }

    public void setDropStudentList(List<Student> dropStudentList) {
        this.dropStudentList = dropStudentList;
    }
}

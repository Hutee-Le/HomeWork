package vn.edu.likelion.lession2;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Student {
    private int studentId;
    private String studentName;
    private LocalDate dateOfBirth;
    private String cccd;
    private boolean isStudying = true;
    private Classroom classroom;
    private LocalDateTime regisTime;

    public Student() {}

    public Student(int studentId, String studentName, LocalDate dateOfBirth, String cccd) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
        this.cccd = cccd;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public boolean isStudying() {
        return isStudying;
    }

    public void setStudying(boolean studying) {
        isStudying = studying;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public LocalDateTime getRegisTime() {
        return regisTime;
    }

    public void setRegisTime(LocalDateTime regisTime) {
        this.regisTime = regisTime;
    }
}

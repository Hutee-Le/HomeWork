package vn.edu.likelion.lession2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Student {
    private String studentId;
    private String studentName;
    private LocalDate birthDate;
    private String cccd;
    private boolean isActive;
    private LocalDateTime regisTime;
    private String reasonDropOut;

    public Student() {}

    public Student(String studentName, LocalDate birthDate, String cccd) {
        this.studentId = null;
        this.studentName = studentName;
        this.birthDate = birthDate;
        this.cccd = cccd;
        this.isActive = true;
        this.regisTime = LocalDateTime.now();
        this.reasonDropOut = null;
    }

    // Getters and setters
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalDateTime getRegisTime() {
        return regisTime;
    }

    public void setRegisTime(LocalDateTime regisTime) {
        this.regisTime = regisTime;
    }

    public String getReasonDropOut() {
        return reasonDropOut;
    }

    public void setReasonDropOut(String reasonDropOut) {
        this.reasonDropOut = reasonDropOut;
    }

    // Method to drop out student
    public void dropOut(String reason) {
        this.isActive = false;
        this.reasonDropOut = reason;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", birthDate=" + birthDate +
                ", cccd='" + cccd + '\'' +
                ", isActive=" + isActive +
                ", regisTime=" + regisTime +
                ", reasonDropOut='" + reasonDropOut + '\'' +
                '}';
    }
}

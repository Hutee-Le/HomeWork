package vn.edu.likelion.lession2;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Teacher {
    private String teacherId;
    private String teacherName;
    private List<Classroom> classrooms;

    public Teacher() {}

    public Teacher(String teacherName) {
        this.teacherId = UUID.randomUUID().toString();
        this.teacherName = teacherName;
        this.classrooms = new ArrayList<>();
    }

    // Getters and setters
    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public List<Classroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(List<Classroom> classrooms) {
        this.classrooms = classrooms;
    }

    public void addClassroom(Classroom classroom) {
        this.classrooms.add(classroom);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", classrooms=" + classrooms +
                '}';
    }
}

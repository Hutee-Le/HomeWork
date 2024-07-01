package vn.edu.likelion.lession2;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private int teacherId;
    private String teacherName;
    private List<Classroom> classrooms;

    public Teacher() {}

    public Teacher(int teacherId, String teacherName) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.classrooms = new ArrayList<>();
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
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
}

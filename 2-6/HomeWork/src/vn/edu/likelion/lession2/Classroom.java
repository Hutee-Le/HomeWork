package vn.edu.likelion.lession2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Classroom {
    private String classId;
    private String className;
    private LocalDateTime startTime;
    private boolean isStart;
    private static final int MAX_SEATS = 10;
    private static final int MAX_TEACHER_COUNTER = 2;
    private List<Teacher> teachers;
    private List<Student> students;
    private List<Student> dropStudentList;

    public Classroom() {}

    public Classroom(String className, LocalDateTime startTime) {
        this.classId = UUID.randomUUID().toString();
        this.className = className;
        this.startTime = startTime;
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.dropStudentList = new ArrayList<>();
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
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

    public boolean isStart() {
        return isStart;
    }

    public void setStart(boolean start) {
        isStart = start;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
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

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void updateStudent(Student student) {
        // Implement logic to update student
    }

    public void dropOutStudent(Student student, String reason) {
        this.students.remove(student);
        student.setActive(false);
        student.setReasonDropOut(reason);
        this.dropStudentList.add(student);
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "classId='" + classId + '\'' +
                ", className='" + className + '\'' +
                ", startTime=" + startTime +
                ", isStart=" + isStart +
                ", teachers=" + teachers +
                ", students=" + students +
                ", dropStudentList=" + dropStudentList +
                '}';
    }
}

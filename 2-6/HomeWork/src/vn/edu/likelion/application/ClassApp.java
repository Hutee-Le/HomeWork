package vn.edu.likelion.application;

import vn.edu.likelion.lession2.Classroom;
import vn.edu.likelion.lession2.Student;
import vn.edu.likelion.lession2.Teacher;

import java.time.LocalDate;

public class ClassApp {
    public static void main(String[] args){
        Teacher teacher1 = new Teacher(1, "Minh Tue");
        Classroom class1 = new Classroom("Class 1", teacher1);
        teacher1.addClassroom(class1);

        Student student1 = new Student(1, "Thắng", LocalDate.of(2004, 5, 15), "CCCD001");
        Student student2 = new Student(2, "Nhựt", LocalDate.of(2005, 3, 20), "CCCD002");
        Student student3 = new Student(3, "Nguyên", LocalDate.of(2003, 7, 25), "CCCD003");
        Student student4 = new Student(4, "Hải", LocalDate.of(2005, 9, 10), "CCCD004");
        Student student5 = new Student(5, "Mai", LocalDate.of(2015, 10, 10), "CCCD005");

        class1.registerStudent(student1);
        class1.registerStudent(student2);
        class1.registerStudent(student3);
        class1.registerStudent(student4);
        class1.registerStudent(student5);

        System.out.println("\nStudents in " + class1.getClassName() + ":");
        class1.viewStudents();

        class1.updateStudentInfo(student2, "Lee Minh Nhựt", "CCCD002");
        System.out.println("\nUpdated student information:");
        class1.viewStudents();

        class1.addDropout(student3);
        System.out.println("\nAfter dropout:");
        class1.viewStudents();

        System.out.println("\nStudents of teacher " + teacher1.getTeacherName() + ":");
        class1.viewStudentsByTeacher();
    }
}

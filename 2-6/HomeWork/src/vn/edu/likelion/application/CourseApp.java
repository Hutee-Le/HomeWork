package vn.edu.likelion.application;

import vn.edu.likelion.lession1.Course;
import vn.edu.likelion.lession1.CourseOnline;
import vn.edu.likelion.lession1.Student;

public class CourseApp {
    public static void main(String[] args) {
        Course course = new Course(101, "Java Fundamentals", "Tuan", 3);
        CourseOnline courseOnline = new CourseOnline(101, "Python Fundamentals", "Tuan", 3, "Window Form App", 8);

        Student student1 = new Student(22014605, "Minh Nhựt", "nhut14605@gmail.com");
        Student student2 = new Student(21915746, "Hoàng Bảo", "bao15746@gmail.com");

        course.addStudent(student1);
        course.addStudent(student2);
        courseOnline.addStudent(student2);

        System.out.println("Course Detail: ");
        course.displayDetailCourse();
        System.out.println();

        System.out.println("Course Online Detail: ");
        course.displayDetailCourse();
        System.out.println();

        course.displayStudents();

        courseOnline.displayStudents();
    }
}

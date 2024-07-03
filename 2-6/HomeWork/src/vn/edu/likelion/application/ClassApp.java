package vn.edu.likelion.application;

import vn.edu.likelion.lession2.Classroom;
import vn.edu.likelion.lession2.Student;
import vn.edu.likelion.lession2.Teacher;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassApp {
    private static List<Classroom> classrooms = new ArrayList<>();
    private static List<Teacher> teachers = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initialize();

        int choice;
        do {
            displayMainMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    manageClassrooms();
                    break;
                case 2:
                    manageTeachers();
                    break;
                case 3:
                    manageStudents();
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void initialize() {
        // Khởi tạo dữ liệu mẫu
        Classroom classroom1 = new Classroom("Class 101", LocalDateTime.now());
        Classroom classroom2 = new Classroom("Class 102", LocalDateTime.now());
        classrooms.add(classroom1);
        classrooms.add(classroom2);

        Teacher teacher1 = new Teacher("Mr Tùng");
        teacher1.addClassroom(classroom1);
        Teacher teacher2 = new Teacher("Mrs Ngôn");
        teacher2.addClassroom(classroom2);
        teachers.add(teacher1);
        teachers.add(teacher2);
    }

    private static void displayMainMenu() {
        System.out.println("----- Hệ thống quản lý trường học -----");
        System.out.println("1. Quản lý lớp học");
        System.out.println("2. Quản lý giảng viên");
        System.out.println("3. Quản lý học sinh");
        System.out.println("0. Thoát");
        System.out.print("Nhập lựa chọn của bạn: ");
    }

    private static void manageClassrooms() {
        int choice;
        do {
            displayClassroomMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerStudent();
                    break;
                case 2:
                    updateStudentInfo();
                    break;
                case 3:
                    dropOutStudent();
                    break;
                case 4:
                    displayStudentsInClass();
                    break;
                case 5:
                    displayDropOutStudents();
                    break;
                case 0:
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 0);
    }

    private static void displayClassroomMenu() {
        System.out.println("----- Menu quản lý lớp học -----");
        System.out.println("1. Đăng ký học sinh vào lớp");
        System.out.println("2. Cập nhật thông tin học sinh");
        System.out.println("3. Học sinh bỏ học");
        System.out.println("4. Xem danh sách học sinh trong lớp");
        System.out.println("5. Xem danh sách học sinh bỏ học");
        System.out.println("0. Quay lại menu chính");
        System.out.print("Nhập lựa chọn của bạn: ");
    }

    private static void registerStudent() {
        System.out.print("Nhập tên học sinh: ");
        String studentName = scanner.nextLine();
        System.out.print("Nhập ngày sinh (yyyy-MM-dd): ");
        String birthDateStr = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(birthDateStr);
        System.out.print("Nhập số CCCD: ");
        String cccd = scanner.nextLine();

        Student newStudent = new Student(studentName, birthDate, cccd);
        Classroom selectedClassroom = selectClassroom();
        if (selectedClassroom != null) {
            selectedClassroom.addStudent(newStudent);
            System.out.println("Đã đăng ký học sinh vào lớp " + selectedClassroom.getClassName());
        } else {
            System.out.println("Lớp học không tồn tại.");
        }
    }

    private static void updateStudentInfo() {
        System.out.println("Cập nhật thông tin học sinh.");
    }

    private static void dropOutStudent() {
        System.out.println("Học sinh bỏ học.");
    }

    private static void displayStudentsInClass() {
        System.out.println("Xem danh sách học sinh trong lớp học.");
    }

    private static void displayDropOutStudents() {
        System.out.println("Xem danh sách học sinh bỏ học.");
    }

    private static Classroom selectClassroom() {
        System.out.print("Nhập tên lớp học: ");
        String className = scanner.nextLine();
        for (Classroom classroom : classrooms) {
            if (classroom.getClassName().equalsIgnoreCase(className)) {
                return classroom;
            }
        }
        return null;
    }

    private static void manageTeachers() {
        System.out.println("Quản lý giảng viên.");
    }

    private static void manageStudents() {
        System.out.println("Quản lý học sinh.");
    }
}

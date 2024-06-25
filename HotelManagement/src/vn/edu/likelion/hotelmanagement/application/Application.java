package vn.edu.likelion.hotelmanagement.application;

import vn.edu.likelion.hotelmanagement.models.Manager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Application {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * this method is print menu
     */
    public static void printMenu() {
        System.out.println("\n--- Quản Lý Đặt Phòng Khách Sạn ---");
        System.out.println("1. Xem danh sách phòng");
        System.out.println("2. Xem chi tiết phòng");
        System.out.println("3. Thêm phòng");
        System.out.println("4. Sửa phòng");
        System.out.println("5. Xoá phòng");
        System.out.println("6. Xem danh sách khách");
        System.out.println("7. Thêm khách hàng");
        System.out.println("8. Sửa thông tin khách hàng");
        System.out.println("9. Thoát");
        System.out.print("Vui lòng chọn: ");
    }

    /**
     * this method is check valid input number
     *
     * @param scanner
     * @return number from input
     */
    public static int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Lựa chọn không hợp lệ. Vui lòng chọn [1-9]: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static int getInputRoomNumber(Scanner scanner) {
        int roomNumber = 0;
        boolean valid = false;
        do {
            try {
                roomNumber = Integer.parseInt(scanner.nextLine().trim());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.print("Định dạng sai. Vui lòng nhập lại số phòng:");
            }
        } while (!valid);

        return roomNumber;
    }

    public static String getStringInput() {
        return scanner.nextLine().trim();
    }

    public static int getValidAgeInput() {
        int age = 0;
        boolean valid = false;
        do {
            try {
                age = Integer.parseInt(scanner.nextLine().trim());
                if (age >= 0) {
                    valid = true;
                } else {
                    System.out.print("Tuổi không thể âm. Vui lòng nhập lại tuổi: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Định dạng sai. Vui lòng nhập lại tuổi: ");
            }
        } while (!valid);

        return age;
    }

    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.initRoom();

        while (true) {
            printMenu();
            int choice = getIntInput(scanner);
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        manager.displayRooms();
                        break;
                    case 2:
                        System.out.print("Nhập ID phòng: ");
                        int roomID = getInputRoomNumber(scanner);
                        manager.displayRoomDetail(roomID);
                        break;
                    case 3:
                        System.out.print("Nhập tên phòng: ");
                        String roomName = getStringInput();
                        System.out.print("Nhập số phòng: ");
                        int roomNumber = getInputRoomNumber(scanner);
                        manager.addRoom(roomName, roomNumber);
                        break;
                    case 4:
                        System.out.print("Nhập ID phòng cần sửa: ");
                        int updateRoomID = getInputRoomNumber(scanner);
//                        scanner.nextLine();
                        System.out.print("Nhập tên phòng mới: ");
                        String newRoomName = getStringInput();
                        System.out.print("Nhập số phòng mới: ");
                        int newRoomNumber = getInputRoomNumber(scanner);
                        manager.updateRoom(updateRoomID, newRoomName, newRoomNumber);
                        break;
                    case 5:
                        System.out.print("Nhập ID phòng cần xoá: ");
                        int deleteRoomID = getInputRoomNumber(scanner);
                        manager.deleteRoom(deleteRoomID);
                        break;
                    case 6:
                        manager.displayCustomers();
                        break;

                    case 7:
                        System.out.print("Nhập tên khách hàng: ");
                        String customerName = getStringInput();
                        System.out.print("Nhập tuổi: ");
                        int age = getValidAgeInput();
                        System.out.print("Nhập ID phòng: ");
                        int customerRoomID = getInputRoomNumber(scanner);
                        manager.addCustomer(customerName, age, customerRoomID);
                        break;
                    case 8:
                        boolean valid = false;
                        System.out.print("Nhập id khách hàng: ");
                        int customerID = scanner.nextInt();
                        scanner.nextLine();

                        while (!valid) {
                            System.out.print("Nhập ngày trả phòng (yyyy-MM-dd HH:mm): ");
                            String checkOutDateStr = getStringInput();
                            try {
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                                LocalDateTime checkOutDate = LocalDateTime.parse(checkOutDateStr, formatter);
                                valid = true;
                                manager.updateCustomer(customerID, checkOutDate);
                            } catch (DateTimeParseException e) {
                                System.out.println("Định dạng ngày giờ không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd HH:mm.");
                            }
                        }
                        break;
                    case 9:
                        System.out.println("Thoát chương trình.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn [1-9]:");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

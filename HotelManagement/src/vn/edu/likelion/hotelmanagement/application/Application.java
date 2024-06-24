package vn.edu.likelion.hotelmanagement.application;

import vn.edu.likelion.hotelmanagement.models.Manager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Application {
    public static void printMenu(){
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


    public static void main(String[] args) {
        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice){
                    case 1:
                        manager.displayRooms();
                        break;
                    case 2:
                        System.out.print("Nhập ID phòng: ");
                        int roomID = scanner.nextInt();
                        manager.displayRoomDetail(roomID);
                        break;
                    case 3:
                        System.out.print("Nhập tên phòng: ");
                        String roomName = scanner.nextLine();
                        System.out.print("Nhập số phòng: ");
                        int roomNumber = scanner.nextInt();
                        manager.addRoom(roomName, roomNumber);
                        break;
                    case 4:
                        System.out.print("Nhập ID phòng cần sửa: ");
                        int updateRoomID = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nhập tên phòng mới: ");
                        String newRoomName = scanner.nextLine();
                        System.out.print("Nhập số phòng mới: ");
                        int newRoomNumber = scanner.nextInt();
                        manager.updateRoom(updateRoomID, newRoomName, newRoomNumber);
                        break;
                    case 5:
                        System.out.print("Nhập ID phòng cần xoá: ");
                        int deleteRoomID = scanner.nextInt();
                        manager.deleteRoom(deleteRoomID);
                        break;
                    case 6:
                        manager.displayCustomers();
                        break;

                    case 7:
                        System.out.print("Nhập tên khách hàng: ");
                        String customerName = scanner.nextLine();
                        System.out.print("Nhập tuổi: ");
                        int age = scanner.nextInt();
                        System.out.print("Nhập ID phòng: ");
                        int customerRoomID = scanner.nextInt();
                        manager.addCustomer(customerName, age, customerRoomID);
                        break;
                    case 8:
                        boolean valid = false;
                        System.out.print("Nhập tên khách hàng: ");
                        String updateCustomerName = scanner.nextLine();

                        while (!valid) {
                            System.out.print("Nhập ngày trả phòng (yyyy-MM-dd HH:mm): ");
                            String checkOutDateStr = scanner.nextLine();
                            try {
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                                LocalDateTime checkOutDate = LocalDateTime.parse(checkOutDateStr, formatter);
                                valid = true;
                                manager.updateCustomer(updateCustomerName, checkOutDate);
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
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }

            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

package vn.edu.likelion.hotelmanagement.models;

import vn.edu.likelion.hotelmanagement.interfaces.IManagement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Manager implements IManagement {
    private List<Room> rooms;
    private List<Customer> customers;
    private int nextRoomId = 1;

    public Manager() {
        rooms = new ArrayList<>();
        customers = new ArrayList<>();
    }

    /**
     *  this method is add room
     * @param roomName @{String}
     * @param roomNumber @{int}
     * return result of room
     */
    @Override
    public void addRoom(String roomName, int roomNumber){
        try {
            if(rooms.size() < 5) {
                Room room = new Room(nextRoomId++, roomName, roomNumber);
                rooms.add(room);
                System.out.println("Đã thêm phòng thành công.");
            } else {
                throw new Exception("Chỉ được tổ chức tối đa 5 phòng.");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateRoom(int roomID, String newRoomName, int newRoomNumber) {
        try {
            boolean found = false;
            for (Room room : rooms) {
                if (room.getRoomID() == roomID) {
                    room.setRoomName(newRoomName);
                    room.setRoomNumber(newRoomNumber);
                    found = true;
                    System.out.println("Đã cập nhật phòng thành công.");
                    break;
                }
            }
            if (!found) throw new Exception("Không tìm thấy phòng với ID: " + roomID);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteRoom(int roomID) {
        try {
            boolean removed = rooms.removeIf(room -> room.getRoomID() == roomID);
            if (removed) {
                System.out.println("Đã xoá phòng thành công.");
            } else {
                throw new Exception("Không tìm thấy phòng với ID: " + roomID);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void displayRooms() {
        System.out.printf("%-5s %-10s %-20s %-10s %-10s%n", "STT", "ID Phòng", "Tên Phòng", "Số Phòng", "Trạng Thái");
        int stt = 1;
        for (Room room : rooms) {
            System.out.printf("%-7d %-10d %-20s %-10d %-10s%n", stt++, room.getRoomID(), room.getRoomName(), room.getRoomNumber(), room.isBooked() ? "Đã đặt" : "Chưa đặt");
        }
    }

    @Override
    public void displayRoomDetail(int roomID) {
        try {
            boolean found = false;
            for (Room room : rooms) {
                if (room.getRoomID() == roomID) {
                    System.out.println("ID Phòng: " + room.getRoomID());
                    System.out.println("Tên Phòng: " + room.getRoomName());
                    System.out.println("Số Phòng: " + room.getRoomNumber());
                    if (room.isBooked()) {
                        Customer customer = room.getCustomer();
                        System.out.println("Khách đang đặt: " + customer.getCustomerName());
                        System.out.println("Ngày đặt: " + customer.getCheckInDate());
                    } else {
                        System.out.println("Phòng trống");
                    }
                    found = true;
                    break;
                }
            }
            if (!found) throw new Exception("Không tìm thấy phòng với ID: " + roomID);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addCustomer(String customerName, int age, int roomID){
        try {
            if(age < 18) {
                throw new Exception("Khách hàng phải trên 18 tuổi");
            }

            boolean roomFound = false;
            for (Room room : rooms) {
                if(room.getRoomID() == roomID){
                    roomFound = true;
                    if (!room.isBooked()) {
                        Customer customer = new Customer(customerName, age, LocalDateTime.now());
                        customers.add(customer);
                        room.bookRoom(customer);
                        System.out.println("Đã thêm khách hàng thành công.");
                    } else {
                        System.out.println("Phòng đã được đặt.");
                    }
                    break;
                }
            }

            if (!roomFound) {
                throw new Exception("Không tìm thấy phòng với ID: "+ roomID);
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void updateCustomer(String customerName, LocalDateTime checkOutDate) {
        try {
            boolean customerFound = false;
            for (Customer customer : customers) {
                if (customer.getCustomerName().equals(customerName)) {
                    customer.setCheckOutDate(checkOutDate);
                    for (Room room : rooms) {
                        if (room.getCustomer() != null && room.getCustomer().getCustomerName().equals(customerName)) {
                            room.freeRoom();
                        }
                    }
                    customerFound = true;
                    System.out.println("Đã cập nhật thông tin khách hàng thành công.");
                    break;
                }
            }
            if (!customerFound) {
                throw new Exception("Không tìm thấy khách hàng với tên: " + customerName);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayCustomers() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        System.out.printf("%-5s %-20s %-5s %-20s %-20s %-10s %-10s%n", "STT", "Tên Khách", "Tuổi", "Ngày Đặt", "Ngày Trả", "Tên Phòng", "Số Phòng");
        int stt = 1;

        for (Customer customer : customers) {
            String checkInDate = customer.getCheckInDate().format(formatter);
            String checkOutDate = (customer.getCheckOutDate() != null) ? customer.getCheckOutDate().format(formatter) : "Chưa trả";
            System.out.printf("%-5d %-20s %-5d %-20s %-20s %-10s %-10d%n", stt++, customer.getCustomerName(), customer.getAge(), checkInDate, checkOutDate, getRoomNameByCustomer(customer), getRoomNumberByCustomer(customer));
        }
    }

    private String getRoomNameByCustomer(Customer customer) {
        for (Room room : rooms) {
            if (room.getCustomer() != null && room.getCustomer().equals(customer)) {
                return room.getRoomName();
            }
        }
        return "";
    }

    private int getRoomNumberByCustomer(Customer customer) {
        for (Room room : rooms) {
            if (room.getCustomer() != null && room.getCustomer().equals(customer)) {
                return room.getRoomNumber();
            }
        }
        return -1;
    }
}

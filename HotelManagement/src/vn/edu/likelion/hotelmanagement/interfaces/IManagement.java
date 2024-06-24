package vn.edu.likelion.hotelmanagement.interfaces;

public interface IManagement {
    void addRoom(String roomName, int roomNumber);
    void updateRoom(int roomId, String newRoomName, int newRoomNumber);
    void deleteRoom(int roomID);
    void displayRooms();
    void displayRoomDetail(int roomID);
}

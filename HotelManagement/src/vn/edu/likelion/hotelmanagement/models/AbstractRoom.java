package vn.edu.likelion.hotelmanagement.models;

public abstract class AbstractRoom {
    private int roomID;
    private String roomName;
    private int roomNumber;
    private boolean isBooked;
    private Customer customer;

    // constructor
    public AbstractRoom(int roomID, String roomName, int roomNumber) {
        this.roomID = roomID;
        this.roomName = roomName;
        this.roomNumber = roomNumber;
        this.isBooked = false;
        this.customer = null;
    }

    // Getters and setters
    public int getRoomID() {
        return roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setRoomId(int roomID) {
        this.roomID = roomID;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void bookRoom(Customer customer) {
        this.isBooked = true;
        this.customer = customer;
    }

    public void freeRoom() {
        this.isBooked = false;
        this.customer = null;
    }
}

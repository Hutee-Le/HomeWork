package vn.edu.likelion.hotelmanagement.models;

import java.time.LocalDateTime;

public class Customer {
    private int customerID;
    private String customerName;
    private int age;
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;

    // constructor
    public Customer(int customerID,String customerName, int age, LocalDateTime checkInDate) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.age = age;
        this.checkInDate = checkInDate;
        this.checkOutDate = null;
    }

    // Getters and setters

    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getAge() {
        return age;
    }

    public LocalDateTime getCheckInDate() {
        return checkInDate;
    }

    public LocalDateTime getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDateTime checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbookingsystem;

/**
 *
 * @author user
 */
public class Booking {
    private static int count = 1;
    private int bookingID;
    private Customer customer;
    private String checkStartDate;
    private String checkEndDate;
    private Room room;

    public Booking(Customer customer, Room room ,String startDate, String endDate) {
        this.bookingID = count++;
        this.checkStartDate = startDate;
        this.checkEndDate = endDate;
        this.room = room;
        this.customer=customer;
    }

    public void displayInfo() {
        System.out.println("===== Booking Info =====");
        System.out.println("Booking ID: " + bookingID);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Room Type: " + room.getRoomType());
        System.out.println("Room ID: " + room.getRoomID());
        System.out.println("Start Date: " + checkStartDate);
        System.out.println("End Date: " + checkEndDate);
        
        
        
    }
    public int getBookingID() {
        return bookingID;
    }

    public Room getRoom() {
        return room;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getCheckStartDate() {
        return checkStartDate;
    }

    public String getCheckEndDate() {
        return checkEndDate;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hotelbookingsystem;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class HotelManager {
    /****** Data Fields ******/
    ArrayList<Room> roomList;
    ArrayList<Customer> customerList;
    ArrayList<Booking> bookingList;
    
    
    public HotelManager(){
        roomList = new ArrayList<>();
        customerList = new ArrayList<>();
        bookingList = new ArrayList<>();
    }
   public Booking makeReservation(Customer customer, Room room, String startDate, String endDate) {
    try {
        if (!room.IsAvailable()) {
            throw new Exception("The room is not available for the selected dates.");
        }

        Booking booking = new Booking(customer, room, startDate, endDate);
        bookingList.add(booking);
        room.setIsAvailable(false);
        System.out.println("Booking created for customer " + customer.getName());
        return booking;
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
    return null;
}
    public void cancelReservation(int bookingID){
            for(Booking b :bookingList){
                if(bookingID == b.getBookingID()){
                    bookingList.remove(b);
                    b.getRoom().setIsAvailable(true);
                    System.out.println("Booking ID [" + bookingID + "] has been cancelled.");
                    return;          
                }
                
            }
             System.out.println("No booking found with ID: " + bookingID);     
        }
    public void addRoom(Room room) {
        roomList.add(room);
        System.out.println("Room added: " + room.getRoomID());
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
        System.out.println("Customer added: " + customer.getName());
    }

 
public Room findRoomByID(int roomID) throws Exception {
    for (Room r : roomList) {
        if (r.getRoomID() == roomID) {
            return r;
        }
    }
    // If room is not found, throw the exception
    throw new Exception("Room with ID " + roomID + " not found.");
}

public Customer findCustomerByID(int customerID) throws Exception {
    for (Customer c : customerList) {
        if (c.getID() == customerID) return c;
    }
    // If function is not found throw the exception 
    throw new Exception("Customer with ID " + customerID + " not found.");
     
}

 
    public void listAvailableRooms() {
    for (Room r : roomList) {
        if (r.IsAvailable()) {
            r.displayInfo();
        }
    }
}

    public void listAllCustomers() {
        for (Customer c : customerList) {
            c.displayInfo();
        }
    }
    
    public void listBookings() {
        for (Booking b : bookingList) {
            b.displayInfo();
        }
        
    }
}

       

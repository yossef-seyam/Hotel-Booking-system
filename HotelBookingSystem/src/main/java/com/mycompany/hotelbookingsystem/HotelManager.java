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
    ArrayList<Room> roomList = new ArrayList<>();
    ArrayList<Customer> customerList = new ArrayList<>();
    ArrayList<Booking> bookingList = new ArrayList<>();
    //mo branch

    /****** Methods ******/
    void addRoom(String roomType, int roomNumber, double price){
        Room room = null ;
        switch(roomType){
            case "SingleRoom": room = new SingleRoom(price); break;
            case "DoubleRoom": room = new DoubleRoom(price); break;
            case "SuiteRoom": room = new SuiteRoom(price); break;
            default: System.out.println("Invalid Room Type");
            
            /*exception handling 
                user typed invalid room type 
                user typed other data type except string
            */
            return ;    
        }
        roomList.add(room);
    }
    void addCustomer(String customerName, String customerEmail){
        Customer customer = new Customer(customerName,customerEmail);
        customerList.add(customer);
    }
    void makeBooking(){
        Booking booking = new Booking();
        bookingList.add(booking);
    }
    void displayAllRooms(){
        for (Room room : roomList) {
            System.out.println(room + " ");
        }
    }
    void displayAllCustomers(){
        for (Customer customer : customerList) {
            System.out.println(customer + " ");
        }
    }
    void displayAllBookings(){
        for (Booking booking : bookingList) {
            System.out.println(booking + " ");
        }
    }
    void sortRooms_byPrice(){

    }
    
    
    public static void main(String[] args) {
        
        
        
        
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbookingsystem;

import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javafx.application.Application;
import static javafx.application.Application.launch;

/**
 *
 * @author user
 */
public class Main {

    Date date = new java.util.Date();
    static boolean end = true;

    public static void main(String[] args) {
        //Application.launch(GUIFrontEnd.FX.class, args);

        Scanner input = new Scanner(System.in);
        HotelManager Hotel = new HotelManager();

        Hotel.initializeRooms();

        System.out.println("=======================");
        System.out.println("Welcome to ELSONS Hotel");
        while (end) {
            System.out.println("=======================");
            System.out.println("Please select one of the options :");
            System.out.println("=======================");
            System.out.println("1) View available rooms");
            System.out.println("2) View room offers");
            System.out.println("3) book a room");
            System.out.println("4) view your booking details"); 
            System.out.println("5) cancel a reservation");
            System.out.println("6) Help guide");
            System.out.println("7) Exit");
            int choose = input.nextInt();//Exception
            switch (choose) {
                case 1:

                    Hotel.listAvailableRooms(0);

                    break;
                case 2:    ;//TO DO
                    break;
                case 3:
                    System.out.println("Please Enter your name, your Email:");
                    System.out.println("===================================");
                    System.out.println("Your Name:");
                    input.nextLine();
                    String name = input.nextLine();// string input with SPACES
                    System.out.println("Your Email:");
                    String Email = input.next();
                    System.out.println("Do you wish to continue?");
                    System.out.println("0) cancel");
                    System.out.println("1) continue");
                    int c = input.nextInt(); // Exception
                    if (c == 1) {
                        Customer customer = new Customer(name, Email);
                        String startDate = null;
                        String endDate = null;
                        Room room = null;
                        Hotel.addCustomer(customer);
                        System.out.println("Please Select the available room you want to book :");
                        System.out.println("=======================");
                        System.out.println("1) Single Room");
                        System.out.println("2) Double Room");
                        System.out.println("3) Suite Room");

                        choose = input.nextInt();// Exception
                        switch (choose) {
                            case 1:
                                Hotel.listAvailableRooms(1);
                                System.out.println("Please enter the room ID you want to book");
                                int ID = input.nextInt();
                                room = Hotel.findRoomByID(ID);// if entered unavailable room ID it continues the program?? should display not available
                                if(room.isAvailable == false){
                                    System.out.println("The room is unavailable! please choose another room");
                                    break;
                                }
                                
                                System.out.println("Enter start date (dd/MM/yyyy): ");
                                input.nextLine();
                                startDate = input.nextLine();
                                System.out.println("Enter end date (dd/MM/yyyy): ");
                                endDate = input.nextLine();
                                //Hotel.makeReservation(customer, room, startDate, endDate);
                                break;
                            case 2:
                                Hotel.listAvailableRooms(2);
                                System.out.println("Please enter the room ID you want to book");
                                ID = input.nextInt();
                                room = Hotel.findRoomByID(ID);
                                if(room.isAvailable == false){
                                    System.out.println("The room is unavailable! please choose another room");
                                    break;
                                }
                                System.out.println("Enter start date (dd/MM/yyyy): ");
                                input.nextLine();
                                startDate = input.nextLine();
                                System.out.println("Enter end date (dd/MM/yyyy): ");
                                endDate = input.nextLine();
                                //Hotel.makeReservation(customer, room, startDate, endDate);
                                break;
                            case 3:
                                Hotel.listAvailableRooms(3);
                                System.out.println("Please enter the room ID you want to book");
                                ID = input.nextInt();
                                room = Hotel.findRoomByID(ID);
                                if(room.isAvailable == false){
                                    System.out.println("The room is unavailable! please choose another room");
                                    break;
                                }
                                System.out.println("Enter start date (dd/MM/yyyy): ");
                                input.nextLine();
                                startDate = input.nextLine();
                                System.out.println("Enter end date (dd/MM/yyyy): ");
                                endDate = input.nextLine();
                                //Hotel.makeReservation(customer, room, startDate, endDate);
                                break;
                            default:
                                System.out.println("Invalid input! please try again");
                                break;
                        }
                        if(room.isAvailable == false){
                            break;
                        }
                        System.out.println("Please Select Payment method:");
                        System.out.println("1) Visa");
                        System.out.println("2) PayPal");

                        int payment = input.nextInt();
                        if (payment == 1) {
                            System.out.println("Enter your Credit Card Number: ");
                            System.out.println("===============================");
                            input.nextLine();
                            String visa = input.nextLine();

                        } else if (payment == 2) {
                            System.out.println("Enter your PayPal account: ");
                            System.out.println("===============================");
                            input.nextLine();
                            String paypal = input.nextLine();
                        } else {
                            System.out.println("Invalid Input");
                        }
                        
                        Hotel.makeReservation(customer, room, startDate, endDate); 
                        System.out.println("Reservation Confirmed!");
                        System.out.println("Customer: " + customer.getName());
                        break;
                    } else if (c == 0) {
                        break;
                    } else {
                        System.out.println("Invalid Input");
                    }
                case 4:
                    System.out.println("Enter your booking ID: ");
                    System.out.println("===============================");
                    int bookingID = input.nextInt();
                    Hotel.displayBookingByID(bookingID);//how to get booking ID
                    break;
                case 5:
                    System.out.println("Enter your booking ID to cancel:");
                    int bookingId = input.nextInt();
                    Hotel.cancelReservation(bookingId);//how to get booking ID
                    break;
                case 6:
                    
                    break;
                case 7:
                    System.out.println("Thank you for choosing ELSONS Hotel. Goodbye!");
                    end = false;
                    break;
                default:
                    System.out.println("Invalid Input! Please, Try again");
                    break;
            }
        }

    }

}

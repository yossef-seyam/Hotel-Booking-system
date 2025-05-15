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

    //Date date = new java.util.Date();
    static boolean end = true;
    static int isFirst = 0;
    public static void main(String[] args) {
        Application.launch(GUIFrontEnd.FX.class, args);

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
                case 2:
                    /*
                    System.out.println("Do you have a promo code? (yes/no):");
                    input.nextLine(); // Clear buffer
                    String answer = input.nextLine().toLowerCase();
                    
                    if (answer.equals("yes")) {
                        System.out.println("Please enter your promo code:");
                        String promoCode = input.nextLine();
                        
                        if (promoCode.equals("seyam1")) {
                            Hotel.applyDiscount(promoCode);
                            System.out.println("\nDiscount has been applied successfully!");
                            System.out.println("20% discount has been applied to all room prices.");
                            System.out.println("\nUpdated room prices:");
                            Hotel.listAvailableRooms(0);
                        } else {
                            System.out.println("Invalid promo code. Please try again.");
                        }
                    } else if (answer.equals("no")) {
                        System.out.println("No problem! You can continue booking at regular prices.");
                    } else {
                        System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                    }
                     */
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
                                room = Hotel.findRoomByID(ID);
                                if (room.isAvailable == false) {
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
                                if (room.isAvailable == false) {
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
                                if (room.isAvailable == false) {
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
                        if (room.isAvailable == false) {
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
                        System.out.println("Do you have a promo code? (yes/no):");
                        //input.nextLine(); // Clear buffer
                        String answer = input.nextLine().toLowerCase();

                        if (answer.equals("yes")) {
                            System.out.println("Please enter your promo code:");
                            String promoCode = input.nextLine();
                            Hotel.applyDiscount(promoCode, room.roomID);

                            
                        } else if (answer.equals("no")) {
                            System.out.println("No problem! You can continue booking at regular prices.");
                        } else {
                            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                        }
                        Hotel.makeReservation(customer, room, startDate, endDate);
                        System.out.println("Reservation Confirmed!");
                        //System.out.println("Customer: " + customer.getName());
                        isFirst++;
                        break;
                    } else if (c == 0) {
                        break;
                    } else {
                        System.out.println("Invalid Input");
                    }
                case 4:
                    if(isFirst == 0){
                        System.out.println("No bookings have been done yet");
                        break;
                    }
                    else{
                        System.out.println("Enter your booking ID: ");
                        System.out.println("===============================");
                        int bookingID = input.nextInt();
                        Hotel.displayBookingByID(bookingID);//how to get booking ID
                        break;
                    }
                case 5:
                    if(isFirst == 0){
                        System.out.println("No bookings have been done yet");
                        break;
                    }
                    else{
                        System.out.println("Enter your booking ID to cancel:");
                        int bookingId = input.nextInt();
                        Hotel.cancelReservation(bookingId);//how to get booking ID
                        break;
                        
                    }
                case 6:
                    System.out.println("\n=========================");
                    System.out.println("       HELP GUIDE        ");
                    System.out.println("=========================");
                    System.out.println("\n1. View Available Rooms:");
                    System.out.println("   - Shows all currently available rooms");
                    System.out.println("   - Displays room types (Single, Double, Suite)");
                    System.out.println("   - Shows prices and room details");

                    System.out.println("\n2. View Room Offers:");
                    System.out.println("   - Check current promotions and discounts");
                    System.out.println("   - Special seasonal offers");
                    System.out.println("   - Package deals");

                    System.out.println("\n3. Book a Room:");
                    System.out.println("   - Make a new reservation");
                    System.out.println("   - Enter personal details");
                    System.out.println("   - Choose room type and dates");
                    System.out.println("   - Select payment method");

                    System.out.println("\n4. View Booking Details:");
                    System.out.println("   - Check your existing reservation");
                    System.out.println("   - View booking dates and room info");
                    System.out.println("   - Use your booking ID to view details");

                    System.out.println("\n5. Cancel Reservation:");
                    System.out.println("   - Cancel an existing booking");
                    System.out.println("   - Requires your booking ID");

                    System.out.println("\n=========================");
                    System.out.println("    CONTACT INFORMATION   ");
                    System.out.println("=========================");
                    System.out.println("Phone: +20-1093070195");
                    System.out.println("Email: support@elsonshotel.com");
                    System.out.println("Address: 103 10th of Ramadan, AlSharqia");
                    System.out.println("Website: www.elsonshotel.com");
                    System.out.println("Available 24/7 for assistance");
                    System.out.println("=========================\n");
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.hotelbookingsystem;

import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author user
 */
import java.util.ArrayList;

public class HotelManager {

    static private ArrayList<Room> roomList;
    private ArrayList<Customer> customerList;
    private ArrayList<Booking> bookingList;

    public HotelManager() {
        roomList = new ArrayList<>();
        customerList = new ArrayList<>();
        bookingList = new ArrayList<>();
    }

    // دالة لتجهيز الغرف الجاهزة
    public void initializeRooms() {
        // إضافة 10 غرف Single
        for (int i = 1; i <= 10; i++) {
            addRoom(new SingleRoom(false, "Single Room", 100.0, 100 + i)); // السعر 100
        }
        // إضافة 10 غرف Double
        for (int i = 1; i <= 10; i++) {
            addRoom(new DoubleRoom(true, "Double Room", 150.0, 200 + i)); // السعر 150
        }
        // إضافة 5 أجنحة Suite
        for (int i = 1; i <= 5; i++) {
            addRoom(new SuiteRoom("Suite Room", 300.0, 300 + i)); // السعر 300
        }
    }

    // إضافة غرفة إلى القائمة
    public void addRoom(Room room) {
        roomList.add(room);
        //System.out.println("Room added: " + room.getRoomID());
    }

    // حجز غرفة لعميل
    public Booking makeReservation(Customer customer, Room room, String startDate, String endDate) {
        if (room.IsAvailable()) {
            Booking booking = new Booking(customer, room, startDate, endDate);
            bookingList.add(booking);
            addCustomer(customer);
            room.setIsAvailable(false); // تغيير حالة الغرفة إلى غير متاحة
            System.out.println("Booking created for customer " + customer.getName());
            System.out.println("your booking ID " + booking.getBookingID());
            return booking;
        } else {
            System.out.println("Room is not available.");
            return null;
        }
    }

    // إلغاء الحجز باستخدام ID
    public void cancelReservation(int bookingID) {
        for (Booking b : bookingList) {
            if (bookingID == b.getBookingID()) {
                bookingList.remove(b);
                customerList.remove(b.getCustomer());
                b.getRoom().setIsAvailable(true); // إعادة الغرفة لتكون متاحة
                System.out.println("Booking ID [" + bookingID + "] has been cancelled.");
                return;
            }
        }
        System.out.println("No booking found with ID: " + bookingID);
    }

    // عرض الغرف المتاحة
    public void listAvailableRooms(int select) {
        switch (select) {
            case 0:
                // Single Rooms
                System.out.println("=======");
                System.out.println("Single rooms");
                System.out.println("=======");
                for (Room r : roomList) {
                    if (r.IsAvailable() && r instanceof SingleRoom) {
                        System.out.println(r.displayInfo());
                    }
                }

                // Double Rooms
                System.out.println("\n=======");
                System.out.println("Double rooms");
                System.out.println("=======");
                for (Room r : roomList) {
                    if (r.IsAvailable() && r instanceof DoubleRoom) {
                        System.out.println(r.displayInfo());
                    }
                }

                // Suite Rooms
                System.out.println("\n=======");
                System.out.println("Suite rooms");
                System.out.println("=======");
                for (Room r : roomList) {
                    if (r.IsAvailable() && r instanceof SuiteRoom) {
                        System.out.println(r.displayInfo());
                    }
                }
                break;
            case 1:
                for (Room r : roomList) {
                    if (r.IsAvailable() && r instanceof SingleRoom) {

                        System.out.println(r.displayInfo()); // استدعاء displayInfo() لكل غرفة
                    }
                }
                break;
            case 2:
                for (Room r : roomList) {
                    if (r.IsAvailable() && r instanceof DoubleRoom) {

                        System.out.println(r.displayInfo()); // استدعاء displayInfo() لكل غرفة
                    }
                }
                break;
            case 3:
                for (Room r : roomList) {
                    if (r.IsAvailable() && r instanceof SuiteRoom) {

                        System.out.println(r.displayInfo()); // استدعاء displayInfo() لكل غرفة
                    }
                }
                break;

        }

    }

    // عرض جميع العملاء
    public void listAllCustomers() {
        for (Customer c : customerList) {
            c.displayInfo();
        }
    }

    // عرض جميع الحجوزات
    public void listBookings() {
        for (Booking b : bookingList) {
            b.displayInfo();
        }
    }

    public void displayBookingByID(int bookingID) {
        for (Booking b : bookingList) {
            if (bookingID == b.getBookingID()) {
                b.displayInfo();
                return;
            }
        }
        System.out.println("No booking found with ID: " + bookingID);
    }

    // العثور على غرفة باستخدام RoomID
    public Room findRoomByID(int roomID) {
        for (Room r : roomList) {
            if (r.getRoomID() == roomID) {
                return r;
            }
        }
        return null;
    }

    // العثور على عميل باستخدام ID
    public Customer findCustomerByID(int customerID) {
        for (Customer c : customerList) {
            if (c.getID() == customerID) {
                return c;
            }
        }
        return null;
    }

    // إضافة عميل إلى القائمة
    public void addCustomer(Customer customer) {
        customerList.add(customer);
        System.out.println("Customer added: " + customer.getName());

    }

    public void applyDiscount(String promoCode, int roomID) {
        if (promoCode.equals("seyam1")) {
            System.out.println("\nDiscount has been applied successfully!");
            System.out.println("Applying 20% discount on your booked room.");
            for (Room room : roomList) {
                if (roomID == room.getRoomID()) {
                    double originalPrice = room.getPrice();
                    double discountedPrice = originalPrice * 0.8;
                    room.setPrice(discountedPrice);
                    System.out.println("New price for room " + room.getRoomID() + ": " + discountedPrice);
                }

            }
        } else {
            System.out.println("Invalid promo code.");
        }
    }

    public String getAvailableRoomsText() {
        StringBuilder sb = new StringBuilder();
        for (Room room : roomList) {
            if (room.isAvailable) {
                sb.append(room.toString()).append("\n");
            }
        }
        return sb.toString();
    }

    public String getBookingDetailsByID(int bookingID) {
        for (Booking booking : bookingList) { // assuming you have a list called bookings
            if (booking.getBookingID() == bookingID) {
                return booking.toString(); // or a custom formatted string
            }
        }
        return "No booking found with ID: " + bookingID;
    }

    public ArrayList<Booking> getBookingList() {
        return bookingList;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public ArrayList<Room> getRoomList() {
        return roomList;
    }

}

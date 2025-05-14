/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbookingsystem;

/**
 *
 * @author lenovo
 */
public class TransportService implements Services {
   private double pricePerRide;
    private String description;

    public TransportService(double pricePerRide) {
        this.pricePerRide = pricePerRide;
        this.description = "Transport service to and from the airport or nearby attractions.";
    }

    @Override
    public void requestService(Customer customer, Room room) {
        System.out.println(customer.getName() + " has requested a transport service for room " + room.getRoomID());
    }

    @Override
    public double getPrice() {
        return pricePerRide; // This could vary based on distance or type of vehicle
    }

    @Override
    public String getServiceDescription() {
        return description;
    }
    
}
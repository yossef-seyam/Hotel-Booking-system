/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbookingsystem;

/**
 *
 * @author user
 */
public class Customer {
    private static int nextID = 1010;  // Static counter for generating unique IDs
    private final int customerID;      // Instance field to store each customer's unique ID
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.customerID = ++nextID;    // Assign and increment the ID
        this.name = name;
        this.email = email;
    }

    public void requestService(String serviceType) {
        System.out.println("Customer [" + name + "] requested service: " + serviceType);
    }

    public void displayInfo() {
        System.out.println("Customer ID: " + customerID);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return customerID;
    }

    public String getEmail() {
        return email;
    }
}
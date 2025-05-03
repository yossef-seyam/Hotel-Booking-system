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
    private int ID;
    private String name;
    private String email;

    public Customer(int ID, String name, String email) {
        this.ID = ID;
        this.name = name;
        this.email = email;
    }

    public void requestService(String serviceType) {
        System.out.println("Customer [" + name + "] requested service: " + serviceType);
    }

    public void displayInfo() {
        System.out.println("Customer ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public String getEmail() {
        return email;
    }
}
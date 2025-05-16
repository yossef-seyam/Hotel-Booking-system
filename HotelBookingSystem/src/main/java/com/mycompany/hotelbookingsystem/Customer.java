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
    private static int ID = 1010;
    private String name;
    private String email;

    public Customer(String name, String email) {
        ID ++;  //ID removed
        this.name = name;
        this.email = email;
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
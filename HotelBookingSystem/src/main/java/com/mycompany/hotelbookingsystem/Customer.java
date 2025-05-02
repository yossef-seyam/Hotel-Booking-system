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
    /****** Data Fields ******/
    static int customerID;
    String customerName;
    String customerEmail;
    
    /****** Constructor ******/
    public Customer(String customerName, String customerEmail){
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        customerID++;
    }

    /****** Methods ******/
    void displayInfo() {
        System.out.println(" Customer Name : " + customerName);
        System.out.println(" Customer Email : "+ customerEmail);
        System.out.println(" Customer ID : " + customerID);
    }
}

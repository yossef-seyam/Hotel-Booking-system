/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.hotelbookingsystem;

/**
 *
 * @author user
 */
public interface Services {
    public void requestService(Customer customer, Room room);
    public double getPrice();
    public String getServiceDescription();
            
}

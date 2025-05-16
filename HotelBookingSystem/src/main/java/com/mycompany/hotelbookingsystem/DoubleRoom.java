/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbookingsystem;

/**
 *
 * @author dell
 */
public class DoubleRoom extends Room 
{
 
 private boolean hasBalcony;

    public DoubleRoom(boolean hasBalcony, String roomType ,double price,int roomID) {
        super(roomType,price,roomID);
        this.hasBalcony = hasBalcony;
    }

    public boolean hasBalcony() {
        return hasBalcony;
    }

    public void sethasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }
    
    @Override
    public String displayInfo()
    {
    return "Room Type:" + roomType + " it's Price:" + price + " The Room Id:" + roomID +"hasBalcony:" + hasBalcony ;
    
    }
 
}



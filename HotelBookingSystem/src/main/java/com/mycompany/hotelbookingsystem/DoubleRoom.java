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
 
 private boolean SeaView;

    public DoubleRoom(boolean SeaView, String roomType ,double price,int roomID) {
        super(roomType,price,roomID);
        this.SeaView = SeaView;
    }

    public boolean isSeaView() {
        return SeaView;
    }

    public void setSeaView(boolean SeaView) {
        this.SeaView = SeaView;
    }
    
    @Override
    public String displayInfo()
    {
    return "Room Type:" + roomType + " it's Price:" + price + " The Room Id:" + roomID ;
    
    }
 
}



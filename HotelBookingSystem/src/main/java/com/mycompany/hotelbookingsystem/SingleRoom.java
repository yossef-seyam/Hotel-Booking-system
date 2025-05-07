/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbookingsystem;

/**
 *
 * @author dell
 */
public class SingleRoom extends Room 
{
 
 private boolean SeaView;

    public SingleRoom(boolean SeaView, double price, String RoomType, int RoomID) {
        super(price, RoomType, RoomID);
        this.SeaView = SeaView;
    }

    public boolean isSeaView() {
        return SeaView;
    }

    public void setSeaView(boolean SeaView) {
        this.SeaView = SeaView;
    }

   
    
    public String displayInfo()
    {
    return "Room Type:" + roomType + " it's Price:" + price + " The Room Id:" + roomID ;
    
    }
    
 
 
 }

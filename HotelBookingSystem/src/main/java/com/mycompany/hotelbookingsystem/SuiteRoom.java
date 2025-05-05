/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbookingsystem;

/**
 *
 * @author dell
 */
public class SuiteRoom extends Room{
   private boolean SeaView;

    public SuiteRoom(double price, String roomType, int roomID) {
        super(price, roomType, roomID);
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

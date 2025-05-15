/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbookingsystem;

/**
 *
 * @author dell
 */
public class SuiteRoom extends Room implements Services {

    private boolean SeaView;

    public SuiteRoom(String roomType, double price, int roomID) {
        super(roomType, price, roomID);

    }

    public boolean isSeaView() {
        return SeaView;
    }

    public void setSeaView(boolean SeaView) {
        this.SeaView = SeaView;
    }

    @Override
    public String displayInfo() {
        return "Room Type:" + roomType + " it's Price:" + price + " The Room Id:" + roomID;

    }

    @Override
    public void orderService(String serviceType) {
        System.out.println("Suite room ordered service: " + serviceType);
    }

    @Override
    public double getServiceCost(String serviceType) {
        switch (serviceType.toLowerCase()) {
            case "cleaning":
                return 100.0;
            case "laundry":
                return 75.0;
            case "food":
                return 120.0;
            default:
                System.out.println("Unknown service type.");
                return 0.0;
        }
    }
}

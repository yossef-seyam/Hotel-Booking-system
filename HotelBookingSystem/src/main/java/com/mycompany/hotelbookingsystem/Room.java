/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbookingsystem;

/**
 *
 * @author user
 */
public abstract class Room {
    
    /****** Data Fields ******/
    protected double price;
    protected String roomType; // ايه لازمته مش فاهم
    protected static int roomID;
    protected boolean isAvailable ;
    /****** Constructor ******/
    
    Room(double price){
        this.price = price;
    }
    
    /****** Methods ******/
    abstract void displayInfo();
    
    
    
}
class SingleRoom extends Room{
    
    /****** Data Fields ******/
    
    
    /****** Constructor ******/
    
    SingleRoom(double price){
        super(price);
        super.roomType = "Single Room";
        isAvailable = true;
        roomID++;
    }
    
    
    /****** Methods ******/
    @Override
    void displayInfo(){
        System.out.println(" Room type : Single Room ");
        System.out.println(" Room price : 100$ ");
        System.out.println(" Room ID : " + roomID);
        
    }
    @Override
    public String toString() {
    return "Room type : " + super.roomType + ", Price : $" + price ;
    }
    
}
class DoubleRoom extends Room{
    /****** Data Fields ******/
    
    /****** Constructor ******/
    public DoubleRoom(double price){
        super(price);
        super.roomType = "Double Room";
        isAvailable = true;
        roomID++;
        
    }

    /****** Methods ******/
    @Override
            void displayInfo() {
                System.out.println(" Room type : Double Room ");
                System.out.println(" Room price : 200$ ");
                System.out.println(" Room ID : " + roomID);
    }
    @Override
    public String toString() {
    return "Room type : " + super.roomType + ", Price : $" + price ;
    }
}
    
    
class SuiteRoom extends Room{
    /****** Data Fields ******/
    
    /****** Constructor ******/
    
    SuiteRoom(double price){
        super(price);
        super.roomType = "Suite Room";
        isAvailable = true;
        roomID++;
    }
    
    
    
    /****** Methods ******/
    @Override
    void displayInfo(){
        System.out.println(" Room type : Suite Room ");
        System.out.println(" Room price : 500$ ");
        System.out.println(" Room ID : " + roomID);
    }
    @Override
    public String toString() {
    return "Room type : " + super.roomType + ", Price : $" + price ;
    }
}
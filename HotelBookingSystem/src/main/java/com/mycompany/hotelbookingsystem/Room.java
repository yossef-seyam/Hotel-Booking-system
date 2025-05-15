/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelbookingsystem;

/**
 *
 * @author user
 */
public abstract class Room  {
 protected double price;
 protected String roomType;
 protected int roomID;
 public boolean isAvailable;

 public Room(String roomType,double price , int roomID) {
     
     this.roomType = roomType;
     this.roomID = roomID;
     this.price = price;
     
     this.isAvailable = true;
 }

 public double getPrice() {
     return price;
 }

 public String getRoomType() {
     return roomType;
 }

 public int getRoomID() {
     return roomID;
 }

 public boolean IsAvailable() {
     return isAvailable;
 }

 // Setters
 public void setPrice(double price) {
     this.price = price;
 }

 public void setRoomType(String roomType) {
     this.roomType = roomType;
 }

 public void setRoomID(int roomID) {
     this.roomID = roomID;
 }

 public void setIsAvailable(boolean isAvailable) {
     this.isAvailable = isAvailable;
 }

 // Abstract method
 public abstract String displayInfo();
    
}
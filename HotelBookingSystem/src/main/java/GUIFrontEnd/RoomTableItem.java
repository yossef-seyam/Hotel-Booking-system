/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIFrontEnd;

import com.mycompany.hotelbookingsystem.*;
import javafx.beans.property.*;

public class RoomTableItem {
    private final SimpleStringProperty roomType;
    private final SimpleDoubleProperty price;
    private final SimpleIntegerProperty roomID;

    private final SimpleStringProperty seaView;
    private final SimpleStringProperty hasBalcony;
    private final SimpleStringProperty hasLivingRoom;

    public RoomTableItem(Room room) {
        this.roomType = new SimpleStringProperty(room.getRoomType());
        this.price = new SimpleDoubleProperty(room.getPrice());
        this.roomID = new SimpleIntegerProperty(room.getRoomID());

        if (room instanceof SingleRoom) {
            this.seaView = new SimpleStringProperty(((SingleRoom) room).isSeaView() ? "Yes" : "No");
        } else {
            this.seaView = new SimpleStringProperty("-");
        }

        if (room instanceof DoubleRoom) {
            this.hasBalcony = new SimpleStringProperty(((DoubleRoom) room).hasBalcony() ? "Yes" : "No");
        } else {
            this.hasBalcony = new SimpleStringProperty("-");
        }

        if (room instanceof SuiteRoom) {
            this.hasLivingRoom = new SimpleStringProperty(((SuiteRoom) room).hasLivingRoom() ? "Yes" : "No");
        } else {
            this.hasLivingRoom = new SimpleStringProperty("-");
        }
    }

    public String getRoomType() {
        return roomType.get();
    }

    public double getPrice() {
        return price.get();
    }

    public int getRoomID() {
        return roomID.get();
    }

    public String getSeaView() {
        return seaView.get();
    }

    public String getHasBalcony() {
        return hasBalcony.get();
    }

    public String getHasLivingRoom() {
        return hasLivingRoom.get();
    }
}

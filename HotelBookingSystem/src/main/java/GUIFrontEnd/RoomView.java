/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIFrontEnd;

import com.mycompany.hotelbookingsystem.DoubleRoom;
import com.mycompany.hotelbookingsystem.HotelManager;
import com.mycompany.hotelbookingsystem.Room;
import com.mycompany.hotelbookingsystem.SingleRoom;
import com.mycompany.hotelbookingsystem.SuiteRoom;

/**
 *
 * @author dell
 */
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class RoomView {

    public static void display(HotelManager hotelManager) {
        Stage window = new Stage();
        window.setTitle("عرض الغرف المتاحة");

        // عناصر الواجهة
        TextArea roomDisplayArea = new TextArea();
        roomDisplayArea.setEditable(false);

        ComboBox<String> filterBox = new ComboBox<>();
        filterBox.getItems().addAll(
            "جميع الغرف", // 0
            "Single Rooms", // 1
            "Double Rooms", // 2
            "Suite Rooms"   // 3
        );
        filterBox.setValue("جميع الغرف");

        Button showButton = new Button("عرض");
        showButton.setOnAction(e -> {
            roomDisplayArea.clear();
            int filterIndex = filterBox.getSelectionModel().getSelectedIndex();
            // نطبع الغرف على TextArea
            for (Room r : hotelManager.getRoomList()) {
                if (r.IsAvailable()) {
                    switch (filterIndex) {
                        case 0: roomDisplayArea.appendText(r.displayInfo() + "\n"); break;
                        case 1: if (r instanceof SingleRoom) roomDisplayArea.appendText(r.displayInfo() + "\n"); break;
                        case 2: if (r instanceof DoubleRoom) roomDisplayArea.appendText(r.displayInfo() + "\n"); break;
                        case 3: if (r instanceof SuiteRoom) roomDisplayArea.appendText(r.displayInfo() + "\n"); break;
                    }
                }
            }
        });

        HBox topControls = new HBox(10);
        topControls.getChildren().addAll(filterBox, showButton);

        BorderPane layout = new BorderPane();
        layout.setTop(topControls);
        layout.setCenter(roomDisplayArea);

        Scene scene = new Scene(layout, 400, 400);
        window.setScene(scene);
        window.show();
    }
}


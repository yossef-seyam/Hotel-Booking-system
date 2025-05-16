/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIFrontEnd;

import com.mycompany.hotelbookingsystem.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class RoomView {

    public static void display(HotelManager hotelManager) {
        Stage window = new Stage();
        window.setTitle("Show Available Rooms");

        // Images
        ImageView imgSingle = new ImageView(new Image("file:/E:/Singleroom.jpg"));
        ImageView imgDouble = new ImageView(new Image("file:/E:/Doubleroom.jpg"));
        ImageView imgSuite = new ImageView(new Image("file:/E:/Suiteroom.jpg"));

        for (ImageView iv : new ImageView[]{imgSingle, imgDouble, imgSuite}) {
            iv.setFitWidth(200);
            iv.setFitHeight(150);
        }

        HBox imagesBox = new HBox(20, imgSingle, imgDouble, imgSuite);
        imagesBox.setAlignment(Pos.CENTER);
        imagesBox.setPadding(new Insets(10));

        // Buttons
        Button btnSingle = new Button("Single Room");
        Button btnDouble = new Button("Double Room");
        Button btnSuite = new Button("Suite Room");

        HBox buttonBox = new HBox(40, btnSingle, btnDouble, btnSuite);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(5));

        // Table
        TableView<RoomTableItem> table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<RoomTableItem, String> typeCol = new TableColumn<>("Room Type");
        typeCol.setCellValueFactory(new PropertyValueFactory<>("roomType"));

        TableColumn<RoomTableItem, Double> priceCol = new TableColumn<>("Price");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<RoomTableItem, Integer> idCol = new TableColumn<>("Room ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("roomID"));

        TableColumn<RoomTableItem, String> seaViewCol = new TableColumn<>("Sea View");
        seaViewCol.setCellValueFactory(new PropertyValueFactory<>("seaView"));

        TableColumn<RoomTableItem, String> balconyCol = new TableColumn<>("Has Balcony");
        balconyCol.setCellValueFactory(new PropertyValueFactory<>("hasBalcony"));

        TableColumn<RoomTableItem, String> livingRoomCol = new TableColumn<>("Has Living Room");
        livingRoomCol.setCellValueFactory(new PropertyValueFactory<>("hasLivingRoom"));

        table.getColumns().addAll(typeCol, priceCol, idCol, seaViewCol, balconyCol, livingRoomCol);

        // Button actions
        btnSingle.setOnAction(e -> {
            table.setItems(getAvailableRoomsOfType(hotelManager, SingleRoom.class));
        });

        btnDouble.setOnAction(e -> {
            table.setItems(getAvailableRoomsOfType(hotelManager, DoubleRoom.class));
        });

        btnSuite.setOnAction(e -> {
            table.setItems(getAvailableRoomsOfType(hotelManager, SuiteRoom.class));
        });

        // Layout
        VBox layout = new VBox(10, imagesBox, buttonBox, table);
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 800, 600);
        window.setScene(scene);
        window.show();
    }

    private static ObservableList<RoomTableItem> getAvailableRoomsOfType(HotelManager hotelManager, Class<?> roomClass) {
        ObservableList<RoomTableItem> filtered = FXCollections.observableArrayList();
        for (Room r : hotelManager.getRoomList()) {
            if (roomClass.isInstance(r) && r.IsAvailable()) {
                filtered.add(new RoomTableItem(r));
            }
        }
        return filtered;
    }
}

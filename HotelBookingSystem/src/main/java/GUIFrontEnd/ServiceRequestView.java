/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIFrontEnd;

/**
 *
 * @author dell
 */
import com.mycompany.hotelbookingsystem.HotelManager;
import com.mycompany.hotelbookingsystem.Room;
import com.mycompany.hotelbookingsystem.Services;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ServiceRequestView {

    public static void display(HotelManager hotelManager) {
        Stage window = new Stage();
        window.setTitle("Request Service ");

        TextField roomIdField = new TextField();
        roomIdField.setMaxSize(200, 70);
        roomIdField.setPromptText(" Enter Room Id ");

        ChoiceBox<String> serviceChoice = new ChoiceBox<>();
        serviceChoice.getItems().addAll("Cleaning", "Laundry", "Food");

        Button requestButton = new Button("Request");
        Label resultLabel = new Label();

        requestButton.setOnAction(e -> {
            try {
                int roomId = Integer.parseInt(roomIdField.getText());
                String serviceType = serviceChoice.getValue();

                Room room = hotelManager.findRoomByID(roomId);
                if (room instanceof Services) {
                    ((Services) room).orderService(serviceType);
                    double cost = ((Services) room).getServiceCost(serviceType);
                    resultLabel.setText("  Service Request Done: " + serviceType + " Cost: " + cost);
                } else {
                    resultLabel.setText(" Sorry, Room Can't Have Services ");
                }

            } catch (NumberFormatException ex) {
                resultLabel.setText(" Room ID isn't True");
            } catch (Exception ex) {
                resultLabel.setText(" Error While Requesting Service");
            }
        });

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(
                new Label("Room ID :"),
                roomIdField,
                new Label("Service Type :"),
                serviceChoice,
                requestButton,
                resultLabel
        );

        Scene scene = new Scene(layout, 350, 250);
        window.setScene(scene);
        window.show();
    }
}

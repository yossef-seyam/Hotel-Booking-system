/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIFrontEnd;

/**
 *
 * @author dell
 */
import com.mycompany.hotelbookingsystem.Customer;
import com.mycompany.hotelbookingsystem.HotelManager;
import com.mycompany.hotelbookingsystem.Room;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddBookingView {

    public static void display(HotelManager hotelManager) {
        Stage window = new Stage();
        window.setTitle("Add New Booking");

        Label nameLabel = new Label("Customer Name");
        TextField nameInput = new TextField();

        Label emailLabel = new Label("Email");
        TextField emailInput = new TextField();

        Label roomIdLabel = new Label("Room ID :");
        TextField roomIdInput = new TextField();

        Label startDateLabel = new Label(" StartDate:");
        TextField startDateInput = new TextField();

        Label endDateLabel = new Label(" EndDate:");
        TextField endDateInput = new TextField();

        Button submitBtn = new Button("Confirm Booking ");
        Label statusLabel = new Label();

        submitBtn.setOnAction(e -> {
            try {
                String name = nameInput.getText();
                String email = emailInput.getText();
                int roomId = Integer.parseInt(roomIdInput.getText());
                String startDate = startDateInput.getText();
                String endDate = endDateInput.getText();

                Room room = hotelManager.findRoomByID(roomId);
                if (room == null) {
                    statusLabel.setText( " The Room Id Doesn't Exists");
                    return;
                }
                if (!room.IsAvailable()) {
                    statusLabel.setText(" The Room isn't Available");
                    return;
                }

                Customer customer = new Customer(name, email);
                hotelManager.makeReservation(customer, room, startDate, endDate);
                statusLabel.setText("Booking is Done");

            } catch (NumberFormatException ex) {
                statusLabel.setText(" The Room ID Must be Number");
            } catch (Exception ex) {
                statusLabel.setText("Error Occured While Booking   .");
            }
        });

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(
            nameLabel, nameInput,
            emailLabel, emailInput,
            roomIdLabel, roomIdInput,
            startDateLabel, startDateInput,
            endDateLabel, endDateInput,
            submitBtn, statusLabel
        );

        Scene scene = new Scene(layout, 300, 400);
        window.setScene(scene);
        window.show();
    }
} 
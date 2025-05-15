/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIFrontEnd;

import com.mycompany.hotelbookingsystem.Customer;
import com.mycompany.hotelbookingsystem.DoubleRoom;
import com.mycompany.hotelbookingsystem.HotelManager;
import com.mycompany.hotelbookingsystem.Room;
import com.mycompany.hotelbookingsystem.SingleRoom;
import com.mycompany.hotelbookingsystem.SuiteRoom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


/**
 *
 * @author user
 */
public class FX extends Application {

    private HotelManager hotelManager = new HotelManager();
    private TextArea outputArea = new TextArea();
    @Override
    public void start(Stage primaryStage) throws Exception {
        hotelManager.initializeRooms();

        primaryStage.setTitle("ELSONS Hotel Booking System");

        VBox root = new VBox(10);
        root.setPadding(new Insets(15));

        Label welcomeLabel = new Label("Welcome to ELSONS Hotel");
        outputArea.setEditable(false);
        outputArea.setPrefHeight(200);

        Button viewAvailableRoomsBtn = new Button("1) View available rooms");
        Button viewOffersBtn = new Button("2) View room offers");
        Button bookRoomBtn = new Button("3) Book a room");
        Button viewBookingBtn = new Button("4) View your booking details");
        Button cancelBookingBtn = new Button("5) Cancel a reservation");
        Button helpBtn = new Button("6) Help guide");
        Button exitBtn = new Button("7) Exit");

        

        viewOffersBtn.setOnAction(e -> {
            outputArea.clear();
            outputArea.appendText("Room offers coming soon!\n");
        });

        bookRoomBtn.setOnAction(e -> openBookingWindow());

        viewBookingBtn.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("View Booking");
            dialog.setHeaderText("Enter your booking ID:");
            dialog.showAndWait().ifPresent(id -> {
                try {
                    int bookingID = Integer.parseInt(id);
                    outputArea.clear();
                    outputArea.appendText(hotelManager.getBookingDetailsByID(bookingID));
                } catch (NumberFormatException ex) {
                    outputArea.appendText("Invalid Booking ID!\n");
                }
            });
        });

        cancelBookingBtn.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Cancel Booking");
            dialog.setHeaderText("Enter your booking ID to cancel:");
            dialog.showAndWait().ifPresent(id -> {
                try {
                    int bookingID = Integer.parseInt(id);
                    hotelManager.cancelReservation(bookingID);
                    outputArea.appendText("Booking cancelled successfully.\n");
                } catch (NumberFormatException ex) {
                    outputArea.appendText("Invalid Booking ID!\n");
                }
            });
        });

        helpBtn.setOnAction(e -> {
            outputArea.clear();
            outputArea.appendText("Help Guide will be available soon.\n");
        });

        exitBtn.setOnAction(e -> primaryStage.close());

        root.getChildren().addAll(welcomeLabel, viewAvailableRoomsBtn, viewOffersBtn, bookRoomBtn,
                viewBookingBtn, cancelBookingBtn, helpBtn, exitBtn, outputArea);

        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();
    }
    private void openBookingWindow() {
        Stage bookingStage = new Stage();
        bookingStage.setTitle("Book a Room");

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));

        TextField nameField = new TextField();
        nameField.setPromptText("Your Name");
        TextField emailField = new TextField();
        emailField.setPromptText("Your Email");

        ComboBox<String> roomTypeCombo = new ComboBox<>();
        roomTypeCombo.getItems().addAll("Single Room", "Double Room", "Suite Room");
        roomTypeCombo.setPromptText("Select Room Type");

        TextField roomIdField = new TextField();
        roomIdField.setPromptText("Room ID");

        TextField startDateField = new TextField();
        startDateField.setPromptText("Start Date (dd/MM/yyyy)");
        TextField endDateField = new TextField();
        endDateField.setPromptText("End Date (dd/MM/yyyy)");

        ComboBox<String> paymentMethod = new ComboBox<>();
        paymentMethod.getItems().addAll("Visa", "PayPal");
        paymentMethod.setPromptText("Select Payment Method");

        TextField paymentInfo = new TextField();
        paymentInfo.setPromptText("Enter Payment Info");

        Button confirmBtn = new Button("Confirm Booking");

        confirmBtn.setOnAction(e -> {
            try {
                String name = nameField.getText();
                String email = emailField.getText();
                int roomID = Integer.parseInt(roomIdField.getText());
                Room room = hotelManager.findRoomByID(roomID);

                if (!room.isAvailable) {
                    outputArea.appendText("Room is not available.\n");
                    bookingStage.close();
                    return;
                }

                Customer customer = new Customer(name, email);
                hotelManager.addCustomer(customer);
                hotelManager.makeReservation(customer, room, startDateField.getText(), endDateField.getText());

                outputArea.appendText("Reservation Confirmed for " + name + "\n");
                bookingStage.close();
            } catch (Exception ex) {
                outputArea.appendText("Error: " + ex.getMessage() + "\n");
            }
        });

        layout.getChildren().addAll(nameField, emailField, roomTypeCombo, roomIdField,
                startDateField, endDateField, paymentMethod, paymentInfo, confirmBtn);

        bookingStage.setScene(new Scene(layout, 400, 500));
        bookingStage.show();
    }
}

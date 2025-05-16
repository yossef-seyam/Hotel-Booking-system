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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AddBookingView {

    public static void display(HotelManager hotelManager) {
        Stage window = new Stage();
        window.setTitle("Add New Booking");

        Label nameLabel = new Label("Customer Name");
        TextField nameInput = new TextField();

        Label emailLabel = new Label("Email");
        TextField emailInput = new TextField();

        Label roomIdLabel = new Label("Room ID:");
        TextField roomIdInput = new TextField();

        // Date inputs with validation
        Label startDateLabel = new Label("Start Date (DD/MM/YYYY):");
        TextField startDateInput = new TextField();

        Label endDateLabel = new Label("End Date (DD/MM/YYYY):");
        TextField endDateInput = new TextField();

        // Payment method selection
        Label paymentMethodLabel = new Label("Payment Method:");
        ToggleGroup paymentToggle = new ToggleGroup();
        RadioButton visaBtn = new RadioButton("Visa");
        RadioButton paypalBtn = new RadioButton("PayPal");
        visaBtn.setToggleGroup(paymentToggle);
        paypalBtn.setToggleGroup(paymentToggle);
        visaBtn.setSelected(true);

        // Payment details input
        Label paymentDetailsLabel = new Label("Payment Details:");
        TextField paymentDetailsInput = new TextField();
        
        // Create HBox for payment method selection
        HBox paymentMethodBox = new HBox(10);
        paymentMethodBox.setAlignment(Pos.CENTER);
        paymentMethodBox.getChildren().addAll(visaBtn, paypalBtn);

        // Update payment details label based on selection
        visaBtn.setOnAction(e -> {
            paymentDetailsLabel.setText("Visa Card Number (12 digits):");
            paymentDetailsInput.setPromptText("Enter 12-digit card number");
            paymentDetailsInput.setText("");
        });

        paypalBtn.setOnAction(e -> {
            paymentDetailsLabel.setText("PayPal Email:");
            paymentDetailsInput.setPromptText("Enter PayPal email");
            paymentDetailsInput.setText("");
        });

        Button submitBtn = new Button("Confirm Booking");
        Label statusLabel = new Label();
        statusLabel.setWrapText(true);

        submitBtn.setOnAction(e -> {
            try {
                // Validate name
                String name = nameInput.getText().trim();
                if (name.isEmpty()) {
                    throw new IllegalArgumentException("Name cannot be empty");
                }

                // Validate email
                String email = emailInput.getText().trim();
                if (!isValidEmail(email)) {
                    throw new IllegalArgumentException("Invalid email format");
                }

                // Validate room ID
                int roomId = Integer.parseInt(roomIdInput.getText().trim());

                // Validate dates
                String startDate = startDateInput.getText().trim();
                String endDate = endDateInput.getText().trim();
                if (!isValidDate(startDate) || !isValidDate(endDate)) {
                    throw new IllegalArgumentException("Invalid date format. Use DD/MM/YYYY");
                }

                // Validate payment details
                String paymentDetails = paymentDetailsInput.getText().trim();
                if (visaBtn.isSelected()) {
                    if (!isValidVisaNumber(paymentDetails)) {
                        throw new IllegalArgumentException("Invalid Visa card number. Must be 12 digits");
                    }
                } else {
                    if (!isValidEmail(paymentDetails)) {
                        throw new IllegalArgumentException("Invalid PayPal email format");
                    }
                }

                Room room = hotelManager.findRoomByID(roomId);
                if (room == null) {
                    throw new IllegalArgumentException("Room ID doesn't exist");
                }
                if (!room.IsAvailable()) {
                    throw new IllegalArgumentException("Room isn't available");
                }

                Customer customer = new Customer(name, email);
                hotelManager.makeReservation(customer, room, startDate, endDate);
                statusLabel.setText("Booking confirmed successfully!");
                statusLabel.setStyle("-fx-text-fill: green;");

            } catch (NumberFormatException ex) {
                statusLabel.setText("Room ID must be a number");
                statusLabel.setStyle("-fx-text-fill: red;");
            } catch (IllegalArgumentException ex) {
                statusLabel.setText(ex.getMessage());
                statusLabel.setStyle("-fx-text-fill: red;");
            } catch (Exception ex) {
                statusLabel.setText("Error occurred while booking: " + ex.getMessage());
                statusLabel.setStyle("-fx-text-fill: red;");
            }
        });

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(
            nameLabel, nameInput,
            emailLabel, emailInput,
            roomIdLabel, roomIdInput,
            startDateLabel, startDateInput,
            endDateLabel, endDateInput,
            paymentMethodLabel, paymentMethodBox,
            paymentDetailsLabel, paymentDetailsInput,
            submitBtn, statusLabel
        );

        Scene scene = new Scene(layout, 400, 600);
        window.setScene(scene);
        window.show();
    }

    private static boolean isValidEmail(String email) {
        return email != null && 
               email.contains("@") && 
               email.contains(".") && 
               email.indexOf("@") < email.lastIndexOf(".") &&
               email.indexOf("@") > 0 &&
               email.lastIndexOf(".") < email.length() - 1;
    }

    private static boolean isValidDate(String dateStr) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate.parse(dateStr, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private static boolean isValidVisaNumber(String number) {
        return number != null && 
               number.matches("\\d{12}"); // Exactly 12 digits
    }
} 
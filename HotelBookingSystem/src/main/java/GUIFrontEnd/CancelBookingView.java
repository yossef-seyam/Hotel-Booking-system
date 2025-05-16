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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CancelBookingView {

    public static void display(HotelManager hotelManager) {
        Stage window = new Stage();
        window.setTitle("Cancel Booking ");

        Label label = new Label("Enter Booking Number  :");
        TextField bookingIdField = new TextField();

        Button cancelButton = new Button("Cancel Booking ");
        cancelButton.setOnAction(e -> {
            try {
                int bookingId = Integer.parseInt(bookingIdField.getText());
                hotelManager.cancelReservation(bookingId);
                showAlert(Alert.AlertType.INFORMATION, "   Booking is Cancelled Succefully.");
                window.close();
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "  Please Enter The Correct Number .");
            }
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label, bookingIdField, cancelButton);

        Scene scene = new Scene(layout, 300, 150);
        window.setScene(scene);
        window.show();
    }

    private static void showAlert(Alert.AlertType alertType, String message) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

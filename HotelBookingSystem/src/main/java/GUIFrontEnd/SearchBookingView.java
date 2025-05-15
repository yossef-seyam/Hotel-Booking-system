/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIFrontEnd;

/**
 *
 * @author dell
 */
import com.mycompany.hotelbookingsystem.Booking;
import com.mycompany.hotelbookingsystem.HotelManager;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SearchBookingView {

    public static void display(HotelManager hotelManager) {
        Stage window = new Stage();
        window.setTitle("البحث عن حجز");

        Label idLabel = new Label("أدخل رقم الحجز:");
        TextField idField = new TextField();
        idField.setPromptText("Booking ID");

        Button searchButton = new Button("بحث");
        Label resultLabel = new Label();

        searchButton.setOnAction(e -> {
            try {
                int bookingID = Integer.parseInt(idField.getText());
                Booking foundBooking = null;

                for (Booking booking : hotelManager.getBookingList()) {
                    if (booking.getBookingID() == bookingID) {
                        foundBooking = booking;
                        break;
                    }
                }

                if (foundBooking != null) {
                    resultLabel.setText(
                        "Customer: " + foundBooking.getCustomer().getName() +
                        " | Room: " + foundBooking.getRoom().getRoomID() +
                        " | From: " + foundBooking.getCheckStartDate() +
                        " | To: " + foundBooking.getCheckEndDate()
                    );
                } else {
                    resultLabel.setText("لم يتم العثور على الحجز.");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("يرجى إدخال رقم صالح.");
            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(idLabel, idField, searchButton, resultLabel);

        Scene scene = new Scene(layout, 400, 200);
        window.setScene(scene);
        window.show();
    }
}

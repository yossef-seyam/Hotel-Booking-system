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
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BookingListView {

    public static void display(HotelManager hotelManager) {
        Stage window = new Stage();
        window.setTitle("Booking List ");

        ListView<String> bookingListView = new ListView<>();

        for (Booking booking : hotelManager.getBookingList()) {
            String info = "Booking ID: " + booking.getBookingID()
                    + " | Customer: " + booking.getCustomer().getName()
                    + " | Room ID: " + booking.getRoom().getRoomID()
                    + " | From: " + booking.getCheckStartDate()
                    + " To: " + booking.getCheckEndDate();
            bookingListView.getItems().add(info);
        }

        Button closeBtn = new Button("Exit");
        closeBtn.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(bookingListView, closeBtn);

        Scene scene = new Scene(layout, 500, 300);
        window.setScene(scene);
        window.show();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIFrontEnd;
import com.mycompany.hotelbookingsystem.HotelManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FX extends Application {

    private HotelManager hotelManager = new HotelManager();

    @Override
    public void start(Stage primaryStage) {
        hotelManager.initializeRooms();

        // Buttons
        Button btnAvailableRooms = new Button("عرض الغرف المتاحة");
        Button btnAddBooking = new Button("إضافة حجز");
        Button btnCancelBooking = new Button("إلغاء حجز");
        Button btnShowBookings = new Button("عرض الحجوزات");
        Button btnShowCustomers = new Button("عرض العملاء");
        Button btnRequestService = new Button("طلب خدمة");
        Button btnApplyDiscount = new Button("تطبيق كود خصم");
        Button btnSearchBooking = new Button("بحث عن حجز");

        // Button Actions (placeholder)
        btnAvailableRooms.setOnAction(e -> RoomView.display(hotelManager));
        btnAddBooking.setOnAction(e -> AddBookingView.display(hotelManager));
        btnCancelBooking.setOnAction(e -> CancelBookingView.display(hotelManager));
        btnShowBookings.setOnAction(e -> BookingListView.display(hotelManager));
        btnShowCustomers.setOnAction(e -> CustomerListView.display(hotelManager));
        btnRequestService.setOnAction(e -> ServiceRequestView.display(hotelManager));
        btnApplyDiscount.setOnAction(e -> DiscountView.display(hotelManager));
        btnSearchBooking.setOnAction(e -> SearchBookingView.display(hotelManager));

        VBox layout = new VBox(10);
        layout.getChildren().addAll(
            btnAvailableRooms, btnAddBooking, btnCancelBooking,
            btnShowBookings, btnShowCustomers,
            btnRequestService, btnApplyDiscount, btnSearchBooking
        );

        Scene scene = new Scene(layout, 300, 400);
        primaryStage.setTitle("Hotel Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

//    public static void main(String[] args) {
//        launch(args);
//    }
}


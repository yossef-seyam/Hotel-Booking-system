/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIFrontEnd;
import com.mycompany.hotelbookingsystem.HotelManager;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class FX extends Application {

    private HotelManager hotelManager = new HotelManager();

    @Override
    public void start(Stage primaryStage) {
        hotelManager.initializeRooms();

        // Buttons
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(15));
        pane.setHgap(10);
        pane.setVgap(10);
        Label welcomeLabel = new Label("Welcome to Our Hotel");
        welcomeLabel.setStyle("-fx-font-size: 25px; -fx-font-weight: bold;");
        Image image = new Image("file:C:/Users/user/Downloads/Hotel.jpg");
        ImageView imageview = new ImageView(image);
        imageview.setFitWidth(300);
        imageview.setFitHeight(300);
        Button btnAvailableRooms = new Button("Show Available Rooms");
        Button btnAddBooking = new Button("Add Booking");
        Button btnCancelBooking = new Button("Cancel Booking");
        Button btnShowBookings = new Button("Show Bookings");
        Button btnShowCustomers = new Button("Show Customers");
        Button btnRequestService = new Button("Request Service");
        Button btnApplyDiscount = new Button("Apply Discount");
        Button btnSearchBooking = new Button("Search Booking");

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
          layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(welcomeLabel,imageview,
            btnAvailableRooms, btnAddBooking, btnCancelBooking,
            btnShowBookings, btnShowCustomers,
            btnRequestService, btnApplyDiscount, btnSearchBooking
        );

        Scene scene = new Scene(layout, 500, 700);
        primaryStage.setTitle("Hotel Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FX extends Application {

    private HotelManager hotelManager = new HotelManager();

    @Override
    public void start(Stage primaryStage) {
        hotelManager.initializeRooms();

        // Background image
        Image backgroundImage = new Image("file:/E:/hotel.jpg");
        ImageView backgroundView = new ImageView(backgroundImage);
        backgroundView.setFitWidth(800);
        backgroundView.setFitHeight(600);
        backgroundView.setPreserveRatio(false);

        // Overlay layer (dark transparent rectangle)
        Rectangle overlay = new Rectangle(800, 600);
        overlay.setFill(Color.rgb(0, 0, 0, 0.4));

        // Welcome label
        Label welcomeLabel = new Label("Welcome to Our Hotel");
        welcomeLabel.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: white;");

        // Buttons
        Button btnAvailableRooms = new Button("Show Available Rooms");
        Button btnAddBooking = new Button("Add Booking");
        Button btnCancelBooking = new Button("Cancel Booking");
        Button btnShowBookings = new Button("Show Bookings");
        Button btnShowCustomers = new Button("Show Customers");
        Button btnRequestService = new Button("Request Service");
        Button btnApplyDiscount = new Button("Apply Discount");
        Button btnSearchBooking = new Button("Search Booking");

        // Button styling
        Button[] buttons = {btnAvailableRooms, btnAddBooking, btnCancelBooking,
                            btnShowBookings, btnShowCustomers,
                            btnRequestService, btnApplyDiscount, btnSearchBooking};
        for (Button b : buttons) {
            b.setPrefWidth(250);
            b.setStyle("-fx-font-size: 14px;");
        }

        // Button actions
        btnAvailableRooms.setOnAction(e -> RoomView.display(hotelManager));
        btnAddBooking.setOnAction(e -> AddBookingView.display(hotelManager));
        btnCancelBooking.setOnAction(e -> CancelBookingView.display(hotelManager));
        btnShowBookings.setOnAction(e -> BookingListView.display(hotelManager));
        btnShowCustomers.setOnAction(e -> CustomerListView.display(hotelManager));
        btnRequestService.setOnAction(e -> ServiceRequestView.display(hotelManager));
        btnApplyDiscount.setOnAction(e -> DiscountView.display(hotelManager));
        btnSearchBooking.setOnAction(e -> SearchBookingView.display(hotelManager));

        // VBox for content
        VBox content = new VBox(15);
        content.setAlignment(Pos.CENTER);
        content.setPadding(new Insets(20));
        content.getChildren().addAll(welcomeLabel);
        content.getChildren().addAll(buttons);

        // Main layout with overlay
        StackPane root = new StackPane();
        root.getChildren().addAll(backgroundView, overlay, content);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Hotel Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


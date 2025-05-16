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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class FX extends Application {

    private HotelManager hotelManager = new HotelManager();
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        hotelManager.initializeRooms();
        showWelcomeScreen();
    }

    private void showWelcomeScreen() {
        // Background image
        Image backgroundImage = new Image("file:/C:/Users/user/Downloads/Spring_25/Advanced/project/netbeans project/HotelBookingSystem/src/main/resources/images/hotel.jpg");
        ImageView backgroundView = new ImageView(backgroundImage);
        backgroundView.setFitWidth(800);
        backgroundView.setFitHeight(600);
        backgroundView.setPreserveRatio(false);

        // Overlay layer
        Rectangle overlay = new Rectangle(800, 600);
        overlay.setFill(Color.rgb(0, 0, 0, 0.4));

        // Welcome text
        Label welcomeLabel = new Label("Welcome");
        welcomeLabel.setFont(Font.font("System", FontWeight.BOLD, 40));
        welcomeLabel.setStyle("-fx-text-fill: #FF8C00; -fx-effect: dropshadow(three-pass-box, black, 2, 2, 0, 0);");

        Label subLabel = new Label("To our Hotel");
        subLabel.setFont(Font.font("System", FontWeight.NORMAL, 24));
        subLabel.setStyle("-fx-text-fill: #FF8C00; -fx-effect: dropshadow(three-pass-box, black, 1, 1, 0, 0);");

        // Next button
        Button nextButton = new Button("Next");
        nextButton.setStyle("-fx-font-size: 16px; -fx-padding: 10 20;");
        nextButton.setOnAction(e -> showMainScreen());

        // Layout
        VBox content = new VBox(20);
        content.setAlignment(Pos.CENTER);
        content.getChildren().addAll(welcomeLabel, subLabel, nextButton);

        StackPane root = new StackPane();
        root.getChildren().addAll(backgroundView, overlay, content);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Welcome to Hotel Management System");
        welcomeLabel.setFont(Font.font("System", FontWeight.BOLD, 40));
        welcomeLabel.setStyle("-fx-text-fill: #FF8C00; -fx-effect: dropshadow(three-pass-box, black, 2, 2, 0, 0);");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showMainScreen() {
        // Background image
        Image backgroundImage = new Image("file:/C:/Users/user/Downloads/Spring_25/Advanced/project/netbeans project/HotelBookingSystem/src/main/resources/images/hotel.jpg");
        ImageView backgroundView = new ImageView(backgroundImage);
        backgroundView.setFitWidth(800);
        backgroundView.setFitHeight(600);
        backgroundView.setPreserveRatio(false);

        // Overlay layer (dark transparent rectangle)
        Rectangle overlay = new Rectangle(800, 600);
        overlay.setFill(Color.rgb(0, 0, 0, 0.4));

        // Welcome label
        Label welcomeLabel = new Label("Welcome to Our Hotel");
        welcomeLabel.setFont(Font.font("System", FontWeight.BOLD, 40));
        welcomeLabel.setStyle("-fx-text-fill: #FF8C00; -fx-effect: dropshadow(three-pass-box, black, 2, 2, 0, 0);");

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
    }

    public static void main(String[] args) {
        launch(args);
    }
}


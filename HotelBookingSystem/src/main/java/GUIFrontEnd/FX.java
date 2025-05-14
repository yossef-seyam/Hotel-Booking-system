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
import javafx.scene.control.TextField;
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

    HotelManager Hotel = new HotelManager();
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label welcomeLabel = new Label("Welcome");
        welcomeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 36));

        Label subLabel = new Label("to Seyam Hotel");
        subLabel.setFont(Font.font("Arial", 24));

        ImageView hotelImage = new ImageView(new Image("C:\\Users\\user\\Downloads\\hotel.png"));
        hotelImage.setFitWidth(300);
        hotelImage.setPreserveRatio(true);

        Button nextButton = new Button("Next");

        VBox firstLayout = new VBox(20);
        firstLayout.setAlignment(Pos.CENTER);
        firstLayout.getChildren().addAll(welcomeLabel, subLabel, hotelImage, nextButton);
        
        Scene firstScene = new Scene(firstLayout, 500, 500);

        // Second screen with options
        Label chooseLabel = new Label("Please select one of the options:");
        chooseLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        Button viewRoomsButton = new Button("View Available Rooms");
        Button offersButton = new Button("View Room Offers");
        Button bookRoomButton = new Button("Book a Room");
        Button viewBookingButton = new Button("View Booking Details");
        Button cancelButton = new Button("Cancel Reservation");
        Button helpButton = new Button("Help");
        Button exitButton = new Button("Exit");

        //viewRoomsButton.setOnAction(e -> Hotel.listAvailableRooms());
        helpButton.setOnAction(e -> System.out.println("Contact support@seyamhotel.com")); // Replace with real help window
        bookRoomButton.setOnAction(e -> showBookingScene(primaryStage));
        exitButton.setOnAction(e -> primaryStage.close());

        VBox secondLayout = new VBox(15);
        secondLayout.setAlignment(Pos.CENTER);
        secondLayout.getChildren().addAll(
            chooseLabel, viewRoomsButton, offersButton, bookRoomButton,
            viewBookingButton, cancelButton, helpButton, exitButton
        );

        Scene secondScene = new Scene(secondLayout, 500, 500);

        // Switch scenes
        nextButton.setOnAction(e -> primaryStage.setScene(secondScene));

        // Show first scene
        primaryStage.setTitle("Seyam Hotel");
        primaryStage.setScene(firstScene);
        primaryStage.show();
    }
    public void showBookingScene(Stage stage) {
    VBox layout = new VBox(10);
    layout.setPadding(new Insets(20));
    layout.setAlignment(Pos.CENTER);

    Label nameLabel = new Label("Enter your name:");
    TextField nameField = new TextField();

    Label emailLabel = new Label("Enter your email:");
    TextField emailField = new TextField();

    Label roomLabel = new Label("Select room type:");
    ComboBox<String> roomTypeBox = new ComboBox<>();
    roomTypeBox.getItems().addAll("Single Room", "Double Room", "Suite Room");

    Label startDateLabel = new Label("Enter start date (dd/MM/yyyy):");
    TextField startDateField = new TextField();

    Label endDateLabel = new Label("Enter end date (dd/MM/yyyy):");
    TextField endDateField = new TextField();

    Button confirmBtn = new Button("Confirm Booking");

    Label resultLabel = new Label();

    confirmBtn.setOnAction(e -> {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String roomType = roomTypeBox.getValue();
        String startDate = startDateField.getText().trim();
        String endDate = endDateField.getText().trim();

            // التحقق من الصيغة
            if (name.isEmpty() || email.isEmpty() || roomType == null || startDate.isEmpty() || endDate.isEmpty()) {
                resultLabel.setText("Please fill all fields.");
                return;
            }

            // التحقق من صيغة التاريخ
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            try {
                Date start = sdf.parse(startDate);
                Date end = sdf.parse(endDate);

                Customer customer = new Customer(name, email);
                Hotel.addCustomer(customer);
                Room room;

                switch (roomType) {
                    case "Single Room":
                        //room = new SingleRoom(false, "Single Room");
                        break;
                    case "Double Room":
                        //room = new DoubleRoom(true, "Double Room");
                        break;
                    case "Suite Room":
                        //room = new SuiteRoom("Suite Room");
                        break;
                    default:
                        resultLabel.setText("Invalid room type.");
                        return;
                }

                //Hotel.addRoom(room);
                //Hotel.makeReservation(customer, room, startDate, endDate);

                resultLabel.setText("Reservation Confirmed for " + name + "!");
            } catch (ParseException ex) {
                resultLabel.setText("Invalid date format. Use dd/MM/yyyy.");
            }
        });

        layout.getChildren().addAll(
                nameLabel, nameField,
                emailLabel, emailField,
                roomLabel, roomTypeBox,
                startDateLabel, startDateField,
                endDateLabel, endDateField,
                confirmBtn,
                resultLabel
        );

        Scene scene = new Scene(layout, 400, 600);
        stage.setScene(scene);
    }
}

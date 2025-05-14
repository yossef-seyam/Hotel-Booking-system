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
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;




/**
 *
 * @author user
 */
public class FX extends Application {

    HotelManager Hotel = new HotelManager();
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create layout for the first scene
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(15));
        pane.setHgap(10);
        pane.setVgap(10);

        Image image = new Image("file:/D:/Hotel.jpg");
        ImageView imageview = new ImageView(image);
        imageview.setFitWidth(200);
        imageview.setFitHeight(200);

        Label welcomeLabel = new Label("Welcome to Our Hotel");
        welcomeLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label namelabel = new Label("Name:");
        TextField namefield = new TextField();

        Label emaillabel = new Label("Email:");
        TextField emailfield = new TextField();

        Button nextbutton = new Button("Next");
        Button exitbutton = new Button("Exit");

        // Disable next button unless both fields are filled
        nextbutton.disableProperty().bind(
            Bindings.or(
                namefield.textProperty().isEmpty(),
                emailfield.textProperty().isEmpty()
            )
        );

        pane.add(welcomeLabel, 1, 0);
        pane.add(namelabel, 0, 1);
        pane.add(namefield, 1, 1);
        pane.add(emaillabel, 0, 2);
        pane.add(emailfield, 1, 2);
        pane.add(nextbutton, 1, 3);
        pane.add(exitbutton, 2, 3);

        exitbutton.setOnAction(e -> Platform.exit());

        nextbutton.setOnAction(e -> {
            String name = namefield.getText();

            Label nameLabel = new Label("Hi " + name);
            nameLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

            // Create image views
            ImageView imageviewsingle = new ImageView(new Image("file:/D:/Single_Room.jpg"));
            ImageView imageviewdouble = new ImageView(new Image("file:/D:/DoubleRoom.jpg"));
            ImageView imageviewsuite = new ImageView(new Image("file:/D:/Suite.jpg"));

            imageviewsingle.setFitWidth(200);
            imageviewsingle.setFitHeight(200);
            imageviewdouble.setFitWidth(200);
            imageviewdouble.setFitHeight(200);
            imageviewsuite.setFitWidth(200);
            imageviewsuite.setFitHeight(200);

            // Add images in a horizontal box
            HBox roomsBox = new HBox(20);
            roomsBox.setAlignment(Pos.CENTER);
            roomsBox.setPadding(new Insets(20));
            roomsBox.getChildren().addAll(imageviewsingle, imageviewdouble, imageviewsuite);

            // Room type buttons
            Button btnSingle = new Button("SingleRoom");
            Button btnDouble = new Button("DoubleRoom");
            Button btnSuite = new Button("Suite");

            HBox buttonBox = new HBox(180);
            buttonBox.setAlignment(Pos.CENTER);
            buttonBox.getChildren().addAll(btnSingle, btnDouble, btnSuite);
            
            Pane promo = new Pane();
            Label pc =new Label("Enter Your PromoCode");
            pc.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
            TextField Promocode = new TextField();
            Promocode.setMaxSize(200, 70);
            GridPane Exit = new GridPane();
             Exit.setAlignment(Pos.CENTER);
           Exit.add(exitbutton, 0, 0);
            
            promo.getChildren().add(Promocode);
            // Final layout
            VBox main = new VBox(20);
            main.setAlignment(Pos.CENTER);
            main.getChildren().addAll(nameLabel, roomsBox, buttonBox,pc,Promocode,Exit);
            
            
            

            Scene scene2 = new Scene(main, 750, 500);
            primaryStage.setScene(scene2);
            primaryStage.setTitle("Available Rooms");
            primaryStage.show();
        });

        VBox mainpage = new VBox(20);
        mainpage.setAlignment(Pos.CENTER);
        mainpage.getChildren().addAll(imageview, pane);

        Scene scene = new Scene(mainpage, 500, 500);
        primaryStage.setTitle("Hotel");
        primaryStage.setScene(scene);
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIFrontEnd;

import com.mycompany.hotelbookingsystem.DoubleRoom;
import com.mycompany.hotelbookingsystem.HotelManager;
import com.mycompany.hotelbookingsystem.Room;
import com.mycompany.hotelbookingsystem.SingleRoom;
import com.mycompany.hotelbookingsystem.SuiteRoom;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

/**
 *
 * @author dell
 */
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RoomView {

    public static void display(HotelManager hotelManager) {
        Stage window = new Stage();
        window.setTitle("Show Available Rooms");
        VBox Main = new VBox(10);
        Main.setAlignment(Pos.CENTER);

        // منطقة عرض الغرف
TextArea roomDisplayArea = new TextArea();
roomDisplayArea.setEditable(false);

// الأزرار
//Button showAllButton = new Button("كل الغرف");
            ImageView imageviewsingle = new ImageView(new Image("file:C:/Users/user/Downloads/Single.jpg"));
            ImageView imageviewdouble = new ImageView(new Image("file:C:/Users/user/Downloads/Double.jpg"));
            ImageView imageviewsuite = new ImageView(new Image("file:C:/Users/user/Downloads/Suite.jpg"));

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


  btnSingle.setOnAction(e -> {
    roomDisplayArea.clear();
    for (Room r : hotelManager.getRoomList()) {
        if (r instanceof SingleRoom && r.IsAvailable()) {
            roomDisplayArea.appendText(r.displayInfo() + "\n");
        }
    }
});

 btnDouble.setOnAction(e -> {
    roomDisplayArea.clear();
    for (Room r : hotelManager.getRoomList()) {
        if (r instanceof DoubleRoom && r.IsAvailable()) {
            roomDisplayArea.appendText(r.displayInfo() + "\n");
        }
    }
});

   btnSuite.setOnAction(e -> {
    roomDisplayArea.clear();
    for (Room r : hotelManager.getRoomList()) {
        if (r instanceof SuiteRoom && r.IsAvailable()) {
            roomDisplayArea.appendText(r.displayInfo() + "\n");
        }
    }
});

// وضع الأزرار في HBox
            HBox buttonBox = new HBox(180);
            buttonBox.setAlignment(Pos.CENTER);
            buttonBox.getChildren().addAll(btnSingle, btnDouble, btnSuite);

// وضع كل شيء في VBox
        VBox mainBox = new VBox(10);

//        HBox topControls = new HBox(10);
         mainBox.setAlignment(Pos.CENTER);
        mainBox.getChildren().addAll(roomsBox, buttonBox);

        BorderPane layout = new BorderPane();
        layout.setTop(mainBox);
        layout.setCenter(roomDisplayArea);

        Scene scene = new Scene(layout, 700, 700);
        window.setScene(scene);
        window.show();
    }
}


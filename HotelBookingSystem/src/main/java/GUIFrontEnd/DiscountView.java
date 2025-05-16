/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIFrontEnd;

import com.mycompany.hotelbookingsystem.HotelManager;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DiscountView {

    public static void display(HotelManager hotelManager) {
        Stage window = new Stage();
        window.setTitle("Apply Promo Code");

        Label label = new Label("Enter Promo Code:");
        TextField promoField = new TextField();
        promoField.setMaxSize(200, 70);
        promoField.setPromptText("Example: seyam1");

        Label label2 = new Label("Enter Room ID:");
        TextField roomIdField = new TextField();
        roomIdField.setMaxSize(200, 70);
        roomIdField.setPromptText("Example: 101");

        Button applyButton = new Button("Apply");
        Label resultLabel = new Label();

       applyButton.setOnAction(e -> {
    String code = promoField.getText().trim();
    try {
        int id = Integer.parseInt(roomIdField.getText().trim());

        if (code.isEmpty()) {
            resultLabel.setText("⚠️ Please enter a promo code.");
        } else if (!code.equals("seyam1")) {
            resultLabel.setText("❌ Invalid Promo Code.");
        } else if (!hotelManager.isRoomBooked(id)) {
            resultLabel.setText("❌ Room ID is not currently booked.");
        } else {
            hotelManager.applyDiscount(code, id);
            resultLabel.setText("✅ Discount applied successfully.");
        }

    } catch (NumberFormatException ex) {
        resultLabel.setText("❌ Invalid Room ID.");
    }
});


        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label, promoField, label2, roomIdField, applyButton, resultLabel);

        Scene scene = new Scene(layout, 400, 250);
        window.setScene(scene);
        window.show();
    }
}


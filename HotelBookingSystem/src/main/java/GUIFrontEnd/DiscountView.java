/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIFrontEnd;

/**
 *
 * @author dell
 */
import com.mycompany.hotelbookingsystem.HotelManager;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DiscountView {

    public static void display(HotelManager hotelManager) {
        Stage window = new Stage();
        window.setTitle("  Apply PromoCode");

        Label label = new Label("Enter Promo Code  :");
        TextField promoField = new TextField();
        promoField.setMaxSize(200, 70);
        promoField.setPromptText("Example: seyam1");

        Button applyButton = new Button("Apply");
        Label resultLabel = new Label();

        applyButton.setOnAction(e -> {
            String code = promoField.getText().trim();
            if (!code.isEmpty()) {
                hotelManager.applyDiscount(code);
                resultLabel.setText("   Discount is Applied if it Exists");
            } else {
                resultLabel.setText("Please Enter The PromoCode");
            }
        });

        VBox layout = new VBox(10);
         layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label, promoField, applyButton, resultLabel);

        Scene scene = new Scene(layout, 400, 200);
        window.setScene(scene);
        window.show();
    }
}

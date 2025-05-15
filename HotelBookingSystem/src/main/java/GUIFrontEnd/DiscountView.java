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
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DiscountView {

    public static void display(HotelManager hotelManager) {
        Stage window = new Stage();
        window.setTitle("تطبيق كود الخصم");

        Label label = new Label("أدخل كود الخصم:");
        TextField promoField = new TextField();
        promoField.setPromptText("مثال: seyam1");

        Button applyButton = new Button("تطبيق");
        Label resultLabel = new Label();

        applyButton.setOnAction(e -> {
            String code = promoField.getText().trim();
            if (!code.isEmpty()) {
                //hotelManager.applyDiscount(code);
                resultLabel.setText("تم تطبيق الخصم إن وُجد.");
            } else {
                resultLabel.setText("يرجى إدخال كود الخصم.");
            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, promoField, applyButton, resultLabel);

        Scene scene = new Scene(layout, 400, 200);
        window.setScene(scene);
        window.show();
    }
}

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
import com.mycompany.hotelbookingsystem.Room;
import com.mycompany.hotelbookingsystem.Services;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ServiceRequestView {

    public static void display(HotelManager hotelManager) {
        Stage window = new Stage();
        window.setTitle("طلب خدمة");

        TextField roomIdField = new TextField();
        roomIdField.setPromptText("أدخل رقم الغرفة");

        ChoiceBox<String> serviceChoice = new ChoiceBox<>();
        serviceChoice.getItems().addAll("Cleaning", "Laundry", "Food");

        Button requestButton = new Button("طلب");
        Label resultLabel = new Label();

        requestButton.setOnAction(e -> {
            try {
                int roomId = Integer.parseInt(roomIdField.getText());
                String serviceType = serviceChoice.getValue();

                Room room = hotelManager.findRoomByID(roomId);
                if (room instanceof Services) {
                    ((Services) room).orderService(serviceType);
                    double cost = ((Services) room).getServiceCost(serviceType);
                    resultLabel.setText("تم طلب الخدمة: " + serviceType + " | التكلفة: " + cost);
                } else {
                    resultLabel.setText("الغرفة لا تدعم الخدمات.");
                }

            } catch (NumberFormatException ex) {
                resultLabel.setText("رقم الغرفة غير صالح.");
            } catch (Exception ex) {
                resultLabel.setText("حدث خطأ أثناء معالجة الطلب.");
            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(
                new Label("رقم الغرفة:"),
                roomIdField,
                new Label("نوع الخدمة:"),
                serviceChoice,
                requestButton,
                resultLabel
        );

        Scene scene = new Scene(layout, 350, 250);
        window.setScene(scene);
        window.show();
    }
}

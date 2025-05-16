/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIFrontEnd;

/**
 *
 * @author dell
 */
import com.mycompany.hotelbookingsystem.Customer;
import com.mycompany.hotelbookingsystem.HotelManager;
import com.mycompany.hotelbookingsystem.Room;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddBookingView {

    public static void display(HotelManager hotelManager) {
        Stage window = new Stage();
        window.setTitle("إضافة حجز جديد");

        Label nameLabel = new Label("اسم العميل:");
        TextField nameInput = new TextField();

        Label emailLabel = new Label("البريد الإلكتروني:");
        TextField emailInput = new TextField();

        Label roomIdLabel = new Label("رقم الغرفة:");
        TextField roomIdInput = new TextField();

        Label startDateLabel = new Label("تاريخ البداية:");
        TextField startDateInput = new TextField();

        Label endDateLabel = new Label("تاريخ النهاية:");
        TextField endDateInput = new TextField();

        Button submitBtn = new Button("تأكيد الحجز");
        Label statusLabel = new Label();

        submitBtn.setOnAction(e -> {
            try {
                String name = nameInput.getText();
                String email = emailInput.getText();
                int roomId = Integer.parseInt(roomIdInput.getText());
                String startDate = startDateInput.getText();
                String endDate = endDateInput.getText();

                Room room = hotelManager.findRoomByID(roomId);
                if (room == null) {
                    statusLabel.setText("رقم الغرفة غير موجود.");
                    return;
                }
                if (!room.IsAvailable()) {
                    statusLabel.setText("الغرفة غير متاحة.");
                    return;
                }

                Customer customer = new Customer(name, email);
                hotelManager.makeReservation(customer, room, startDate, endDate);
                statusLabel.setText("تم الحجز بنجاح!");

            } catch (NumberFormatException ex) {
                statusLabel.setText("رقم الغرفة يجب أن يكون رقماً.");
            } catch (Exception ex) {
                statusLabel.setText("حدث خطأ أثناء الحجز.");
            }
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(
            nameLabel, nameInput,
            emailLabel, emailInput,
            roomIdLabel, roomIdInput,
            startDateLabel, startDateInput,
            endDateLabel, endDateInput,
            submitBtn, statusLabel
        );

        Scene scene = new Scene(layout, 300, 400);
        window.setScene(scene);
        window.show();
    }
} 
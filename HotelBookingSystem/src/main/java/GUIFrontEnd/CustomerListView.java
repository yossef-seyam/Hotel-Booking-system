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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CustomerListView {

    public static void display(HotelManager hotelManager) {
        Stage window = new Stage();
        window.setTitle("قائمة العملاء");

        ListView<String> customerListView = new ListView<>();

        for (Customer customer : hotelManager.getCustomerList()) {
            String info = "Customer ID: " + customer.getID()
                        + " | Name: " + customer.getName()
                        + " | Email: " + customer.getEmail();
            customerListView.getItems().add(info);
        }

        Button closeBtn = new Button("إغلاق");
        closeBtn.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(customerListView, closeBtn);

        Scene scene = new Scene(layout, 400, 300);
        window.setScene(scene);
        window.show();
    }
}

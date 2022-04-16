package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import util.ConnectionUtil;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Admin_AddNewClientController {

    @FXML
    private TextField Name;

    @FXML
    private TextField LastName;

    @FXML
    private TextField Address;

    @FXML
    private TextField Grad;

    private static final String SQL_Cli = "INSERT INTO client (FirstName,LastName,Address,Grad)"
            + " VALUES (?,?,?,?);";

    @FXML
    void Add_New_Client(ActionEvent event) {

        String name = Name.getText();
        String lastName = LastName.getText();
        String address = Address.getText();
        String grad = Grad.getText();


        if (Name.getText().isEmpty()) {
            infoBox("Моля въведете коректни данни", "Въведете име");
        }

        if (LastName.getText().isEmpty()) {
            infoBox("Моля въведете коректни данни", "Въведете фамилия");
        }

        if (Address.getText().isEmpty()) {
            infoBox("Моля въведете коректни данни", "Въведете адрес");
        }

        if (Grad.getText().isEmpty()) {
            infoBox("Моля въведете коректни данни", "Въведете град");
        } else {

            try {
                Connection conn = ConnectionUtil.getConnection();
                PreparedStatement prepst = (PreparedStatement) conn.prepareStatement(SQL_Cli);
                prepst.setString(1, name);
                prepst.setString(2, lastName);
                prepst.setString(3, address);
                prepst.setString(4, grad);
                prepst.executeUpdate();

                infoBox("Успешно добавяне", "добавяне");
            } catch (SQLException | HeadlessException ex) {
                infoBox("Неуспешно добавяне", "грешка");
            }

        }
    }

    private static void infoBox(String infoMessage, String title){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

}

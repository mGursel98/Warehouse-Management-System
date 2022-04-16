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

public class Agent_AddNewFormController {


    @FXML
    private TextField For_period;

    @FXML
    private TextField For_info;

    @FXML
    private TextField For_grad;

    @FXML
    private TextField For_cena;


    private static final String SQL_For = "INSERT INTO formulqr (period,infoClient,grad,cena)"
            + " VALUES (?,?,?,?);";

    @FXML
    void Add_New_Form(ActionEvent event) {

        String period = For_period.getText();
        String info = For_info.getText();
        String grad = For_grad.getText();
        double cena = Double.parseDouble(For_cena.getText());


        if (For_period.getText().isEmpty()) {
            infoBox("Моля въведете коректни данни", "Въведете период");
        }

        if (For_info.getText().isEmpty()) {
            infoBox("Моля въведете коректни данни", "Въведете инфо");
        }

        if (For_grad.getText().isEmpty()) {
            infoBox("Моля въведете коректни данни", "Въведете град");
        }

        if (For_cena.getText().isEmpty()) {
            infoBox("Моля въведете коректни данни", "Въведете цена");
        } else {

            try {
                Connection conn = ConnectionUtil.getConnection();
                PreparedStatement prepst = (PreparedStatement) conn.prepareStatement(SQL_For);
                prepst.setString(1, period);
                prepst.setString(2, info);
                prepst.setString(3, grad);
                prepst.setDouble(4, cena);

                prepst.executeUpdate();

                infoBox("Успешно добавяне", "добавяне");
            } catch (SQLException | HeadlessException ex) {
                infoBox("Неуспешно добавяне", "грешка");
            }
        }
    }
    private static void infoBox (String infoMessage, String title){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}
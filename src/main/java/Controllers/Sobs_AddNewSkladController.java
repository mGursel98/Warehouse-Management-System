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

public class Sobs_AddNewSkladController {


    @FXML
    private TextField S_razmeri;

    @FXML
    private TextField S_opis;

    @FXML
    private TextField S_grad;

    @FXML
    private TextField S_cena;

    @FXML
    private TextField S_vid;

    private static final String SQL_Skl = "INSERT INTO sklad (Razmeri,Opisanie,Grad,Cena,Vid_stoka)"
            + " VALUES (?,?,?,?,?);";

    @FXML
    void Add_New_Sklad(ActionEvent event) {

        String razmeri = S_razmeri.getText();
        String opisanie = S_opis.getText();
        String grad = S_grad.getText();
        double cena = Double.parseDouble(S_cena.getText());
        String vid = S_vid.getText();


        if (S_razmeri.getText().isEmpty()) {
            infoBox("Моля въведете коректни данни", "Въведете размери");
        }

        if (S_opis.getText().isEmpty()) {
            infoBox("Моля въведете коректни данни", "Въведете описание");
        }

        if (S_grad.getText().isEmpty()) {
            infoBox("Моля въведете коректни данни", "Въведете град");
        }


        if (S_vid.getText().isEmpty()) {
            infoBox("Моля въведете коректни данни", "Въведете вид");
        } else {

            try {
                Connection conn = ConnectionUtil.getConnection();
                PreparedStatement prepst = (PreparedStatement) conn.prepareStatement(SQL_Skl);
                prepst.setString(1, razmeri);
                prepst.setString(2, opisanie);
                prepst.setString(3, grad);
                prepst.setDouble(4, cena);
                prepst.setString(5, vid);
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
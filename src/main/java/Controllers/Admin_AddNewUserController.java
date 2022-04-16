package Controllers;

import Business_Logic.Potrebitel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import util.ConnectionUtil;

import java.awt.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Admin_AddNewUserController implements Initializable {


    @FXML
    private TableView<Potrebitel> P_Table;

    @FXML
    private TableColumn<Potrebitel, String> P_C_ID;

    @FXML
    private TableColumn<Potrebitel, String> P_C_Username;

    @FXML
    private TableColumn<Potrebitel, String> P_C_Password;

    @FXML
    private TableColumn<Potrebitel, String> P_C_UserType;

    @FXML
    private TableColumn<Potrebitel, String> P_C_FirstName;

    @FXML
    private TableColumn<Potrebitel, String> P_C_LastName;


    @FXML
    private TextField P_Username;

    @FXML
    private TextField P_Password;

    @FXML
    private TextField P_Usertype;

    @FXML
    private TextField P_FirstName;

    @FXML
    private TextField P_LastName;

    @FXML
    private Button addPotrebitelButton;



    private static final String SQL = "INSERT INTO potrebitel (username,password,usertype,FirstName,LastName)"
            + " VALUES (?,?,?,?,?);";

    @FXML
    public void Add_New_Potrebitel(ActionEvent event) throws SQLException, ClassNotFoundException {

        String user_name = P_Username.getText();
        String password = P_Password.getText();
        String usertype = P_Usertype.getText();
        String first_name = P_FirstName.getText();
        String last_name = P_LastName.getText();


        if (P_Username.getText().isEmpty()) {
            infoBox("Моля въведете коректни данни","Въведете потребителско име");
        }

        if (P_Password.getText().isEmpty()) {
            infoBox("Моля въведете коректни данни","Въведете парола");
        }

        if (P_Usertype.getText().isEmpty()) {
            infoBox("Моля въведете коректни данни","Въведете роля");
        }

        if (P_FirstName.getText().isEmpty()) {
            infoBox("Моля въведете коректни данни","Въведете име");
        }

        if (P_LastName.getText().isEmpty()) {
            infoBox("Моля въведете коректни данни","Въведете презиме");
        }

        try {
            Connection conn = ConnectionUtil.getConnection();
            PreparedStatement prepst = (PreparedStatement) conn.prepareStatement(SQL);
            prepst.setString(1, user_name);
            prepst.setString(2, password);
            prepst.setString(3, usertype);
            prepst.setString(4, first_name);
            prepst.setString(5, last_name);
            prepst.executeUpdate();

            infoBox("Успешно добавяне", "добавяне" );
        } catch (SQLException | HeadlessException ex) {
            infoBox("Неуспешно добавяне", "грешка" );
        }

    }



    ObservableList<Potrebitel> Potlist = FXCollections.observableArrayList();


    private void Print_On_Table() {
        try {
            String SQL = "SELECT *FROM potrebitel";
            Connection conn = ConnectionUtil.getConnection();
            ResultSet rs = conn.createStatement().executeQuery(SQL);
            while (rs.next()) {
                Potlist.add(new Potrebitel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6)));

            }

            P_C_ID.setCellValueFactory(data->data.getValue().idProperty());

            P_C_Username.setCellValueFactory(data->data.getValue().usernameProperty());

            P_C_Password.setCellValueFactory(data->data.getValue().passwordProperty());

            P_C_UserType.setCellValueFactory(data->data.getValue().usertypeProperty());

            P_C_FirstName.setCellValueFactory(data->data.getValue().firstNameProperty());

            P_C_LastName.setCellValueFactory(data->data.getValue().lastNameProperty());

            P_Table.setItems(Potlist);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }


    public void initialize(URL location, ResourceBundle resource) {
        Print_On_Table();
    }

    private static void infoBox(String infoMessage, String title){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}

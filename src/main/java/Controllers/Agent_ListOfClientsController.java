package Controllers;

import Business_Logic.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import util.ConnectionUtil;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Agent_ListOfClientsController implements Initializable {

    private Connection conn = null;
    private PreparedStatement prepst = null;

    @FXML
    private TableView<Client> Table_OfClients;


    @FXML
    private TableColumn<Client, String> Client_ID;

    @FXML
    private TableColumn<Client, String> C_FirstName;

    @FXML
    private TableColumn<Client, String> C_LastName;

    @FXML
    private TableColumn<Client, String> C_Address;

    @FXML
    private TableColumn<Client, String> C_Grad;


    ObservableList<Client> ClientList = FXCollections.observableArrayList();


    public void initialize(URL location, ResourceBundle resource) {
        try {
            String SQL = "SELECT *FROM client";
            Connection conn = ConnectionUtil.getConnection();
            ResultSet rs = conn.createStatement().executeQuery(SQL);
            while (rs.next()) {
                ClientList.add(new Client(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));

            }

            Client_ID.setCellValueFactory(data -> data.getValue().client_idProperty());
            C_FirstName.setCellValueFactory(data -> data.getValue().firstNameProperty());
            C_LastName.setCellValueFactory(data -> data.getValue().lastNameProperty());
            C_Address.setCellValueFactory(data -> data.getValue().addressProperty());
            C_Grad.setCellValueFactory(data -> data.getValue().gradProperty());

            Table_OfClients.setItems(ClientList);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}

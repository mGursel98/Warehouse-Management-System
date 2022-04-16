package Controllers;

import Business_Logic.Potrebitel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import util.ConnectionUtil;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Sobstvenik_ListOfAgentsController implements Initializable {


    @FXML
    private TableView<Potrebitel> Table_OfAgents;

    @FXML
    private TableColumn<Potrebitel, String> Agent_ID;

    @FXML
    private TableColumn<Potrebitel, String> First_Name;

    @FXML
    private TableColumn<Potrebitel, String> Last_Name;


    ObservableList<Potrebitel> AgentList = FXCollections.observableArrayList();

    public void initialize(URL location, ResourceBundle resource) {
        try {
            String type = "agent";

            String SQL = "SELECT id,FirstName,LastName from potrebitel " + "where usertype ='" + type+"'";
            Connection conn = ConnectionUtil.getConnection();
            ResultSet rs = conn.createStatement().executeQuery(SQL);
            while (rs.next()) {
                AgentList.add(new Potrebitel(rs.getString(1), rs.getString(2), rs.getString(3)));

            }

            Agent_ID.setCellValueFactory(data -> data.getValue().idProperty());
            First_Name.setCellValueFactory(data -> data.getValue().firstNameProperty());
            Last_Name.setCellValueFactory(data -> data.getValue().lastNameProperty());

            Table_OfAgents.setItems(AgentList);


        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
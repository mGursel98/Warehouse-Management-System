package Controllers;

import Business_Logic.Sklad;
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

public class Sobstvenik_ListOfSkladsController implements Initializable {



    @FXML
    private TableView<Sklad> Table_OfSklad;


    @FXML
    private TableColumn<Sklad, String> Sklad_ID;

    @FXML
    private TableColumn<Sklad, String> S_razmeri;

    @FXML
    private TableColumn<Sklad, String> S_opis;

    @FXML
    private TableColumn<Sklad, String> S_grad;

    @FXML
    private TableColumn<Sklad, String> S_cena;

    @FXML
    private TableColumn<Sklad, String> S_vid;

    ObservableList<Sklad> SkladList = FXCollections.observableArrayList();


    public void initialize(URL location, ResourceBundle resource) {
        try {
            String SQL = "SELECT *FROM sklad";
            Connection conn = ConnectionUtil.getConnection();
            ResultSet rs = conn.createStatement().executeQuery(SQL);
            while (rs.next()) {
                SkladList.add(new Sklad(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5),
                        rs.getString(6)));

            }

            Sklad_ID.setCellValueFactory(data -> data.getValue().sklad_idProperty());
            S_razmeri.setCellValueFactory(data -> data.getValue().razmeriProperty());
            S_opis.setCellValueFactory(data -> data.getValue().opisanieProperty());
            S_grad.setCellValueFactory(data -> data.getValue().gradProperty());
            S_cena.setCellValueFactory(data -> data.getValue().cenaProperty().asString());
            S_vid.setCellValueFactory(data -> data.getValue().vid_stokaProperty());

            Table_OfSklad.setItems(SkladList);
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

}

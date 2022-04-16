package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.ConnectionUtil;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    final static Logger logger = LogManager.getLogger(log4j.log4j.class);


    @FXML
    private TextField textUsername;

    @FXML
    private PasswordField textPassword;

    @FXML
    private Button submitButton;


    @FXML
    public void loginAction(ActionEvent event) throws SQLException, ClassNotFoundException {


        if (textUsername.getText().isEmpty()) {
            infoBox("Моля,въведете потребителско име", "Грешка");
            return;
        }
        if (textPassword.getText().isEmpty()) {
            infoBox("Моля, въведете парола", "Грешка");
            return;
        }

        String username = textUsername.getText();
        String password = textPassword.getText();

        ConnectionUtil conutil = new ConnectionUtil();

        boolean flag = ConnectionUtil.validate(username, password);

        if (!flag) {
            infoBox("Моля въведете коректни данни","Грешка");
            logger.debug("Некоректни данни.Провален достъп.");
        } else {

            try {
                infoBox("Успешно влизане", "Логнат" );
                logger.debug("Успешен достъп на потребител.");
                String ROLE = ConnectionUtil.USERTYPE;
                System.out.println(ROLE);
                if (ROLE.equals("admin")) {
                    Node node = (Node)event.getSource();
                    Stage dialogStage = (Stage) node.getScene().getWindow();
                    dialogStage.close();

                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/FXML/AdminLogin.fxml")));
                    dialogStage.setScene(scene);
                    dialogStage.setTitle("Админ панел");
                    dialogStage.show();
                }

                if (ROLE.equals("sobstvenik")) {
                    Node node = (Node)event.getSource();
                    Stage dialogStage = (Stage) node.getScene().getWindow();
                    dialogStage.close();

                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/FXML/SobstvenikLogin.fxml")));
                    dialogStage.setScene(scene);
                    dialogStage.setTitle("Собственик панел");
                    dialogStage.show();

                }
                if (ROLE.equals("agent")) {
                    Node node = (Node)event.getSource();
                    Stage dialogStage = (Stage) node.getScene().getWindow();
                    dialogStage.close();

                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/FXML/AgentLogin.fxml")));
                    dialogStage.setScene(scene);
                    dialogStage.setTitle("Агент панел");
                    dialogStage.show();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private static void infoBox(String infoMessage, String title){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import utils.DBCountries;
import Model.Countries;
import Model.UserDB;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import Model.User;
import java.util.Locale;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author 18018
 */
public class Login_FrenchController {

    
    @FXML
    public TableColumn idCol;
    public TableColumn nameCol;
    public TableView dataTable;

    @FXML
    private Button Login;
    
    @FXML
    private TextField usernameText;
    
    @FXML
    private PasswordField passwordText;
    
        /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */

    @FXML
        private void handleLogin(ActionEvent event) throws Exception {
            String username = usernameText.getText();
            String password = passwordText.getText();
            boolean validUserPass = UserDB.login(username, password);
            
            if(validUserPass){
                ((Stage)(((Button)event.getSource()).getScene().getWindow())).hide();
                Parent root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Main");
                stage.show();       
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur d'identification");
                alert.setHeaderText("Nom d'utilisateur ou mot de passe invalide");
                alert.setContentText("(peut-être les deux?)");
                alert.showAndWait();
            }
    }
    
    
}

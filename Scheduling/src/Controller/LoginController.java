/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import utils.UserDB;
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
import java.io.IOException;
import java.util.Locale;
import java.util.TimeZone;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ian Harwell
 */
public class LoginController implements Initializable {
    
    /**
     * Adds FXML links 
     *
     * 
     */
    
    @FXML
    public TableColumn idCol;
    public TableColumn nameCol;
    public TableView dataTable;

    @FXML
    private Button Login;
    
    @FXML
    private Text Location;
    @FXML
    private TextField usernameText;
    
    @FXML
    private PasswordField passwordText;
    
        /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Location.setText("You are in " + String.valueOf(TimeZone.getDefault().getID()));
    }  

    /**
     * tests username/password and logs in if correct, rejects if incorrect. Makes a log. 
     *
     * @param event
     */
    @FXML
        private void handleLogin(ActionEvent event) throws IOException {
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
                alert.setTitle("Login Error");
                alert.setHeaderText("Invalid Usernamer or Password");
                alert.setContentText("(maybe both?)");
                alert.showAndWait();
            }
    
    }
    
    
}

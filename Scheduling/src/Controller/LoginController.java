/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DBAccess.DBCountries;
import Model.Countries;
import java.awt.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author 18018
 */
public class LoginController implements Initializable {
    
    public TableColumn idCol;
    public TableColumn nameCol;
    public TableView dataTable;

    @FXML
    private Button Login;
    
    @FXML
    private TextField Username;
    
    @FXML
    private PasswordField Password;
    
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
        private void handleLogin(ActionEvent event) {
            String username = Username.getText();
            String password = Password.getText();
            boolean validUserPass = Userdatabase.login(username, password);
          System.out.println("PeePee");
      //  }
    }
    
    
}

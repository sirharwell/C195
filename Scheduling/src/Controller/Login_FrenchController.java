/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author 18018
 */
public class Login_FrenchController {
        /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rb = ResourceBundle.getBundle("Languages/Login", Locale.getDefault());
        if( 
            Locale.getDefault().getLanguage().equals("fr") || Locale.getDefault().getLanguage().equals("en")
                usernameLabel.setText(rb.getString("username"));
                passwordLabel.setText(rb.getString("password"));
                loginButton.setText(rb.getString("login"));
                mainMessage.setText(rb.getString("message"));
                languageMessage.setText(rb.getString("language"));
                errorHeader = rb.getString("errorheader");
                errorTitle = rb.getString("errortitle");
                errorText = rb.getString("errortext");
                )
    }  
    
}

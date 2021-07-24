/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZonedDateTime;

/**
 *
 * @author 18018
 */
public class Logger {
    private static final String FILENAME = "login_activity.txt";
    
    public Logger() {}
    
    public static void log (String username, boolean success) {
        try (FileWriter fwVariable = new FileWriter(FILENAME, true);
             BufferedWriter bwVariable = new BufferedWriter(fwVariable);
             PrintWriter pwVariable = new PrintWriter(bwVariable)) {
            pwVariable.println(ZonedDateTime.now() + " " + username + (success ? " Success" : " Failure"));
        } catch (IOException e) {
            System.out.println("Logger Error: " + e.getMessage());
        }
    }
    
}

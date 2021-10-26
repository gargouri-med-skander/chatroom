/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author everyone
 */
public class AuthentificationController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private Button login;
    @FXML
    private Button forgotPassword;
    @FXML
    private Button SignUp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void LogIn(ActionEvent event) {
    }

    @FXML
    private void placerForgotPassword(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("forgotPassword.fxml"));
        Stage primaryStage=new Stage ();
        primaryStage.setTitle("forgotPassword!");
        primaryStage.setScene(new Scene(root, 700, 700));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @FXML
    private void placerSignUp(ActionEvent event) throws IOException {
     Parent root = FXMLLoader.load(getClass().getResource("inscription.fxml"));
        Stage primaryStage=new Stage ();
        primaryStage.setTitle("inscription!");
        primaryStage.setScene(new Scene(root, 1400, 700));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
}

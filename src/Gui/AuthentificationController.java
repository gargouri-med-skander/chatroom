/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Gui.AdminInterfaceController;
import static Gui.InscriptionController.hashMethod;

import entites.role;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.AdminService;
import services.UserService;

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
     @FXML
    private ToggleGroup TypeLogIn;
     @FXML
    private RadioButton Membree;
     
    @FXML
    private RadioButton Adminn;
    protected static String EmailLogin ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void LogIn(ActionEvent event) throws SQLException, IOException, NoSuchAlgorithmException {
        
        if (TypeLogIn.getSelectedToggle().equals( Adminn)){
             UserService us = new UserService();
            String pass = hashMethod(password.getText());
             String s1 = "Admin";
             int  x  =us.Login (role.Admin,email.getText(),pass);
             
             if(x==1)
             {
                  Parent root = FXMLLoader.load(getClass().getResource("AdminInterface.fxml"));
        Stage primaryStage=new Stage ();
        primaryStage.setTitle("AdminInterface!");
        primaryStage.setScene(new Scene(root, 1000, 1000));
        primaryStage.setResizable(false);
        primaryStage.show();
        AuthentificationController.EmailLogin=email.getText();

   
            Stage stage = (Stage) login.getScene().getWindow();
    
    stage.close();
             }
            
             
             if(x==2){
                 
                              JOptionPane.showMessageDialog(null, "ACCOUNT NOT FOUND !!!");

             }
         }
           
       if(TypeLogIn.getSelectedToggle().equals(Membree)){
            UserService us = new UserService();
              String pass = hashMethod(password.getText());
            String s2 = "Membre";
            int y  =us.Login (role.Membre,email.getText(),pass);
             if(y==1)
             {
                //FENETRE MEMBRE
             }
          
             if(y==2){
                 
                              JOptionPane.showMessageDialog(null, "ACCOUNT NOT FOUND !!!");

             }
      
       }    
    }

    @FXML
    private void placerForgotPassword(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ForgotPassword1.fxml"));
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
        primaryStage.setScene(new Scene(root, 856, 701));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
}

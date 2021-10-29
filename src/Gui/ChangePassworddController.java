/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import static Gui.ForgotPassword1Controller.codeM;
import static Gui.ForgotPassword1Controller.emailR;
import static Gui.InscriptionController.hashMethod;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author everyone
 */
public class ChangePassworddController implements Initializable {

    @FXML
    private Button change;
    @FXML
    private Button xChange;
    @FXML
    private TextField codeEmail;
    @FXML
    private PasswordField newpassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void changeM(ActionEvent event) throws NoSuchAlgorithmException {
         if(codeM.equals(codeEmail.getText()))
        {
            UserService us = new UserService ();
           
            
               String  x = hashMethod(newpassword.getText());
           
            us.ChangePassword(emailR,x);
             JOptionPane.showMessageDialog(null,"Password changed!!!");
             Stage stage = (Stage) change.getScene().getWindow();
    
    stage.close();
        }
        else
                 JOptionPane.showMessageDialog(null,"Wrong Code!!!");
        

    }

    @FXML
    private void x(ActionEvent event) {
          Stage stage = (Stage) xChange.getScene().getWindow();
    
    stage.close();
    }
    
}

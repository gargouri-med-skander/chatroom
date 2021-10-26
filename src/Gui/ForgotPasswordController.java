/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;


import java.net.URL;


import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author everyone
 */
public class ForgotPasswordController implements Initializable {
     
    
    

    @FXML
    private TextField email;
    @FXML
    private Button ok;
    @FXML
    private Button x;
    @FXML
    private Label warning;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void OkEmail(ActionEvent event)  {
        /*--------------------------TEST-EXISTANCE-EMAIL-------------------------------------------*/
      UserService us = new UserService();
    int n =   us.VerifyEmail(email.getText());
    if (n==1)
        warning.setText("Email existe!!!");
   if(n==2){
           JOptionPane.showMessageDialog(null,"EMAIL DOES NOT EXIST!!!");
   warning.setText("");
   }
    
   /*---------------------------------------------------------------------------------------------------*/
         
   
    }
    @FXML
    private void xEmail(ActionEvent event) {
          // get a handle to the stage
    Stage stage = (Stage) x.getScene().getWindow();
    // do what you have to do
    stage.close();
    }
    
}

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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author everyone
 */
public class ChangePasswordController implements Initializable {

    @FXML
    private TextField NewPassword;
    @FXML
    private Button change;
    @FXML
    private Button xChange;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ChangePassword(ActionEvent event) {
    }

    @FXML
    private void XChangePaswword(ActionEvent event) {
    }
    
}

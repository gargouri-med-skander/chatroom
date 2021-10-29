/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import static Gui.AuthentificationController.EmailLogin;
import entites.Admin;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.AdminService;

/**
 * FXML Controller class
 *
 * @author everyone
 */
public class AdminModifierController implements Initializable {

    @FXML
    private TextField firstName;
    @FXML
    private TextField LstName;
    @FXML
    private TextField adresse;
    @FXML
    private Button modifyy;
    @FXML
    private Button xModify;
    @FXML
    private TextField nposte;
      private final String EmailLogIN = AuthentificationController.EmailLogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifyM(ActionEvent event) {
        AdminService as=new AdminService ();
        Admin a =new Admin();
        a.setGmail(EmailLogin);
       
        a.setNom(LstName.getText());
        a.setAdresse(adresse.getText());
        a.setPrenom(firstName.getText());
     int post = Integer.parseInt(nposte.getText()); 
        a.setNumPoste(post);
    as.modifierAdmin(a);
      JOptionPane.showMessageDialog(null,"the modification made!!!");

        
        
    }

    @FXML
    private void xModifyMethod(ActionEvent event) {
          Stage stage = (Stage) xModify.getScene().getWindow();
    
    stage.close();
    }
    
}

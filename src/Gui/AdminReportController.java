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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author everyone
 */
public class AdminReportController implements Initializable {

    @FXML
    private Button memebersList;
    @FXML
    private Button themeList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void MemberMethod(ActionEvent event) throws IOException {
             Stage stage = (Stage) memebersList.getScene().getWindow();
    
    stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("AdminInterface.fxml"));
        Stage primaryStage=new Stage ();
        primaryStage.setTitle("AdminInterface!");
        primaryStage.setScene(new Scene(root, 1000, 1000));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @FXML
    private void themeMethod(ActionEvent event) throws IOException {
             Stage stage = (Stage) themeList.getScene().getWindow();
    
    stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("AdminTheme.fxml"));
        Stage primaryStage=new Stage ();
        primaryStage.setTitle("AdminTheme!");
        primaryStage.setScene(new Scene(root,1327, 879));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
}

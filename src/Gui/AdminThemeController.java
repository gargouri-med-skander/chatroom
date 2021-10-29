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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author everyone
 */
public class AdminThemeController implements Initializable {

    @FXML
    private TableView<?> tableauThemes;
    @FXML
    private Button addT;
    @FXML
    private Button banT;
    @FXML
    private Button reportList;
    @FXML
    private Button themeList;
    @FXML
    private TextField searchT;
    @FXML
    private TableView<?> tableauTG;
    @FXML
    private TextField searchTG;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddTMethod(ActionEvent event) {
    }

    @FXML
    private void banTMethod(ActionEvent event) {
    }

    @FXML
    private void reportMethod(ActionEvent event) throws IOException {
               Stage stage = (Stage) reportList.getScene().getWindow();
    
    stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("AdminReport.fxml"));
        Stage primaryStage=new Stage ();
        primaryStage.setTitle("AdminReport!");
        primaryStage.setScene(new Scene(root, 1000, 1000));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @FXML
    private void themeMethod(ActionEvent event) throws IOException {
             Stage stage = (Stage) themeList.getScene().getWindow();
    
    stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("AdminInterface.fxml"));
        Stage primaryStage=new Stage ();
        primaryStage.setTitle("AdminInterface!");
        primaryStage.setScene(new Scene(root, 1000, 1000));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @FXML
    private void searchTMethod(ActionEvent event) {
    }

    @FXML
    private void searchTGMethod(ActionEvent event) {
    }

    
}

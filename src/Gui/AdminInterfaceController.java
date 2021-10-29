/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import static Gui.AuthentificationController.EmailLogin;
import static Gui.ForgotPassword1Controller.randomCode;
import entites.User;
import entites.role;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import services.AdminService;
import services.UserService;
import utils.BaseDeDonnee;

/**
 * FXML Controller class
 *
 * @author everyone
 */
public class AdminInterfaceController implements Initializable {
 Connection connection ;
    PreparedStatement ps =null;
    ResultSet rs=null;
    @FXML
    private Button show;
    
    public AdminInterfaceController(){
        
   
        connection =   BaseDeDonnee.getInstance().getConnection();
    }
    @FXML
    private TableView<User> tableauMembre;
   
    @FXML
    private TableColumn<User, String> IdFirstName;

    @FXML
    private TableColumn<User, String> IdGmail;
    

    @FXML
    private TableColumn<User, String>IdLastName;
    
   
    
    @FXML
    private Button sendAlert;
    @FXML
    private Button ban;
    @FXML
    private Button reportList;
    @FXML
    private Button themeList;
    @FXML
    private TextField searchh;
    @FXML
    public  Label firstNamee;
    @FXML
    public   Label lastNamee;
    @FXML
    public  Label nposte;
    @FXML
    public   Label adressee;
    @FXML
    private Button modifyy;
    @FXML
    private Button logOut;
    
    @FXML
    private Button refresh;
    public final String EmailLogIN = AuthentificationController.EmailLogin;
User u = null ;
ObservableList<User> UserList = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 findt();

   
    }    
/*-------------------------------------SEND-MAIL-ALERT---------------------------------------------------------------------------------------------------------------------------*/
  public static void sendMailAlert(String receptient) throws Exception{
        System.out.println("Preparing to send email");
        Properties p = new Properties();
        p.put("mail.smtp.auth","true");
        p.put("mail.smtp.starttls.enable","true");
        p.put("mail.smtp.host","smtp.gmail.com");
        p.put("mail.smtp.port","587");
        
        String appAcountEmail="chat.rooms2022@gmail.com";
        String password ="ChatProject2022";
        
        Session s = Session.getInstance(p,new Authenticator(){
           @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(appAcountEmail,password);
            }
        });
        Message message = prepareMessage(s,appAcountEmail,receptient);
              Transport.send(message);
            System.out.println("Message sent successfully");

    }
    
    private static Message prepareMessage(Session s,String appAcountEmail,String receptient ){
        try{
            Message message = new MimeMessage(s);
            message.setFrom(new InternetAddress(appAcountEmail));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(receptient));   
            message.setSubject("WARNING");
          
            message.setText("THIS IS A WARNING EMAIL BEFORE THE ADMINISTOR BAN YOU!!!");
            return message ;
            
        }catch(MessagingException ex){
          
        }
        return null ;
    }
    
 
    
    /*---------------------------------FIND--------------------------------------------------------------------------------------------------------------------------------*/
    void findt(){
        connection = BaseDeDonnee.getInstance().getConnection();

        FilteredList<User> filteredData = new FilteredList<>(UserList, b -> true);
searchh.textProperty().addListener((observable, oldValue, newValue) -> {
filteredData.setPredicate(u -> {

if (newValue == null || newValue.isEmpty()) {
return true;
}
String lowerCaseFilter = newValue.toLowerCase();
				
if (u.getPrenom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
return true; 
} else if (u.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
return true; 
}
else if (String.valueOf(u.getGmail()).indexOf(lowerCaseFilter)!=-1)
return true;
  else  
return false; 
});
});
		
		
SortedList<User> sortedData = new SortedList<>(filteredData);
sortedData.comparatorProperty().bind(tableauMembre.comparatorProperty());
tableauMembre.setItems(sortedData);        
       

}
    /*------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    @FXML
    private void sendAlertMethod(ActionEvent event) throws Exception {
          
        u = tableauMembre.getSelectionModel().getSelectedItem();
                            FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("AdminInterface.fxml"));
                            
                            AdminInterfaceController aic = loader.getController();
                           // ajoutercommentaireController.setUpdate(true);
                            aic.  sendMailAlert (u.getGmail());
       
                         findt();
    }

    @FXML
    private void banMethod(ActionEvent event) throws SQLException {
        try {
            PreparedStatement preparedStatement=null;
                                u = tableauMembre.getSelectionModel().getSelectedItem();
                               String query = "DELETE FROM `user` WHERE `gmail`  ='"+u.getGmail()+"'";
                               
                                connection = BaseDeDonnee.getInstance().getConnection();
                                preparedStatement = connection.prepareStatement(query);
                          
                                preparedStatement.execute();
                       

                            } catch (SQLException ex) {
                                Logger.getLogger(AdminInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
                            }

               
                         findt();
                         refreshMethod();

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
        Parent root = FXMLLoader.load(getClass().getResource("AdminTheme.fxml"));
        Stage primaryStage=new Stage ();
        primaryStage.setTitle("AdminTheme!");
        primaryStage.setScene(new Scene(root, 1327, 879));
        primaryStage.setResizable(false);
        primaryStage.show();
        
    }

    @FXML
    private void searchMethod(ActionEvent event) {
    }

    @FXML
    private void modifyMethod(ActionEvent event) throws IOException {
        
       
     
              Parent root = FXMLLoader.load(getClass().getResource("AdminModifier.fxml"));
        Stage primaryStage=new Stage ();
        primaryStage.setTitle("AdminModifier!");
        primaryStage.setScene(new Scene(root, 700, 700));
        primaryStage.setResizable(false);
        primaryStage.show();
        
    }

    @FXML
    private void logOutMethod(ActionEvent event) throws IOException {
         Stage stage = (Stage) logOut.getScene().getWindow();
    
    stage.close();
       Parent root = FXMLLoader.load(getClass().getResource("Authentification.fxml"));
        stage.setTitle("Authentification!");
        stage.setScene(new Scene(root, 970, 546));
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    void showMethod(ActionEvent event) throws SQLException {
        
  
      
        String sql = "SELECT `adresse`,`num_poste` FROM `admin` where `gmail`='"+EmailLogin+"'";
         String sql1 = "SELECT `Nom`,`Prenom` FROM `user` where `gmail`='"+EmailLogin+"'";
        Statement statement = connection.createStatement();
 
        ResultSet result = statement.executeQuery(sql);
        while(result.next()){
            
     adressee.setText(result.getString("adresse"));
     
  int y=result.getInt("num_poste");
 String poste= Integer. toString(y);
   nposte.setText(poste);
  
        }
        
        ResultSet result1 = statement.executeQuery(sql1);
  while (result1.next()){
     firstNamee.setText(result1.getString("Nom"));
     
 lastNamee.setText(result1.getString("Prenom"));
      
  }
      

 
    
    }
   
        
        

   
    @FXML
    void refreshMethod() throws SQLException {
      
           UserList.clear();
         role x = role.Membre ;
            String query = "SELECT  `Nom`, `Prenom`, `gmail` FROM `user` WHERE  `role`='"+x+"'";
            ps = connection.prepareStatement(query);
            IdFirstName.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        IdLastName.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
       
        IdGmail.setCellValueFactory(new PropertyValueFactory<>("gmail"));
      
     

            rs = ps.executeQuery();
            
            while (rs.next()){
              
                UserList.add(new  User(
                   rs.getString("Nom"),
                   rs.getString("Prenom"),
                   rs.getString("gmail")
                     
                   
                ));
                       

                tableauMembre.setItems(UserList);
                 findt();




    
}
    }
    
}
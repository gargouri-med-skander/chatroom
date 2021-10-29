/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author everyone
 */
public class ForgotPassword1Controller implements Initializable {

    @FXML
    private Button ok;
    @FXML
    private Button x;
    @FXML
    private TextField email;
    protected static String codeM ;
    protected static String  emailR ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void okEmail(ActionEvent event) throws Exception {
        /*--------------------------TEST-EXISTANCE-EMAIL-IN-BD-----------------------------------------*/
      UserService us = new UserService();
    int n =   us.VerifyEmail(email.getText());
    if (n==1){
        
        sendMail(email.getText());
        ForgotPassword1Controller.emailR = email.getText();
         JOptionPane.showMessageDialog(null,"CHECK YOUR EMAIL!!!");
              Parent root = FXMLLoader.load(getClass().getResource("ChangePasswordd.fxml"));
        Stage primaryStage=new Stage ();
        primaryStage.setTitle("ChangePassword!");
        primaryStage.setScene(new Scene(root, 700, 700));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
       if(n==2){
           JOptionPane.showMessageDialog(null,"EMAIL DOES NOT EXIST!!!");
    }
    }
    @FXML
    private void xEmail(ActionEvent event) {
        Stage stage = (Stage) x.getScene().getWindow();

    stage.close();
    }
  
     /*--------------------------------------------SENDING-MAIL---------------------------------------------------------------------------------------------*/
    public static void sendMail(String receptient) throws Exception{
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
            message.setSubject("PASSWORD CHANGE");
          StringBuffer x = randomCode();
          ForgotPassword1Controller.codeM = x.toString() ;
            message.setText("Your code is "+ x.toString());
            return message ;
            
        }catch(MessagingException ex){
          
        }
        return null ;
    }
    
 public static StringBuffer randomCode(){
        Random dice = new Random();
        StringBuffer sb = new StringBuffer ();
            int number ;
            for(int i =1;i<=4;i++){
                number = 1+dice.nextInt(6);
                sb.append(number);
            }
            return sb ;
           
        
    }
 
    /*--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

  

    
}

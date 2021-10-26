/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;


import entites.User;
import entites.gender;
import entites.role;
import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author everyone
 */
public class InscriptionController implements Initializable {

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField gmail;
    @FXML
    private PasswordField newPassword;
    @FXML
    public  DatePicker birthday;
    @FXML
    private RadioButton femalee;
    @FXML
    private ToggleGroup genderr;
    @FXML
    private RadioButton malee;
    @FXML
    private RadioButton adminn;
    @FXML
    private ToggleGroup Rolee;
    @FXML
    private RadioButton membree;
    @FXML
    private Button signUp;
    @FXML
    private Button xSignUp;
     @FXML
    private TextField codee;
     @FXML
    private Label emailalert;
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
     @FXML
    String getDate(ActionEvent event) throws ParseException {
     LocalDate date = birthday.getValue();
    
        String x =date.toString();
    return x;

    }
    
    /*------------------------------------------VALIDATION-EMAIL--------------------------------------------------------------*/
       public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
}
    /*----------------------------HASH-PASSWORD--------------------------------------*/  
public static String hashMethod(String t) throws NoSuchAlgorithmException{
    
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(t.getBytes());
        byte[] r=m.digest();
        StringBuilder sb = new StringBuilder();
        for(byte b : r)
        {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
   
/*-------------------------------------------------------------------------------------*/
    @FXML
     void SignUpMethod(ActionEvent event) throws ParseException, IOException, NoSuchAlgorithmException {
              UserService us =new UserService();
        User u = new User();
        String test = "";
       int x =0 ;
       int y = 0 ;
       int z = 0 ;
        if(!test.equals(firstName.getText()))
           u.setPrenom(firstName.getText());
        else
        {
           JOptionPane.showMessageDialog(null,"You forget to put your first name!!!");
          x = 1 ;
        }
       
          if(!test.equals(lastName.getText()))  
        u.setNom(lastName.getText());
          else
          {
             JOptionPane.showMessageDialog(null,"You forget to put your last name!!!");
          y = 1 ; 
          }
        boolean testEmail = validate(gmail.getText());
        if((testEmail) &&(!test.equals(gmail.getText())))
        u.setGmail(gmail.getText());
        else
            emailalert.setText("invalid email !!!");
       if(!test.equals(newPassword.getText())) 
       {
      String hash = hashMethod(newPassword.getText());  
      u.setPassword(hash);
       }
       else{
             JOptionPane.showMessageDialog(null,"You forget to put your password!!!");
          z = 1 ; 
           
       }
       
   LocalDate date = birthday.getValue();
   u.setDateNaissance(date);
     if (genderr.getSelectedToggle().equals( malee)){
        
            u.setGender(gender.male);
           }
       if(genderr.getSelectedToggle().equals(femalee)){
         u.setGender(gender.female);}    
    if (membree.isSelected()){
            u.setRole(role.Membre);
           }
    /*----------------------------------------------VERIFICATION-ADMIN-------------------------------------------------------------------------------------------------------*/
    else 
    {
         String s1 = "admin"  ;
         if(s1.equals(codee.getText()))
        
           u.setRole(role.Admin);
         else{
             JOptionPane.showMessageDialog(null,"Wrong Code !!!");
              Stage stage = (Stage) signUp.getScene().getWindow();
    // do what you have to do
    stage.close();
         
         }
    }
    /*------------------------------------------------------------------------------------------------------------------------------------------------------*/    
        
        if((x==0)&&(y==0)&&(z==0))
        {
            us.ajouterUser(u);
         JOptionPane.showMessageDialog(null,"your account has been created successfully  !!!");
         Stage stage = (Stage) signUp.getScene().getWindow();
    
    stage.close();
        }
    }

     @FXML
   private void xSignUpM(ActionEvent event) {
       
    Stage stage = (Stage) xSignUp.getScene().getWindow();
    
    stage.close();
    }
}

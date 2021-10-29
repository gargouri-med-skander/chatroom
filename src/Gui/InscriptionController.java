/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;




import entites.Admin;
import entites.User;
import entites.gender;
import entites.role;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ResourceBundle;
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
import services.AdminService;
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
    private  DatePicker birthday;
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
     private String adminE;
    

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
   
/*------------------------------EXIST-EMAIL------------------------------------------------------*/
private final String apikey="7d104b06f7b036aefa586e6f7d507611";
   
  private StringBuffer checkEmail(String email) throws Exception {
      

   String url = "http://apilayer.net/api/check?access_key="+apikey+"&email="+email+"&smtp=1&format=1";
   
   URL urlobj = new URL(url);
   
   HttpURLConnection con = (HttpURLConnection) urlobj.openConnection();
   con.setRequestMethod("GET");

   con.setRequestProperty("User-Agent", "Chrome/17.0");
   BufferedReader in = new BufferedReader(
           new InputStreamReader(con.getInputStream()));
   String inputLine;
   StringBuffer response = new StringBuffer();

   while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
   }
   in.close();
   System.out.println(response.toString());
     return response ;
 
  }    
private boolean existEmail (String email) throws Exception{
  StringBuffer xx = new  StringBuffer();
  xx  =checkEmail(email);
int yy =xx.indexOf("found")+7;
 String xe =xx.substring(yy,yy+1);
  int zz =xx.indexOf("check")+7;
 String ze =xx.substring(zz,zz+1);
 if((xe.equals("t"))&&(ze.equals("t")))
     return true;
 else
     return false;
            
        }
    /*----------------------------------------------------------------------------------------------------------------------------------*/
    
@FXML
     void SignUpMethod(ActionEvent event) throws ParseException, IOException, NoSuchAlgorithmException, Exception {
              UserService us =new UserService();
        User u = new User();
        String test = "";
       int x =0 ;
       int y = 0 ;
       int z = 0 ;
       int e = 0 ;
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
       /*-------------------------------------------------EMAIL-VERIFICATION------------------------------------------------------*/ 
 try{
       boolean testEmailExist = existEmail (gmail.getText());
  if(testEmailExist){
   u.setGmail(gmail.getText());
    adminE=gmail.getText();
  }
  else{
     JOptionPane.showMessageDialog(null,"INVALID EMAIL!!!");  
     e = 1 ;
  }
 }catch(Exception ex){}
        /*--------------------------------------------------------------------------------------------------------------------------*/
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
         if(s1.equals(codee.getText())){
             AdminService as=new AdminService();
             Admin a = new Admin ();
             a.setGmail(adminE);
             
           as.ajouterAdmin( a);
           u.setRole(role.Admin);
         }
         else{
             JOptionPane.showMessageDialog(null,"Wrong Code !!!");
              Stage stage = (Stage) signUp.getScene().getWindow();
    // do what you have to do
    stage.close();
         
         }
    }
    /*------------------------------------------------------------------------------------------------------------------------------------------------------*/    
        
        if((x==0)&&(y==0)&&(z==0)&&(e==0))
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
   


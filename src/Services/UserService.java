/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.User;
import entites.gender;
import static entites.gender.male;
import entites.role;
import static entites.role.Admin;



import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import utils.BaseDeDonnee;

/**
 *
 * @author everyone
 */
public class UserService implements IUserService {
    
      /*------------------------------------------------------------------------------------*/  

    
    Connection connection ;
    public UserService(){
        connection =   BaseDeDonnee.getInstance().getConnection();
    }
    
    
      /*------------------------------------------------------------------------------------*/  

    @Override
    public void ajouterUser(User u) {
         
    
        try {
            String seq="INSERT INTO user (nom,prenom,gmail,password,gender,role,date_naissance)"+"VALUES (?,?,?,?,?,?,'"+u.getDateNaissance()+"')";
            PreparedStatement ps = connection.prepareStatement(seq);
            ps.setString(1,u.getNom());
            ps.setString(2,u.getPrenom());
            ps.setString(3,u.getGmail());
            ps.setString(4,u.getPassword());
            
            if(u.getGender()==male)
            ps.setString(5,gender.male.name() );
            else
             ps.setString(5,gender.female.name() );
          if(u.getRole()==Admin)
            ps.setString(6,role.Admin.name() );
            else
             ps.setString(6,role.Membre.name() );
           
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    
    }
      /*------------------------------------------------------------------------------------*/  


    @Override
    public void modifierUser(User u) {
        try {
        String sql = "UPDATE `user` SET `nom`=?,`prenom`=?,`date_naisance`='"+u.getDateNaissance()+"',`password`=?,`gender`=? WHERE `gmail`=?";
 
PreparedStatement  ps = connection.prepareStatement(sql);
   
ps.setString(1, u.getNom( ));
ps.setString(2, u.getPrenom());

ps.setString(5, u.getGmail());
ps.setString(3, u.getPassword());
/*statement.setString(6, u.getGender());*/
 if(u.getGender()==male)
            ps.setString(4,gender.male.name() );
            else
             ps.setString(4,gender.female.name() );
 
         
 
int rowsUpdated = ps.executeUpdate();
if (rowsUpdated > 0) {
    System.out.println("An existing user was updated successfully !!!");
}
} catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    
      /*------------------------------------------------------------------------------------*/  

    @Override
    public void supprimerUser(User u) {
         try {
        String seq ="DELETE FROM `User` WHERE `gmail`=?";
        PreparedStatement ps = connection.prepareStatement(seq);
       
            ps.setString(1,u.getGmail());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

    
    
      /*------------------------------------------------------------------------------------*/  

    @Override
    public void afficherUser() {
        try {
        String sql = "SELECT * FROM `user`";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
 
        int count = 0;
 
     while (result.next()){
    String nom = result.getString(2);
    String prenom = result.getString(3);
    Date date_naissance = result.getDate(4);
    String email = result.getString(5);
 
    String password = result.getString(6);
    String Gender = result.getString(7);
    String Role = result.getString(8);
    String output = "User #%d: %s - %s - %s - %s - %s - %s - %s";
    System.out.println(String.format(output, ++count, nom, prenom, date_naissance, email,password,Gender,Role));
}
     } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    /*-------------------------------------------------------------------------------------------------------------------------*/
        public int VerifyEmail(String x){
      try{  String sql="select * from user Where gmail='"+x+"'" ;
         Statement ps = connection.createStatement();
        
   ResultSet result = ps.executeQuery(sql);
       while (result.next()){
        boolean test = result.getBoolean("gmail");
        
      
        if(test==false)
            return 1 ;
       }
     
    }catch(SQLException ex){
      
             Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
           }
       return 2 ;
        }
    
}

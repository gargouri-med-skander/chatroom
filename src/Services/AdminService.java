/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.BaseDeDonnee;

/**
 *
 * @author everyone
 */
public class AdminService implements IAdminService {
    
   /*------------------------------------------------------------------------------------*/  
  
Connection connection ;
    public AdminService(){
     connection =   BaseDeDonnee.getInstance().getConnection();
    }
    
    
    
      /*------------------------------------------------------------------------------------*/  

    @Override
    public void ajouterAdmin(Admin a) {
    
        try {
            String seq="INSERT INTO `admin` (`adresse`,`num_poste`)"+"VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(seq);
            ps.setString(1,a.getAdresse());
            ps.setInt(2,a.getNumPoste());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
      /*------------------------------------------------------------------------------------*/  

    @Override
    public void modifierAdmin(Admin a) {
        
                try {
        String sql = "UPDATE `admin` SET `adresse`=?,`num_poste`=? WHERE `id_user`=?";
 
PreparedStatement  statement = connection.prepareStatement(sql);
     
statement.setString(1, a.getAdresse( ));
statement.setInt(2, a.getNumPoste());
statement.setInt(3, a.getIdUser());
 
int rowsUpdated = statement.executeUpdate();
if (rowsUpdated > 0) {
    System.out.println("Admin was updated successfully !!!");
}
} catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
      /*------------------------------------------------------------------------------------*/  

    @Override
    public void supprimerAdmin(Admin a) {
    }

    
    
      /*------------------------------------------------------------------------------------*/  

    @Override
    public void afficherAdmin() {
          try {
        String sql = "SELECT * FROM `user` where `Role`=Admin";
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
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

  
}

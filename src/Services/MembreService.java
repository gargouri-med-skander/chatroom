/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Membre;
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
public class MembreService implements IMembreService{
    
     /*------------------------------------------------------------------------------------*/  

    Connection connection ;
    public MembreService(){
        connection =   BaseDeDonnee.getInstance().getConnection();
    }
    
  
    
  /*------------------------------------------------------------------------------------*/  
    
    @Override
    public void ajouterMembre(Membre m) {
        try {
        String req ="INSERT INTO `membre`(`profession`) VALUES (`"+m.getProfession()+"`)";
        Statement   st = connection.createStatement();
         st.executeUpdate(req);          
         System.out.println("ajout avec successe !!!");

        } catch (SQLException ex) {
            Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("echec de l'ajout !!!");

        }
    }

 
    
    /*------------------------------------------------------------------------------------*/  
  
    
    @Override
    public void modifierMembre(Membre m) {
        
                   try {
        String sql = "UPDATE `admin` SET `profession`="+m.getProfession()+" WHERE `id_user`=?";
 
PreparedStatement  statement = connection.prepareStatement(sql);
     
/*statement.setString(1, m.getProfession( ));*/
statement.setInt(1, m.getIdUser());



 
int rowsUpdated = statement.executeUpdate();
if (rowsUpdated > 0) {
    System.out.println("Membre was updated successfully !!!");
}
} catch (SQLException ex) {
            Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    
    
    
      /*------------------------------------------------------------------------------------*/  

    
    @Override
    public void supprimerMembre(Membre m) {
    }

    
      /*------------------------------------------------------------------------------------*/  

    
    
    @Override
    public void afficherMembre() {
        
          try {
        String sql = "SELECT * FROM `user`where Role=`Membre`";
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
            Logger.getLogger(MembreService.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
}

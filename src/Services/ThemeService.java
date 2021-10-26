/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entites.Theme;
import java.sql.Connection;


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
public class ThemeService implements IThemeService{
    
      /*------------------------------------------------------------------------------------*/  

    Connection connection ;
    public ThemeService(){
        connection =   BaseDeDonnee.getInstance().getConnection();
    }

    
      /*------------------------------------------------------------------------------------*/  

    @Override
    public void ajouterTheme(Theme t) {
         try {
            String seq="INSERT INTO `theme` (`nom_theme`,`capacite`,`nbr_participant`,`visibilite`)"+"VALUES (?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(seq);
            ps.setString(1,t.getNomTheme());
            ps.setInt(2,t.getCapacite());
            ps.setInt(3,t.getNbrParticipant());
            ps.setBoolean(4,t.getVisibilite());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ThemeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
      /*------------------------------------------------------------------------------------*/  

    @Override
    public void modifierTheme(Theme t) {
        
          try {
        String sql = "UPDATE `theme` SET `nom_theme`=?,`capacite`=? WHERE `id_theme`=?";
 
PreparedStatement  statement = connection.prepareStatement(sql);
     
statement.setString(1, t.getNomTheme( ));
statement.setInt(2, t.getCapacite());

 
int rowsUpdated = statement.executeUpdate();
if (rowsUpdated > 0) {
    System.out.println("Theme was updated successfully !!!");
}
} catch (SQLException ex) {
            Logger.getLogger(ThemeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
      /*------------------------------------------------------------------------------------*/  


    @Override
    public void supprimerTheme(Theme t) {
        
        try {
        String seq ="DELETE FROM `theme` WHERE `id_theme`=?";
        PreparedStatement ps = connection.prepareStatement(seq);
       
            ps.setInt(1,t.getIdTheme());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ThemeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
      /*------------------------------------------------------------------------------------*/  


    @Override
    public void afficherTheme() {
        
        try {
        String sql = "SELECT * FROM `theme`";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
 
        int count = 0;
 
     while (result.next()){
    String nom_theme = result.getString(2);
    boolean visibilite = result.getBoolean(3);
    int capacite = result.getInt(4);
    int nbr_participant = result.getInt(5);
    String output = "User #%d: %s - %s - %s - %s ";
    System.out.println(String.format(output, ++count, nom_theme, visibilite, capacite, nbr_participant));
}
     } catch (SQLException ex) {
            Logger.getLogger(ThemeService.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
}

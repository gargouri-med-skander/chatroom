/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Gui.AdminInterfaceController;


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
            String x = "..";
            int y =0;
            String seq="INSERT INTO `admin` (adresse,num_poste,gmail)"+" VALUES ('"+x+"','"+y+"','"+a.getGmail()+"')";
            PreparedStatement ps = connection.prepareStatement(seq);
           
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
      /*------------------------------------------------------------------------------------*/  

    @Override
    public void modifierAdmin(Admin a) {
        
                try {
        String sql = "UPDATE `admin` SET `adresse`=?,`num_poste` =?  WHERE `gmail`='"+a.getGmail()+"'";
          String sql1 = "UPDATE `user` SET `nom`=?,`prenom` =?  WHERE `gmail`='"+a.getGmail()+"'";
 
PreparedStatement  statement = connection.prepareStatement(sql);
PreparedStatement  ps= connection.prepareStatement(sql1);
     
statement.setString(1, a.getAdresse( ));
statement.setInt(2, a.getNumPoste());
ps.setString(1, a.getNom());
ps.setString(2, a.getPrenom());
//statement.setString(3, a.getGmail());
//ps.setString(3, a.getGmail());

 
 statement.executeUpdate();

ps.executeUpdate();

} catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
      /*------------------------------------------------------------------------------------*/  

    @Override
    public void supprimerAdmin(Admin a) {
        
    }

    
    
      /*------------------------------------------------------------------------------------*/  

    
    

    
}

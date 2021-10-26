/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author everyone
 */
public class BaseDeDonnee {

    /*public static Object getInstanse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
    String url ="jdbc:mysql://localhost:3306/chatproject" ;
    String user ="root";
    String pwd = "";
    Connection connection;
    static BaseDeDonnee instance ;
    
    private BaseDeDonnee(){
        try {
            connection=DriverManager.getConnection(url,user,pwd);
            System.out.println("connection etablie a la base de donnee");

        } catch (SQLException ex) {
            System.out.println("erreur de connection a la base de donnee");
        }
    }
    
    public static BaseDeDonnee getInstance(){
    if(instance == null)
        instance = new BaseDeDonnee();
    return instance;
    }
    
    public Connection getConnection(){
    return connection;
    }
}

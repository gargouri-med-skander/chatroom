package Util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Connexion {
    
    final static String URL="jdbc:mysql://127.0.0.1:3306/JavaApplication1";
    final static String LOGIN = "root";
    final static String PWD = "";
    static Connexion instance =null;
    private Connection cnx;
    
    private Connexion ()
    {
        try {
            cnx = DriverManager.getConnection(URL,LOGIN,PWD);
            System.out.println("True");
        } catch (SQLException ex) {
            System.out.println("False");
        }
    }
    
    public static Connexion getInstance()
    {
        if (instance == null)
        {
            instance = new Connexion();
        }
        return instance;
    }
    
    public Connection getConnexion ()
    {
        return cnx;
    }
    
}

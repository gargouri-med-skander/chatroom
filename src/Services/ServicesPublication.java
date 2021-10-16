package Services;

import Entites.Publication;
import Util.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 *
 * @author JamelEdineMrad
 */
public class ServicesPublication implements IServicesPublication
{
    Connection cnx;
    
    public ServicesPublication() 
            {
                 this.cnx = Connexion.getInstance().getConnexion();
            }
    @Override
    public void add(Publication p) {
        try {
            String req = "INSERT INTO Publication (id_publication,date_publication,path_publication,) VALUES (?,?,?)";
            
         PreparedStatement ps = cnx.prepareStatement(req);
            
            ps.setInt(1, p.getIdPub());
            ps.setString(3, p.DatePublication.toString());
            ps.executeUpdate();
            
            System.out.println("publication ajoutée ...");
        } catch (SQLException ex) {
              System.out.println("cant add post");
              Logger.getLogger(ServicesPublication.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
    }

    @Override
    public void update(int IdPub) {
        try {
            String req = "UPDATE Publication SET path_Publication=? WHERE id_publication=?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(2, IdPub);
            ps.executeUpdate();
            System.out.println("update with sucess");
            
        } catch (SQLException ex) {
            Logger.getLogger(ServicesPublication.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void remove(int IdPub) {
        
        try {
            String req = "DELETE FROM publication where id_Publication = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, IdPub);
            ps.executeUpdate();
            System.out.println("supprimer avec sucess");
        } catch (SQLException ex) {
            
            Logger.getLogger(ServicesPublication.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    @Override
    public List<Publication> readAll() {
        List<Publication> Publications  = new ArrayList<Publication>();
        try {
            
            String req  = "SELECT * FROM publication";
            Statement ste  = cnx.createStatement();
            ResultSet rs  = ste.executeQuery(req);
            while(rs.next()){
                Date DatePublication  = rs.getDate(1);
                int IdPub  = rs.getInt(2);
                Path PathPublication = re.getPath(3);
                
                
                Publication p  = new Publication(IdPub);
                Publication.add(p);
                      
                        }
            
            System.out.println("show sucess");
        } catch (SQLException ex) {
            Logger.getLogger(ServicesPublication.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return publication;
    }
}

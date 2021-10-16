package Entites;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 *
 * @author JameledineMrad
 */
public class Publication {
    public Date DatePublication;
    public int IdPub;
    public Path PathPublication;
    public Path folder = Paths.get("/home/");
    
    public Publication(int n)
            {
                this.IdPub = n;
                this.DatePublication = new Date();
                this.PathPublication = Paths.get(URI.create("file:///home/File.txt"));
                
            }
    //getters setters
    public int getIdPub()
        {
            return IdPub;
        }
    
    public void setIdPub(int IdPub)
        {
            this.IdPub = IdPub;
        }
    
    public String getPathPublication()
        {
            return PathPublication.toString();
        }
    
    public void setPathPublication(Path PathPublication)
        {
            this.PathPublication = PathPublication ;
        }
    
    public Date getDatePublication()
        {
            return DatePublication;
        }
    
    public void setDatePublication(Date datePublication)
        {
            this.DatePublication = datePublication;
        }
    //affiche
    @Override
    public String toString()
        {
            return "id publication : " + IdPub + " , partagé le : " + DatePublication + " Path de la publication : " + PathPublication ;
        }
}

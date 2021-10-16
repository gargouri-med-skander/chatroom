
package Services;

import Entites.Publication;
import java.util.List;
/**
 *
 * @author JamelEdineMrad
 */
public interface IServicesPublication 
{
    public void add(Publication p) ;
    public void update(int IdPub);
    public void show();
    public void remove(int IdPub);
    public List<Publication> readAll();
}

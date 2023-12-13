
package interfaces;

import Dominio.Tramite;
import java.util.List;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
public interface ITramiteDAO {
    
    public Tramite createTramite(Tramite tramite);
    
    public Tramite readTramite(Tramite tramite);
    
    public Tramite updateTramite(Tramite tramite);
    
    public void deleteTramite(Tramite tramite);
    
    public List<Tramite> readAllTramite(Tramite tramite);
}

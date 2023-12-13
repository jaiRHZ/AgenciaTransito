
package interfaces;

import Dominio.Costo;
import java.util.List;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
public interface ICostoDAO {
    
    public Costo createCosto(Costo costo);
    
    public Costo readCosto(Costo costo);
    
    public Costo updateCosto(Costo costo);
    
    public void deleteCosto(Costo costo);
    
    public List<Costo> readAllCosto();
    
}

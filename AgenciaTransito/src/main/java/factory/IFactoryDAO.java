
package factory;

import interfaces.*;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
public interface IFactoryDAO {
    
    public ICostoDAO createCostoDAO();
    
    public IPagoDAO createPagoDAO();
    
    public IPersonaDAO createPersonaDAO();
    
    public ITramiteDAO createTramiteDAO();
    
    public IVehiculoDAO createVehiculoDAO();
    
}

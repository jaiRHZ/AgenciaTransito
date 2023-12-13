
package factory;

import conexionBD.ConexionBD;
import conexionBD.IConexionBD;
import implementacionDAO.CostoDAO;
import implementacionDAO.PagoDAO;
import implementacionDAO.PersonaDAO;
import implementacionDAO.TramiteDAO;
import implementacionDAO.VehiculoDAO;
import interfaces.ICostoDAO;
import interfaces.IPagoDAO;
import interfaces.IPersonaDAO;
import interfaces.ITramiteDAO;
import interfaces.IVehiculoDAO;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
public class FactoryDAO implements IFactoryDAO{

    private IConexionBD iConexionBD;

    public FactoryDAO() {
        this.iConexionBD = new ConexionBD();
    }
    
    @Override
    public ICostoDAO createCostoDAO() {
        return new CostoDAO(iConexionBD);
    }

    @Override
    public IPagoDAO createPagoDAO() {
        return new PagoDAO(iConexionBD);
    }

    @Override
    public IPersonaDAO createPersonaDAO() {
        return new PersonaDAO(iConexionBD);
    }

    @Override
    public ITramiteDAO createTramiteDAO() {
        return new TramiteDAO(iConexionBD);
    }

    @Override
    public IVehiculoDAO createVehiculoDAO() {
        return new VehiculoDAO(iConexionBD);
    }
    
}

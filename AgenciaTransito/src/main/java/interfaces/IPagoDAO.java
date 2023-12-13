
package interfaces;

import Dominio.Pago;
import java.util.List;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
public interface IPagoDAO {
    
    public Pago createPago(Pago pago);
    
    public Pago readPago(Pago pago);
    
    public Pago updatePago(Pago pago);
    
    public void deletePago(Pago pago);
    
    public List<Pago> updateAllPago(Pago pago);
}

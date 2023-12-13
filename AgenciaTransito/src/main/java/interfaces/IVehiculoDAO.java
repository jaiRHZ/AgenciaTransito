
package interfaces;

import Dominio.Vehiculo;
import java.util.List;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
public interface IVehiculoDAO {
    
    public Vehiculo createVehiculo(Vehiculo vehiculo);
    
    public Vehiculo readVehiculo(Vehiculo vehiculo);
    
    public Vehiculo updateVehiculo(Vehiculo vehiculo);
    
    public void deleteVehiculo(Vehiculo vehiculo);
    
    public List<Vehiculo> readAllVehiculo(Vehiculo vehiculo);
}

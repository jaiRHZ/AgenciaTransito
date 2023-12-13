
package interfaces;

import Dominio.Persona;
import java.util.List;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
public interface IPersonaDAO {
    
    public Persona createPersona(Persona persona);
    
    public Persona readPersona(Persona persona);
    
    public Persona updatePersona(Persona persona);
    
    public void deletePersona();
    
    public List<Persona> readAllPersona(Persona persona);
}


package conexionBD;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
public class ConexionBD implements IConexionBD{
    
    private static EntityManagerFactory factory;

    @Override
    public EntityManagerFactory useConnectionMySQL() {
    
        if (factory == null || !factory.isOpen()) {
            factory = Persistence.createEntityManagerFactory("persistenciaAgenciaTransito");
        }
        return factory;
    }
    
    /**
     * Cierra la factoría de entidades (EntityManagerFactory) si está abierta.
     */
    public static void closeEntityManagerFactory() {
        if (factory != null && factory.isOpen()) {
            factory.close();
        }
    }
    
}

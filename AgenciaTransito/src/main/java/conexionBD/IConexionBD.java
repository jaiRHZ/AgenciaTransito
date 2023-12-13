
package conexionBD;

import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
public interface IConexionBD {
    
     /**
     * Obtiene una instancia de EntityManagerFactory para la conexión a una base de datos MySQL.
     *
     * @return La factoría de entidades para la conexión a la base de datos.
     */
    EntityManagerFactory useConnectionMySQL();
}

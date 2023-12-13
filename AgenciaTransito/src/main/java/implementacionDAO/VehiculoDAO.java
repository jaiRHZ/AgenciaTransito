
package implementacionDAO;

import Dominio.Vehiculo;
import conexionBD.IConexionBD;
import interfaces.IVehiculoDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
public class VehiculoDAO implements IVehiculoDAO{

    IConexionBD iConexionBD;

    public VehiculoDAO(IConexionBD iConexionBD) {
        this.iConexionBD = iConexionBD;
    }
    
    @Override
    public Vehiculo createVehiculo(Vehiculo vehiculo) {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        
        try {
            bd.getTransaction().begin();
            bd.persist(vehiculo);
            bd.getTransaction().commit();
            return vehiculo;
        } catch (Exception ex) {
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
            
        } finally {
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
        return null;
    }

    @Override
    public Vehiculo readVehiculo(Vehiculo vehiculo) {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            Vehiculo vehiculoEncontrado = bd.find(Vehiculo.class, vehiculo.getSerie());
            bd.getTransaction().commit();
            return vehiculoEncontrado;
        } catch (Exception ex) {
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
        } finally {
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
        return null;
    }

    @Override
    public Vehiculo updateVehiculo(Vehiculo vehiculo) {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            Vehiculo vehiculoActualizado = bd.find(Vehiculo.class, vehiculo.getSerie());
            vehiculoActualizado.setModelo(vehiculo.getModelo());
            vehiculoActualizado.setColor(vehiculo.getColor());
            vehiculoActualizado.setLinea(vehiculo.getLinea());
            vehiculoActualizado.setMarca(vehiculo.getMarca());
            vehiculoActualizado.setPlaca(vehiculo.getPlaca());
            bd.merge(vehiculoActualizado);
            bd.getTransaction().commit();
            return vehiculoActualizado;
        } catch (Exception ex) {
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
        } finally {
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
        return null;
    }

    @Override
    public void deleteVehiculo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Vehiculo> readAllVehiculo(Vehiculo vehiculo) {
    
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            CriteriaBuilder builder = bd.getCriteriaBuilder();
            CriteriaQuery<Vehiculo> criteria = builder.createQuery(Vehiculo.class);
            Root<Vehiculo> root = criteria.from(Vehiculo.class);
            TypedQuery<Vehiculo> query = bd.createQuery(criteria);
            List<Vehiculo> vehiculos = query.getResultList();
            bd.getTransaction().commit();
            return vehiculos;

        } catch (Exception ex) {
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
        } finally {
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
        return null;
    }
    
    
}


package implementacionDAO;

import Dominio.Costo;
import conexionBD.IConexionBD;
import interfaces.ICostoDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
public class CostoDAO implements ICostoDAO{

    IConexionBD iConexionBD;

    public CostoDAO(IConexionBD iConexionBD) {
        this.iConexionBD = iConexionBD;
    }
    
    @Override
    public Costo createCosto(Costo costo) {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        
        try {
            bd.getTransaction().begin();
            bd.persist(costo);
            bd.getTransaction().commit();
            return costo;
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
    public Costo readCosto(Costo costo) {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            Costo costoEncontrado = bd.find(Costo.class, costo.getId());
            bd.getTransaction().commit();
            return costoEncontrado;
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
    public Costo updateCosto(Costo costo) {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            Costo costoActualizado = bd.find(Costo.class, costo.getId());
            costoActualizado.setCostoNormal(costo.getCostoNormal());
            costoActualizado.setTramite(costo.getTramite());
            bd.merge(costoActualizado);
            bd.getTransaction().commit();
            return costoActualizado;
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
    public void deleteCosto(Costo costo) {
        EntityManagerFactory em = iConexionBD.useConnectionMySQL();
        EntityManager bd = em.createEntityManager();
        try {
            bd.getTransaction().begin();
            try {
                costo = bd.find(Costo.class, costo.getId());
            } catch (EntityNotFoundException enfe) {
            }
            if (costo != null) {
                bd.remove(costo);
            }
            //comentario = em.merge(comentario);
            bd.getTransaction().commit();
        } finally {
            if (bd != null) {
                bd.close();
            }
        }
    }

    @Override
    public List<Costo> readAllCosto() {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            CriteriaBuilder builder = bd.getCriteriaBuilder();
            CriteriaQuery<Costo> criteria = builder.createQuery(Costo.class);
            Root<Costo> root = criteria.from(Costo.class);
            TypedQuery<Costo> query = bd.createQuery(criteria);
            List<Costo> costos = query.getResultList();
            bd.getTransaction().commit();
            return costos;

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

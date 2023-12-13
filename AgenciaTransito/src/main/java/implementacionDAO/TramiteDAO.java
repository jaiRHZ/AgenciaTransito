
package implementacionDAO;


import Dominio.Tramite;
import conexionBD.IConexionBD;
import interfaces.ITramiteDAO;
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
public class TramiteDAO implements ITramiteDAO{

    IConexionBD iConexionBD;

    public TramiteDAO(IConexionBD iConexionBD) {
        this.iConexionBD = iConexionBD;
    }
    
    @Override
    public Tramite createTramite(Tramite tramite) {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        
        try {
            bd.getTransaction().begin();
            bd.persist(tramite);
            bd.getTransaction().commit();
            return tramite;
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
    public Tramite readTramite(Tramite tramite) {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            Tramite tramiteEncontrado = bd.find(Tramite.class, tramite.getId());
            bd.getTransaction().commit();
            return tramiteEncontrado;
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
    public Tramite updateTramite(Tramite tramite) {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try{
            bd.getTransaction().begin();
            Tramite tramiteActualizado = bd.find(Tramite.class, tramite.getId());
            tramiteActualizado.setFechaExpedicion(tramite.getFechaExpedicion());
            tramiteActualizado.setEstado(tramite.getEstado());
            tramiteActualizado.setPersona(tramite.getPersona());
            tramiteActualizado.setCosto(tramite.getCosto());
            bd.merge(tramiteActualizado);
            bd.getTransaction().commit();
            return tramiteActualizado;
        }catch(Exception ex){
            bd.getTransaction().rollback();
            System.out.println(ex.getMessage());
        }
        finally{
            if (bd != null && bd.isOpen()) {
                bd.close();
            }
        }
        return null;
    }

    @Override
    public void deleteTramite() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Tramite> readAllTramite(Tramite tramite) {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            CriteriaBuilder builder = bd.getCriteriaBuilder();
            CriteriaQuery<Tramite> criteria = builder.createQuery(Tramite.class);
            Root<Tramite> root = criteria.from(Tramite.class);
            TypedQuery<Tramite> query = bd.createQuery(criteria);
            List<Tramite> tramites = query.getResultList();
            bd.getTransaction().commit();
            return tramites;

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


package implementacionDAO;

import Dominio.Costo;
import Dominio.Persona;
import conexionBD.IConexionBD;
import interfaces.IPersonaDAO;
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
public class PersonaDAO implements IPersonaDAO{

    IConexionBD iConexionBD;

    public PersonaDAO(IConexionBD iConexionBD) {
        this.iConexionBD = iConexionBD;
    }
    
    @Override
    public Persona createPersona(Persona persona) {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        
        try {
            bd.getTransaction().begin();
            bd.persist(persona);
            bd.getTransaction().commit();
            return persona;
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
    public Persona readPersona(Persona persona) {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            Persona personaEncontrado = bd.find(Persona.class, persona.getRfc());
            bd.getTransaction().commit();
            return personaEncontrado;
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
    public Persona updatePersona(Persona persona) {
        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try{
            bd.getTransaction().begin();
            Persona personaActualizada = bd.find(Persona.class, persona.getRfc());
            personaActualizada.setNombres(persona.getNombres());
            personaActualizada.setApellidoPaterno(persona.getApellidoPaterno());
            personaActualizada.setApellidoMaterno(persona.getApellidoMaterno());
            personaActualizada.setFechaNacimiento(persona.getFechaNacimiento());
            personaActualizada.setCurp(persona.getCurp());
            personaActualizada.setTelefono(persona.getTelefono());
            personaActualizada.setTramite(persona.getTramite());
            personaActualizada.setDiscapacidad(persona.getDiscapacidad());
            personaActualizada.setTramite(persona.getTramite());
            bd.merge(personaActualizada);
            bd.getTransaction().commit();
            return personaActualizada;
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
    public void deletePersona() {
    }

    @Override
    public List<Persona> readAllPersona(Persona persona) {

        EntityManagerFactory bdf = iConexionBD.useConnectionMySQL();
        EntityManager bd = bdf.createEntityManager();
        try {
            bd.getTransaction().begin();
            CriteriaBuilder builder = bd.getCriteriaBuilder();
            CriteriaQuery<Persona> criteria = builder.createQuery(Persona.class);
            Root<Persona> root = criteria.from(Persona.class);
            TypedQuery<Persona> query = bd.createQuery(criteria);
            List<Persona> personas = query.getResultList();
            bd.getTransaction().commit();
            return personas;

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

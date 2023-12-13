
package Dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
@Entity
@Table(name = "Tramites")
@DiscriminatorColumn(name = "tipo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Tramite implements Serializable{
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name  = "fechaExpedicion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaExpedicion;
    
    @Column( name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoTramite estado;
    
    //Relaciones
    @ManyToOne()
    @JoinColumn(name = "rfc", nullable = false)
    Persona persona;
    
    @ManyToOne()
    @JoinColumn(name = "id_costos", nullable = false)
    Costo Costo;
    
    
    //Constructores

    public Tramite() {
    }

    public Tramite(Long id, Date fechaExpedicion, EstadoTramite estado, Persona persona, Costo Costo) {
        this.id = id;
        this.fechaExpedicion = fechaExpedicion;
        this.estado = estado;
        this.persona = persona;
        this.Costo = Costo;
    }

    public Tramite(Date fechaExpedicion, EstadoTramite estado, Persona persona, Costo Costo) {
        this.fechaExpedicion = fechaExpedicion;
        this.estado = estado;
        this.persona = persona;
        this.Costo = Costo;
    }
    
    //Getter and setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public EstadoTramite getEstado() {
        return estado;
    }

    public void setEstado(EstadoTramite estado) {
        this.estado = estado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Costo getCosto() {
        return Costo;
    }

    public void setCosto(Costo Costo) {
        this.Costo = Costo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tramite other = (Tramite) obj;
        return Objects.equals(this.id, other.id);
    }
    
    //To string

    @Override
    public String toString() {
        return "Tramite{" + "id=" + id + ", fechaExpedicion=" + fechaExpedicion + ", estado=" + estado + ", persona=" + persona + ", Costo=" + Costo + '}';
    }
    
}


package Dominio;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
@Entity
@DiscriminatorValue(value = "Licencias")
public class Licencia extends Tramite{
    
    //Atributos
    @Column(name ="fechaExpiracion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaExpiracion;
    
    //Constructores

    public Licencia() {
    }

    public Licencia(Date fechaExpiracion, Long id, Date fechaExpedicion, EstadoTramite estado, Persona persona, Dominio.Costo Costo) {
        super(id, fechaExpedicion, estado, persona, Costo);
        this.fechaExpiracion = fechaExpiracion;
    }

    public Licencia(Date fechaExpiracion, Date fechaExpedicion, EstadoTramite estado, Persona persona, Dominio.Costo Costo) {
        super(fechaExpedicion, estado, persona, Costo);
        this.fechaExpiracion = fechaExpiracion;
    }
    
    //Getter and setter

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
    
    //To string

    @Override
    public String toString() {
        return "Licencia{" + "fechaExpiracion=" + fechaExpiracion + '}';
    }
    
}

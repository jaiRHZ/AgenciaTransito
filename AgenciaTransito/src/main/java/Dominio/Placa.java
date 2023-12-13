
package Dominio;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
@Entity
@DiscriminatorValue(value = "Placas")
public class Placa extends Tramite{
    
    //Atributos de la clase
    @Column(name = "noAlfanumerico",nullable = false, length = 7)
    private Float noAlfanumerico;
    
    @Column(name = "fechaRecepcion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaRecepcion;
    
    //Relaciones
    @ManyToOne()
    @JoinColumn(name = "serie", nullable = false)
    private Vehiculo vehiculo;
    
    //Constructores

    public Placa() {
    }

    public Placa(Float noAlfanumerico, Date fechaRecepcion, Vehiculo vehiculo, Long id, Date fechaExpedicion, EstadoTramite estado, Persona persona, Dominio.Costo Costo) {
        super(id, fechaExpedicion, estado, persona, Costo);
        this.noAlfanumerico = noAlfanumerico;
        this.fechaRecepcion = fechaRecepcion;
        this.vehiculo = vehiculo;
    }

    public Placa(Float noAlfanumerico, Date fechaRecepcion, Vehiculo vehiculo, Date fechaExpedicion, EstadoTramite estado, Persona persona, Dominio.Costo Costo) {
        super(fechaExpedicion, estado, persona, Costo);
        this.noAlfanumerico = noAlfanumerico;
        this.fechaRecepcion = fechaRecepcion;
        this.vehiculo = vehiculo;
    }
    
    //Getter and setter

    public Float getNoAlfanumerico() {
        return noAlfanumerico;
    }

    public void setNoAlfanumerico(Float noAlfanumerico) {
        this.noAlfanumerico = noAlfanumerico;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    //To string

    @Override
    public String toString() {
        return "Placa{" + "noAlfanumerico=" + noAlfanumerico + ", fechaRecepcion=" + fechaRecepcion + ", vehiculo=" + vehiculo + '}';
    }
    
    
}

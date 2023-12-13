
package Dominio;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
@Entity
@Table(name = "Pagos")
public class Pago implements Serializable{
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "monto", nullable = false)
    private Float monto;
    
    //Relaciones
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_tramite")
    private Tramite Tramite;
    
    //Constructores

    public Pago() {
    }

    public Pago(int id, Float monto, Tramite Tramite) {
        this.id = id;
        this.monto = monto;
        this.Tramite = Tramite;
    }

    public Pago(Float monto, Tramite Tramite) {
        this.monto = monto;
        this.Tramite = Tramite;
    }
    
    //Getter and setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Tramite getTramite() {
        return Tramite;
    }

    public void setTramite(Tramite Tramite) {
        this.Tramite = Tramite;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
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
        final Pago other = (Pago) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Pago{" + "id=" + id + ", monto=" + monto + ", Tramite=" + Tramite + '}';
    }
    
}

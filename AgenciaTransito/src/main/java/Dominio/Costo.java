
package Dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
@Entity
@Table(name = "Costos")
@DiscriminatorColumn(name = "tipo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Costo implements Serializable{
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "costoNormal", nullable = false)
    private Float costoNormal;
    
    //Relaciones
    @OneToMany(mappedBy = "costo")
    private List<Tramite> tramite;
    
    //Constructores

    public Costo() {
    }

    public Costo(int id, Float costoNormal, List<Tramite> tramite) {
        this.id = id;
        this.costoNormal = costoNormal;
        this.tramite = tramite;
    }

    public Costo(Float costoNormal, List<Tramite> tramite) {
        this.costoNormal = costoNormal;
        this.tramite = tramite;
    }

    public Costo(Float costoNormal) {
        this.costoNormal = costoNormal;
    }
    
    //Getter and setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getCostoNormal() {
        return costoNormal;
    }

    public void setCostoNormal(Float costoNormal) {
        this.costoNormal = costoNormal;
    }

    public List<Tramite> getTramite() {
        return tramite;
    }

    public void setTramite(List<Tramite> tramite) {
        this.tramite = tramite;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
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
        final Costo other = (Costo) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Costo{" + "id=" + id + ", costoNormal=" + costoNormal + ", tramite=" + tramite + '}';
    }
    
    
}

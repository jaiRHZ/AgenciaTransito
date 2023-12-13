
package Dominio;


import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
@Entity
@DiscriminatorValue(value = "TarifaLicencias")
public class TarifaLicencia extends Costo{
    
    @Column(name = "precioDiscapacitado", nullable = false)
    private Float precioDiscapacitado;
    
    @Column(name = "vigencia", nullable = false)
    @Enumerated(EnumType.STRING)
    private VigenciaTarifaLicencia vigencia;
    
    //Constructores

    public TarifaLicencia() {
    }

    public TarifaLicencia(Float precioDiscapacitado, VigenciaTarifaLicencia vigencia, int id, Float costoNormal, List<Tramite> tramite) {
        super(id, costoNormal, tramite);
        this.precioDiscapacitado = precioDiscapacitado;
        this.vigencia = vigencia;
    }

    public TarifaLicencia(Float precioDiscapacitado, VigenciaTarifaLicencia vigencia, Float costoNormal, List<Tramite> tramite) {
        super(costoNormal, tramite);
        this.precioDiscapacitado = precioDiscapacitado;
        this.vigencia = vigencia;
    }

    public TarifaLicencia(Float precioDiscapacitado, VigenciaTarifaLicencia vigencia, Float costoNormal) {
        super(costoNormal);
        this.precioDiscapacitado = precioDiscapacitado;
        this.vigencia = vigencia;
    }

    //Getter and setter

    public Float getPrecioDiscapacitado() {
        return precioDiscapacitado;
    }

    public void setPrecioDiscapacitado(Float precioDiscapacitado) {
        this.precioDiscapacitado = precioDiscapacitado;
    }

    public VigenciaTarifaLicencia getVigencia() {
        return vigencia;
    }

    public void setVigencia(VigenciaTarifaLicencia vigencia) {
        this.vigencia = vigencia;
    }
    
    //To string

    @Override
    public String toString() {
        return "TarifaLicencia{" + "precioDiscapacitado=" + precioDiscapacitado + ", vigencia=" + vigencia + '}';
    }
    
}

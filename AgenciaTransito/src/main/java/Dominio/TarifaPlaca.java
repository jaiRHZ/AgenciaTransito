
package Dominio;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
@Entity
@DiscriminatorValue(value = "TarifaPlacas")
public class TarifaPlaca extends Costo{
    
    //Atributos de la clase
    @Column(name = "condicion", nullable = true)
    @Enumerated(EnumType.STRING)
    private CondicionVehiculo condicionVehiculo;
    
    //Constructores

    public TarifaPlaca() {
    }

    public TarifaPlaca(CondicionVehiculo condicionVehiculo, int id, Float costoNormal, List<Tramite> tramite) {
        super(id, costoNormal, tramite);
        this.condicionVehiculo = condicionVehiculo;
    }

    public TarifaPlaca(CondicionVehiculo condicionVehiculo, Float costoNormal, List<Tramite> tramite) {
        super(costoNormal, tramite);
        this.condicionVehiculo = condicionVehiculo;
    }

    public TarifaPlaca(CondicionVehiculo condicionVehiculo, Float costoNormal) {
        super(costoNormal);
        this.condicionVehiculo = condicionVehiculo;
    }
    
    //Getter and setter

    public CondicionVehiculo getCondicionVehiculo() {
        return condicionVehiculo;
    }

    public void setCondicionVehiculo(CondicionVehiculo condicionVehiculo) {
        this.condicionVehiculo = condicionVehiculo;
    }

    @Override
    public String toString() {
        return "TarifaPlaca{" + "condicionVehiculo=" + condicionVehiculo + '}';
    }
    
}

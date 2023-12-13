
package Dominio;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
@Entity
@DiscriminatorValue(value = "Automoviles")
public class Automovil extends Vehiculo{

    //Constructores
    public Automovil() {
    }

    public Automovil(String serie, String modelo, String color, String linea, String marca, List<Placa> placa) {
        super(serie, modelo, color, linea, marca, placa);
    }

    public Automovil(String modelo, String color, String linea, String marca, List<Placa> placa) {
        super(modelo, color, linea, marca, placa);
    }

    public Automovil(String serie, String modelo, String color, String linea, String marca) {
        super(serie, modelo, color, linea, marca);
    }
   
    
}

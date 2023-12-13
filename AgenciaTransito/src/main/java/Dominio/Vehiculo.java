

package Dominio;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
@Entity
@Table(name = "Vehiculos")
@DiscriminatorColumn(name = "tipo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Vehiculo implements Serializable{
    
    //Atributos de la clase
    @Id
    @Column(name = "serie", length = 17)
    private String serie;
    
    @Column(name = "modelo", nullable = false)
    private String modelo;
    
    @Column(name = "color", nullable = false)
    private String color;
    
    @Column(name = "linea", nullable = false)
    private String linea;
    
    @Column(name = "marca", nullable = false)
    private String marca;
    
    //Relaciones
    @OneToMany(mappedBy = "vehiculos")
    private List<Placa> placa;
    
    //Constructores

    public Vehiculo() {
    }

    public Vehiculo(String serie, String modelo, String color, String linea, String marca, List<Placa> placa) {
        this.serie = serie;
        this.modelo = modelo;
        this.color = color;
        this.linea = linea;
        this.marca = marca;
        this.placa = placa;
    }

    public Vehiculo(String modelo, String color, String linea, String marca, List<Placa> placa) {
        this.modelo = modelo;
        this.color = color;
        this.linea = linea;
        this.marca = marca;
        this.placa = placa;
    }

    public Vehiculo(String serie, String modelo, String color, String linea, String marca) {
        this.serie = serie;
        this.modelo = modelo;
        this.color = color;
        this.linea = linea;
        this.marca = marca;
    }
    
    //Getter and setter

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public List<Placa> getPlaca() {
        return placa;
    }

    public void setPlaca(List<Placa> placa) {
        this.placa = placa;
    }
    
    //Hash Code

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.serie);
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
        final Vehiculo other = (Vehiculo) obj;
        return Objects.equals(this.serie, other.serie);
    }
    
    //To String

    @Override
    public String toString() {
        return "Vehiculo{" + "serie=" + serie + ", modelo=" + modelo + ", color=" + color + ", linea=" + linea + ", marca=" + marca + ", placa=" + placa + '}';
    }
    
}

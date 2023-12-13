
package Dominio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Jairo G. Rodriguez Hernandez 00000213248
 */
@Entity
@Table(name  = "Personas")
public class Persona implements Serializable {
    
    @Id
    @Column(name = "rfc", length = 13)
    private String rfc;
    
    @Column(name = "nombres", nullable = false, length = 255)
    private String nombres;
    
    @Column(name = "apellidoPaterno", nullable = false, length = 255)
    private String apellidoPaterno;
    
    @Column(name = "apellidoMaterno", nullable = false, length = 255)
    private String apellidoMaterno;
    
    @Column(name = "fechaNacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento;
    
    @Column(name = "discapacidad", nullable = false)
    private Boolean discapacidad;
    
    @Column(name = "telefono", nullable = false)
    private String telefono;
    
    @Column(name = "curp", nullable = false, length = 18)
    private String curp;
    
    //Relaciones
    @OneToMany(mappedBy = "personas")
    private List<Tramite> tramite;
    
    //Constructores

    public Persona() {
    }

    public Persona(String rfc, String nombres, String apellidoPaterno, String apellidoMaterno, Calendar fechaNacimiento, Boolean discapacidad, String telefono, String curp) {
        this.rfc = rfc;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.discapacidad = discapacidad;
        this.telefono = telefono;
        this.curp = curp;
    }

    public Persona(String rfc, String nombres, String apellidoPaterno, String apellidoMaterno, Calendar fechaNacimiento, Boolean discapacidad, String telefono, String curp, List<Tramite> tramite) {
        this.rfc = rfc;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.discapacidad = discapacidad;
        this.telefono = telefono;
        this.curp = curp;
        this.tramite = tramite;
    }
    
    //Getter and setter

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Boolean getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(Boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public List<Tramite> getTramite() {
        return tramite;
    }

    public void setTramite(List<Tramite> tramite) {
        this.tramite = tramite;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.rfc);
        return hash;
    }

    //Otros metodos
    public int getEdad() {
        Calendar ahora = Calendar.getInstance();
        
        long edadEnDias = (ahora.getTimeInMillis() - fechaNacimiento.getTimeInMillis()) / 1000 / 60 / 60 / 24;
        int anios = Double.valueOf(edadEnDias / 365.25d).intValue();

        return anios;
    }
    
    //Hash
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
        final Persona other = (Persona) obj;
        return Objects.equals(this.rfc, other.rfc);
    }

    @Override
    public String toString() {
        return "Persona{" + "rfc=" + rfc + ", nombres=" + nombres + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", fechaNacimiento=" + fechaNacimiento + ", discapacidad=" + discapacidad + ", telefono=" + telefono + ", curp=" + curp + ", tramite=" + tramite + '}';
    }
    
    
    
}

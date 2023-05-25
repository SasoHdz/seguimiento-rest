package com.itq.seguimientorest.dto;
import javax.validation.constraints.*;


public class Direccion {
    @Pattern(regexp = "\\d{5}", message = "El formato es ddddd. Ejemplo: 76672")
    String codigo_postal;

    @Size(min = 3, max = 180, message = "El nombre es muy corto")
    String calle;

    @Size(min = 3, max = 180, message = "El nombre es muy corto")
    String colonia;

    @Pattern(regexp = "\\#\\d{1,9}", message = "El formato es #dd. Ejemplo: #22")
    String numero;

    public Direccion() {
    }

    public Direccion(String codigo_postal, String calle, String colonia, String numero) {
        this.codigo_postal = codigo_postal;
        this.calle = calle;
        this.colonia = colonia;
        this.numero = numero;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}

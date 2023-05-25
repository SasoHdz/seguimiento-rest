package com.itq.seguimientorest.dto;

import javax.validation.constraints.*;

public class Ubicacion {

    Integer id_ubicacion;

    @Pattern(regexp = "^(90|\\d{1,2})°\\s([0-5]?\\d)′\\s([0-5]?\\d)″\\s([NS])$", message = "El formato debe ser: 19° 25′ 42″ N")
    String latitud;

    @Pattern(regexp = "^(180|\\d{1,2})°\\s([0-5]?\\d)′\\s([0-5]?\\d)″\\s([EO])$", message = "El formato debe ser: 99° 7′ 39″ O")
    String longitud;

    @Size(min=10,max = 180, message = "La descripcion es muy corta")
    String descripcion;

    public Ubicacion(Integer id_ubicacion, String latitud, String longitud, String descripcion) {
        this.id_ubicacion = id_ubicacion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.descripcion = descripcion;
    }

    public Integer getId_ubicacion() {
        return id_ubicacion;
    }

    public void setId_ubicacion(Integer id_ubicacion) {
        this.id_ubicacion = id_ubicacion;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}

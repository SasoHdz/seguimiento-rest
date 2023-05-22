package com.itq.seguimientorest.entity;

import javax.persistence.*;

@Entity
@Table(name = "UBICACIONES")
public class Ubicaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_UBICACION")
    private Integer idUbicacion;

    @Column(name = "LATITUD", nullable = false)
    private String latitud;

    @Column(name = "LONGITUD", nullable = false)
    private String longitud;

    @Column(name = "DESCRIPCION", nullable = false)
    private String  descripcion;

    // Constructor vacío necesario para JPA
    public Ubicaciones() {}

    public Ubicaciones(String latitud, String longitud, String description) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.descripcion = description;
    }

    public Ubicaciones(Integer idUbicacion){
        this.idUbicacion = idUbicacion;
    }

    public Integer getId() {
        return idUbicacion;
    }

    public void setId(Integer id) {
        this.idUbicacion = id;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLongitud() {
        return longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public String getDescripcion() {
        return descripcion;
    }
}

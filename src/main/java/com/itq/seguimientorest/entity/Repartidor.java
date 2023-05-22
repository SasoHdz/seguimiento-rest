package com.itq.seguimientorest.entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "REPARTIDORES")
public class Repartidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_REPARTIDOR")
    private Integer idRepartidor;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "TELEFONO", unique = true, nullable = false)
    private String telefono;

    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "FECHA_NACIMIENTO", nullable = false)
    private Date fechaNacimiento;

    // Constructor vacío
    public Repartidor() {
    }

    // Constructor con parámetros
    public Repartidor(String nombre, String telefono, String email, String password, Date fechaNacimiento) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
    }
    // Getters y setters
    public Integer getIdRepartidor() {
        return idRepartidor;
    }

    public void setIdRepartidor(Integer idRepartidor) {
        this.idRepartidor = idRepartidor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}


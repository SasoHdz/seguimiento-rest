package com.itq.seguimientorest.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Repartidor {

    @NotNull
    Integer id_repartidor;

    @NotEmpty
    String nombre;

    String a_paterno;
    String a_materno;

    @Pattern(regexp = "\\d{10}")
    String telefono;

    @Pattern(regexp = "^[\\w.-]+@[a-zA-Z_-]+?(?:\\.[a-zA-Z]{2,})+$")
    String email;

    @Size(min = 10, max = 120)
    String password;

    @Pattern(regexp = "^(\\d{4})-(\\d{2})-(\\d{2})$")
    String fecha_nacimiento;

    public Repartidor(Integer id_repartidor, String nombre, String a_paterno, String a_materno,
            String telefono, String email, String password, String fecha_nacimiento) {
        this.id_repartidor = id_repartidor;
        this.nombre = nombre;
        this.a_paterno = a_paterno;
        this.a_materno = a_materno;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Integer getId_repartidor() {
        return id_repartidor;
    }

    public void setId_repartidor(Integer id_repartidor) {
        this.id_repartidor = id_repartidor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getA_paterno() {
        return a_paterno;
    }

    public void setA_paterno(String a_paterno) {
        this.a_paterno = a_paterno;
    }

    public String getA_materno() {
        return a_materno;
    }

    public void setA_materno(String a_materno) {
        this.a_materno = a_materno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
}

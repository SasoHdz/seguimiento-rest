package com.itq.seguimientorest.dto;
import javax.validation.constraints.*;

public class Usuario {

    @NotEmpty
    Integer id_usuario;

    @NotEmpty
    String nombre;


    String a_paterno;
    String a_materno;

    @NotEmpty
    Direccion direccion;

    @Pattern(regexp = "\\d{10}")
    String telefono;

    @Pattern(regexp = "^[\\w.-]+@[a-zA-Z_-]+?(?:\\.[a-zA-Z]{2,})+$")
    String email;

    @Size(min = 10, max = 120)
    String password;

    @Pattern(regexp = "^(\\d{4})-(\\d{2})-(\\d{2})$")
    String fecha_nacimiento;

    public Usuario() {
    }

    public Usuario(Integer id_usuario, String nombre, String a_paterno, String a_materno, Direccion direccion,
            String telefono, String email, String password, String fecha_nacimiento) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.a_paterno = a_paterno;
        this.a_materno = a_materno;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
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

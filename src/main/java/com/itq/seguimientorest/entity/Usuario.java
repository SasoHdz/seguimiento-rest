package com.itq.seguimientorest.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "USUARIOS")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "A_PATERNO", nullable = false)
    private String a_paterno;

    @Column(name = "A_MATERNO", nullable = false)
    private String a_materno;

    @Column(name = "DIRECCION", nullable = false)
    private String direccion;

    @Column(name = "TELEFONO", unique = true, nullable = false)
    private String telefono;

    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "FECHA_NACIMIENTO", nullable = false)
    private Date fechaNacimiento;

    // Constructor vacío
    public Usuario() {
    }

    // Constructor con parámetros
    public Usuario(String nombre,String a_paterno,String a_materno, String direccion, String telefono, String email, String password, Date fechaNacimiento) {
        this.nombre = nombre;
        this.a_paterno = a_paterno;
        this.a_materno = a_materno;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Usuario(Integer idUsuario, String nombre,String a_paterno,String a_materno, String direccion, String telefono, String email, String password, Date fechaNacimiento) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.a_paterno = a_paterno;
        this.a_materno = a_materno;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Usuario(Integer idUsuario){
        this.idUsuario = idUsuario;
    }

    // Getters y setters
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}


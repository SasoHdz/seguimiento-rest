package com.itq.seguimientorest.entity;

import java.sql.Date;
//import java.util.List;
import java.util.Optional;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "PAQUETES")
public class Paquetes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PAQUETE")
    private Integer idPaquete;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "PESO")
    private Float peso;

    @Column(name = "DIMENSIONES")
    private String dimensiones;

    @Column(name = "DIRECCION_ENTREGA")
    private String direccionEntrega;

    @Column(name = "FECHA_CREACION")
    private Date fechaCreacion;

    @Column(name = "ESTADO")
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USUARIO_REMITENTE", referencedColumnName = "ID_USUARIO")
    private Usuario remitente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USUARIO_DESTINATARIO", referencedColumnName = "ID_USUARIO")
    private Usuario destinatario;

    // @OneToMany(mappedBy = "paquete")
    // private List<RegistroPaquete> registroPaquetes;

    // constructor vacío
    public Paquetes() {
    }

    // constructor con parámetros
    public Paquetes(String descripcion, Float peso, String dimensiones, String direccionEntrega, Date fechaCreacion,
            String estado, Usuario remitente, Usuario destinatario) {
        this.descripcion = descripcion;
        this.peso = peso;
        this.dimensiones = dimensiones;
        this.direccionEntrega = direccionEntrega;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.remitente = remitente;
        this.destinatario = destinatario;
    }

    public Paquetes(String descripcion2, Float peso2, String dimensiones2, String direccionEntrega2, Date fechaHoy,
            String estado2, Optional<Usuario> remitente2, Optional<Usuario> destinatario2) {
    }

    // getters y setters
    public Integer getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(Integer idPaquete) {
        this.idPaquete = idPaquete;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getRemitente() {
        return remitente;
    }

    public Integer getIdRemitente(Usuario u) {
        return u.getIdUsuario();
    }

    public Integer getIdDestinatario(Usuario u) {
        return u.getIdUsuario();
    }

    public void setRemitente(Usuario remitente) {
        this.remitente = remitente;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "idPaquete=" + idPaquete +
                ", descripcion='" + descripcion + '\'' +
                ", peso=" + peso +
                ", dimensiones='" + dimensiones + '\'' +
                ", direccionEntrega='" + direccionEntrega + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", estado='" + estado + '\'' +
                ", remitente=" + remitente + // Aquí debes agregar el método que retorna el nombre completo del usuario
                ", destinatario=" + destinatario + // Aquí debes agregar el método que retorna el nombre completo del
                                                   // usuario
                '}';
    }

}

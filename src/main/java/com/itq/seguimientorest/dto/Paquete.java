package com.itq.seguimientorest.dto;
import javax.validation.constraints.*;


public class Paquete {
    Integer id_paquete;

    @Size(min = 10 , max = 180, message = "La descripcion es muy corta")
    String descripcion;

    @NotNull
    Float peso;

    @Pattern(regexp = "\\d+x\\d+x?\\d+")
    String dimensiones;

    Direccion direccion_entrega;

    @Pattern(regexp = "\\d{4}\\-\\d{2}\\-\\d{2}", message = "El formato es yyyy-mm-dd")
    String fecha_creacion;

    @Size(min = 3, max = 180, message = "El estado es muy corto")
    String estado;

    @NotNull
    Integer id_usuario_remitente;

    @NotNull
    Integer id_usuario_destinatario;

    public Paquete(Integer id_paquete, String descripcion, Float peso, String dimensiones, Direccion direccion_entrega,
            String fecha_creacion, String estado, Integer id_usuario_remitente, Integer id_usuario_destinatario) {
        this.id_paquete = id_paquete;
        this.descripcion = descripcion;
        this.peso = peso;
        this.dimensiones = dimensiones;
        this.direccion_entrega = direccion_entrega;
        this.fecha_creacion = fecha_creacion;
        this.estado = estado;
        this.id_usuario_remitente = id_usuario_remitente;
        this.id_usuario_destinatario = id_usuario_destinatario;
    }

    public Integer getId_paquete() {
        return id_paquete;
    }

    public void setId_paquete(Integer id_paquete) {
        this.id_paquete = id_paquete;
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

    public Direccion getDireccion_entrega() {
        return direccion_entrega;
    }

    public void setDireccion_entrega(Direccion direccion_entrega) {
        this.direccion_entrega = direccion_entrega;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getId_usuario_remitente() {
        return id_usuario_remitente;
    }

    public void setId_usuario_remitente(Integer id_usuario_remitente) {
        this.id_usuario_remitente = id_usuario_remitente;
    }

    public Integer getId_usuario_destinatario() {
        return id_usuario_destinatario;
    }

    public void setId_usuario_destinatario(Integer id_usuario_destinatario) {
        this.id_usuario_destinatario = id_usuario_destinatario;
    }

    public String getDicToString() {
        return this.getDireccion_entrega().codigo_postal +" "+ this.getDireccion_entrega().colonia
        +" "+ this.getDireccion_entrega().calle +" "+ this.getDireccion_entrega().numero;
    }
}

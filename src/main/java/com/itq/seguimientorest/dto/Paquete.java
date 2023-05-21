package com.itq.seguimientorest.dto;

public class Paquete {
    Integer id_paquete;
    String descripcion;
    Float peso;
    String dimensiones;
    String direccion_entrega;
    String fecha_creacion;
    String estado;
    Integer id_usuario_remitente;
    Integer id_usuario_destinatario;

    public Paquete(Integer id_paquete, String descripcion, Float peso, String dimensiones, String direccion_entrega,
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

    public String getDireccion_entrega() {
        return direccion_entrega;
    }

    public void setDireccion_entrega(String direccion_entrega) {
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

}

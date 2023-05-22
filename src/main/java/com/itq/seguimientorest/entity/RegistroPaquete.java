package com.itq.seguimientorest.entity;


import java.sql.Date;

import javax.persistence.*;

@Entity
public class RegistroPaquete {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_REGISTRO")
    private Integer idRegistro;

	private Date fechaHoraCambio;

	private String estadoAnterior;

	private String estadoNuevo;

	@ManyToOne
	@JoinColumn(name = "ID_REPARTIDOR",referencedColumnName = "ID_REPARTIDOR")
	private Repartidor repartidor;

	@ManyToOne
	@JoinColumn(name = "ID_PAQUETE", referencedColumnName = "ID_PAQUETE")
	private Paquetes paquete;

	@ManyToOne
	@JoinColumn(name = "ID_UBICACION", referencedColumnName = "ID_UBICACION")
	private Ubicaciones ubicacionPaquete;

	public Integer getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(Integer idRegistro) {
		this.idRegistro = idRegistro;
	}

	public Date getFechaHoraCambio() {
		return fechaHoraCambio;
	}

	public void setFechaHoraCambio(Date fechaHoraCambio) {
		this.fechaHoraCambio = fechaHoraCambio;
	}

	public String getEstadoAnterior() {
		return estadoAnterior;
	}

	public void setEstadoAnterior(String estadoAnterior) {
		this.estadoAnterior = estadoAnterior;
	}

	public String getEstadoNuevo() {
		return estadoNuevo;
	}

	public void setEstadoNuevo(String estadoNuevo) {
		this.estadoNuevo = estadoNuevo;
	}

	public Repartidor getRepartidor() {
		return repartidor;
	}

	public void setRepartidor(Repartidor repartidor) {
		this.repartidor = repartidor;
	}

	public Paquetes getPaquete() {
		return paquete;
	}

	public void setPaquete(Paquetes paquete) {
		this.paquete = paquete;
	}

	public Ubicaciones getUbicacionPaquete() {
		return ubicacionPaquete;
	}

	public void setUbicacionPaquete(Ubicaciones ubicacionPaquete) {
		this.ubicacionPaquete = ubicacionPaquete;
	}

}


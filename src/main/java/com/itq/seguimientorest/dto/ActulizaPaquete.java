package com.itq.seguimientorest.dto;
import javax.validation.constraints.*;


public class ActulizaPaquete {
    @NotEmpty
    Integer id_paquete;

    @NotEmpty
    Integer id_repartidor;

    @Size(min = 10, max = 20, message = "Esta vacio")
    String newState;

    public ActulizaPaquete() {
    }

    public ActulizaPaquete(Integer id_paquete, Integer id_repartidor, String newState) {
        this.id_paquete = id_paquete;
        this.id_repartidor = id_repartidor;
        this.newState = newState;
    }

    public Integer getId_paquete() {
        return id_paquete;
    }

    public void setId_paquete(Integer id_paquete) {
        this.id_paquete = id_paquete;
    }

    public Integer getId_repartidor() {
        return id_repartidor;
    }

    public void setId_repartidor(Integer id_repartidor) {
        this.id_repartidor = id_repartidor;
    }

    public String getNewState() {
        return newState;
    }

    public void setNewState(String newState) {
        this.newState = newState;
    }

}

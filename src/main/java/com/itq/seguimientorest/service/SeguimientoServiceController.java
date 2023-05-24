package com.itq.seguimientorest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itq.seguimientorest.business.ServicePaquete;
import com.itq.seguimientorest.business.ServiceUbicacion;
import com.itq.seguimientorest.dto.Ack;
import com.itq.seguimientorest.dto.ActulizaPaquete;
import com.itq.seguimientorest.dto.Paquete;
import com.itq.seguimientorest.dto.Ubicacion;

@RestController
public class SeguimientoServiceController {

    @Autowired
    ServicePaquete servicePaquete;

    @Autowired
    ServiceUbicacion serviceUbicacion;

    // Crear paquete
    @PostMapping(value = "/paquete", consumes = "application/json", produces = "application/json")
    public Ack crearPaquete(@RequestBody Paquete paquete) {

        Ack ack = new Ack();
        try {
            if (servicePaquete.crearPaquete(paquete)) {
                ack.setDescripcion("Paquete creado con exito su id es:");
                ack.setCodigo(200);
            } 
        } catch (Exception e) {
            ack.setDescripcion(e.getMessage());
            ack.setCodigo(400);
        }

        return (ack);
    }

    @PutMapping(value = "/paquete", consumes = "application/json", produces = "application/json")
    public Ack actualizarPaquete(@RequestBody ActulizaPaquete actualizacion) {
        Ack ack = new Ack();
        try {
            if (servicePaquete.actualizarPaquete(actualizacion)) {
                ack.setCodigo(200);
                ack.setDescripcion("Paquete :" + actualizacion.getId_paquete() + " actualizado");
            }
        } catch (Exception e) {
            ack.setCodigo(500);
            ack.setDescripcion(e.getMessage());
        }

        return ack;

    }

    // Crear ubicacion
    @PostMapping(value = "/ubicacion", consumes = "application/json", produces = "application/json")
    public Ack crearUbicacion(@RequestBody Ubicacion ubicacion) {

        Ack ack = new Ack();
        try {
            if (serviceUbicacion.crearUbicacion(ubicacion)) {
                System.out.println("Ubicacion:" + ubicacion.getDescripcion() + "creada con exito");
                ack.setDescripcion("Ubicacion:" + ubicacion.getDescripcion() + "creada exitosamente");
                ack.setCodigo(200);
    
            } 
        } catch (Exception e) {
            System.out.println("Ubicacion no pudo ser creada");
            ack.setDescripcion(e.getMessage());
            ack.setCodigo(400);
        }
        

        return ack;
    }

}

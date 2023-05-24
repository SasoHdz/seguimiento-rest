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
        if (servicePaquete.crearPaquete(paquete)) {
            ack.setDescripcion("Paquete creado con exito su id es:");
            ack.setCodigo(200);
        } else {
            ack.setDescripcion("El paquete no pudo ser creado:");
            ack.setCodigo(400);
        }

        return (ack);
    }

    @PutMapping(value = "/paquete", consumes = "application/json", produces = "application/json")
    public Ack actualizarPaquete(@RequestBody ActulizaPaquete actualizacion) throws Exception {
        Ack ack = new Ack();
        if (servicePaquete.actualizarPaquete(actualizacion)) {
            ack.setCodigo(200);
            ack.setDescripcion("Paquete :" + actualizacion.getId_paquete() + " actualizado");
        } else {
            ack.setCodigo(400);
            ack.setDescripcion("No fue posible actualizar el paquete");
        }

        return ack;

    }

    // Crear ubicacion
    @PostMapping(value = "/ubicacion", consumes = "application/json", produces = "application/json")
    public Ack crearUbicacion(@RequestBody Ubicacion ubicacion) {

        Ack ack = new Ack();
        if (serviceUbicacion.crearUbicacion(ubicacion)) {
            System.out.println("Ubicacion:" + ubicacion.getDescripcion() + "creada con exito");
            ack.setDescripcion("Ubicacion:" + ubicacion.getDescripcion() + "creada exitosamente");
            ack.setCodigo(200);

        } else {
            System.out.println("Ubicacion no pudo ser creada");
            ack.setDescripcion("Ubicacion no pudo ser creada");
            ack.setCodigo(400);
        }

        return ack;
    }

}

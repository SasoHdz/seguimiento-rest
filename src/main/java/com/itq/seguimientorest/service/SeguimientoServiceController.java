package com.itq.seguimientorest.service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itq.seguimientorest.dto.Ack;
import com.itq.seguimientorest.dto.Paquete;

@RestController
public class SeguimientoServiceController {
    //Crear paquete
    @PostMapping(value="/paquete",consumes="application/json", produces = "application/json")
    public Ack crearPaquete(@RequestBody Paquete paquete){
        Ack ack = new Ack();
        ack.setCodigo(0);
        ack.setDescripcion("Creado con exito");
        return (ack);
    }
}

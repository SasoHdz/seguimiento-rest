package com.itq.seguimientorest.service;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itq.seguimientorest.dto.Ack;
import com.itq.seguimientorest.dto.ActulizaPaquete;
import com.itq.seguimientorest.dto.Paquete;
import com.itq.seguimientorest.dto.Ubicacion;
import com.itq.seguimientorest.entity.Paquetes;
import com.itq.seguimientorest.entity.Ubicaciones;
import com.itq.seguimientorest.entity.Usuario;
import com.itq.seguimientorest.entity.paqueteRepository;
import com.itq.seguimientorest.entity.ubicacionRepository;;


@RestController
public class SeguimientoServiceController {
    @Autowired
    private paqueteRepository paqueteRepository;

    @Autowired
	private ubicacionRepository ubicacionRepository;

    //Crear paquete
    @PostMapping(value="/paquete",consumes="application/json", produces = "application/json")
    public Ack crearPaquete(@RequestBody Paquete paquete){
        System.out.println(paquete.getId_usuario_remitente());
        System.out.println(paquete.getId_usuario_destinatario());
        Ack ack = new Ack();
		System.out.println("Paquete Recibido: '" + paquete.getDescripcion() + "'");
		
		Date fechaHoy = new Date(System.currentTimeMillis());
		
		Usuario remitente = new Usuario(paquete.getId_usuario_remitente());
		Usuario destinatario = new Usuario(paquete.getId_usuario_destinatario());
		System.out.println(remitente);

		Paquetes pack = new Paquetes(paquete.getDescripcion(),paquete.getPeso(),paquete.getDimensiones(),paquete.getDireccion_entrega(),fechaHoy,paquete.getEstado(),remitente,destinatario);
		paqueteRepository.save(pack);
	
		ack.setDescripcion("Paquete creado con exito su id es:");
		ack.setCodigo(pack.getIdPaquete());
		
        return (ack);
    }

    @PutMapping(value = "/paquete", consumes = "application/json", produces = "application/json")
    public Ack actualizarPaquete(@RequestBody ActulizaPaquete actualizacion) throws Exception {
        Optional<Paquetes> paqueteOptional = paqueteRepository.findById(actualizacion.getId_paquete());
        System.out.println(actualizacion.getId_paquete());
        if (paqueteOptional.isPresent()) {
            Paquetes paqueteExistente = paqueteOptional.get();
            paqueteExistente.setEstado(actualizacion.getNewState());
            paqueteRepository.save(paqueteExistente);
            
            Ack ack = new Ack();
            ack.setCodigo(200);
            ack.setDescripcion("Paquete :"+actualizacion.getId_paquete()+" modificado");
            return ack;
        } else {
            // Manejar el caso cuando el paquete no existe
            // Por ejemplo, lanzar una excepción o devolver un mensaje de error adecuado
            throw new Exception("El paquete: "+actualizacion.getId_paquete()+" no existe");
        }
    }

    //Crear ubicacion
    @PostMapping(value="/ubicacion",consumes="application/json", produces = "application/json")
    public Ack crearUbicacion(@RequestBody Ubicacion ubicacion){
        Ubicaciones newUbicacion = new Ubicaciones(ubicacion.getLatitud(), ubicacion.getLongitud(), ubicacion.getDescripcion());
		ubicacionRepository.save(newUbicacion);
		Ack ack = new Ack();
		System.out.println("Ubicacion:" + ubicacion.getDescripcion() + "creada con exito");

		ack.setDescripcion("Ubicacion:" + ubicacion.getDescripcion() + "creada exitosamente");
		ack.setCodigo(200);

		return ack;
    }
}

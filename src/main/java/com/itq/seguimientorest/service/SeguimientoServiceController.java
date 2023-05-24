package com.itq.seguimientorest.service;

import java.sql.Date;
import java.util.Optional;
import java.util.regex.Pattern;

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

    private static final String LATITUDE_REGEX = "[-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?)";
    private static final String LONGITUDE_REGEX = "[-+]?((1[0-7]|[1-9])?\\d(\\.\\d+)?|180(\\.0+)?)";
    
    //Crear paquete
    @PostMapping(value="/paquete",consumes="application/json", produces = "application/json")
    public Ack crearPaquete(@RequestBody Paquete paquete){
        if (paquete.getId_usuario_remitente() == null || paquete.getId_usuario_destinatario() == null) {
            throw new IllegalArgumentException("Los campos id_usuario_remitente y id_usuario_destinatario son requeridos.");
        }
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
        if (actualizacion.getId_paquete() == null) {
            throw new IllegalArgumentException("El campo id_paquete es requerido.");
        }
        Optional<Paquetes> paqueteOptional = paqueteRepository.findById(actualizacion.getId_paquete());
        System.out.println(actualizacion.getId_paquete());
        if (paqueteOptional.isPresent()) {
            Paquetes paqueteExistente = paqueteOptional.get();
            paqueteExistente.setEstado(actualizacion.getNewState());
            paqueteRepository.save(paqueteExistente);
            
            Ack ack = new Ack();
            ack.setCodigo(200);
            ack.setDescripcion("Paquete :"+actualizacion.getId_paquete()+" actualizado");
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
        if (ubicacion.getLatitud() == null || ubicacion.getLongitud() == null || ubicacion.getDescripcion() == null) {
            throw new IllegalArgumentException("Los campos latitud, longitud y descripcion son requeridos.");
        }
        validateData(ubicacion.getLatitud(), LATITUDE_REGEX, "latitud");
        validateData(ubicacion.getLongitud(), LONGITUDE_REGEX, "longitud");
        Ubicaciones newUbicacion = new Ubicaciones(ubicacion.getLatitud(), ubicacion.getLongitud(), ubicacion.getDescripcion());
		ubicacionRepository.save(newUbicacion);
		Ack ack = new Ack();
		System.out.println("Ubicacion:" + ubicacion.getDescripcion() + "creada con exito");
		ack.setDescripcion("Ubicacion:" + ubicacion.getDescripcion() + "creada exitosamente");
		ack.setCodigo(200);

		return ack;
    }

    private void validateData(String data, String regex, String fieldName) {
        if (data == null || !Pattern.matches(regex, data)) {
            throw new IllegalArgumentException("El campo " + fieldName + " es inválido.");
        }
    }
}

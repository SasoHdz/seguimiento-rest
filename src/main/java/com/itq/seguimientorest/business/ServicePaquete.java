package com.itq.seguimientorest.business;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itq.seguimientorest.dto.ActulizaPaquete;
import com.itq.seguimientorest.dto.Paquete;
import com.itq.seguimientorest.entity.Paquetes;
import com.itq.seguimientorest.entity.Usuario;
import com.itq.seguimientorest.entity.paqueteRepository;
import java.util.Optional;

@Component
public class ServicePaquete {
    @Autowired
    private paqueteRepository paqueteRepository;

    public Boolean crearPaquete(Paquete newPaquete) {
        boolean creacion = false;

        if (newPaquete.getId_usuario_remitente() == null || newPaquete.getId_usuario_destinatario() == null) {
            throw new IllegalArgumentException(
                    "Los campos id_usuario_remitente y id_usuario_destinatario son requeridos.");
        } else {
            System.out.println(newPaquete.getId_usuario_remitente());
            System.out.println(newPaquete.getId_usuario_destinatario());
            System.out.println("Paquete Recibido: '" + newPaquete.getDescripcion() + "'");

            Date fechaHoy = new Date(System.currentTimeMillis());

            Usuario remitente = new Usuario(newPaquete.getId_usuario_remitente());
            Usuario destinatario = new Usuario(newPaquete.getId_usuario_destinatario());
            System.out.println(remitente);

            Paquetes pack = new Paquetes(newPaquete.getDescripcion(), newPaquete.getPeso(), newPaquete.getDimensiones(),
                    newPaquete.getDireccion_entrega(), fechaHoy, newPaquete.getEstado(), remitente, destinatario);
            paqueteRepository.save(pack);
            creacion = true;
        }

        return creacion;
    }

    public Boolean actualizarPaquete(ActulizaPaquete actualizacion) throws Exception {
        boolean ac = false;

        if (actualizacion.getId_paquete() == null) {
            throw new IllegalArgumentException("El campo id_paquete es requerido.");
        }
        Optional<Paquetes> paqueteOptional = paqueteRepository.findById(actualizacion.getId_paquete());
        System.out.println(actualizacion.getId_paquete());
        if (paqueteOptional.isPresent()) {
            Paquetes paqueteExistente = paqueteOptional.get();
            paqueteExistente.setEstado(actualizacion.getNewState());
            paqueteRepository.save(paqueteExistente);
            ac = true;
        } else {
            // Manejar el caso cuando el paquete no existe
            // Por ejemplo, lanzar una excepción o devolver un mensaje de error adecuado
            throw new Exception("El paquete: " + actualizacion.getId_paquete() + " no existe");
        }

        return ac;
    }
}

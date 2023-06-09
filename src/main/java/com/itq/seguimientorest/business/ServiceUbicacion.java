package com.itq.seguimientorest.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itq.seguimientorest.entity.Ubicaciones;
import com.itq.seguimientorest.entity.ubicacionRepository;
import com.itq.seguimientorest.dto.Ubicacion;
import java.util.regex.Pattern;

@Component
public class ServiceUbicacion {
    @Autowired
    private ubicacionRepository ubicacionRepository;

    private static final String LATITUDE_REGEX = "^(90|\\d{1,2})°\\s([0-5]?\\d)′\\s([0-5]?\\d)″\\s([NS])$";
    private static final String LONGITUDE_REGEX = "^(180|\\d{1,2})°\\s([0-5]?\\d)′\\s([0-5]?\\d)″\\s([EO])$";

    public Boolean crearUbicacion(Ubicacion ubicacion) {
        boolean creado = false;

        if (ubicacion.getLatitud() == null || ubicacion.getLongitud() == null || ubicacion.getDescripcion() == null) {
            throw new IllegalArgumentException("Los campos latitud, longitud y descripcion son requeridos.");
        } else {
            creado = true;
            validateData(ubicacion.getLatitud(), LATITUDE_REGEX, "latitud");
            validateData(ubicacion.getLongitud(), LONGITUDE_REGEX, "longitud");
            Ubicaciones newUbicacion = new Ubicaciones(ubicacion.getLatitud(), ubicacion.getLongitud(),
                    ubicacion.getDescripcion());
            ubicacionRepository.save(newUbicacion);
        }
        return creado;
    }

    private void validateData(String data, String regex, String fieldName) {
        if (data == null || !Pattern.matches(regex, data)) {
            throw new IllegalArgumentException("El campo " + fieldName + " es inválido.");
        }
    }
}

package com.itq.seguimientorest.entity;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface paqueteRepository extends JpaRepository<Paquetes, Integer> {

    /**
     * @param start
     * @param end
     * @param object
     * @return
     */
    
    List<Paquetes> findByFechaCreacionBetweenAndFechaCreacion(Date start, Date end, Object object);
    // Aquí se pueden agregar métodos personalizados para paqueteRepository, si es necesario
    
}

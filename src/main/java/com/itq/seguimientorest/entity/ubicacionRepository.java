package com.itq.seguimientorest.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ubicacionRepository extends JpaRepository<Ubicaciones, Integer>{
    // Aquí se pueden agregar métodos personalizados para ubicacionRepository, si es necesario
}

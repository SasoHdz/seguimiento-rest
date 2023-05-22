package com.itq.seguimientorest.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface registroPaqueteRepository extends JpaRepository<RegistroPaquete, Integer> {
    // Aquí se pueden agregar métodos personalizados para registroPaqueteRepository, si es necesario
}

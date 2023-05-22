package com.itq.seguimientorest.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface repartidorRepository extends JpaRepository<Repartidor, Integer> {
    // Aquí se pueden agregar métodos personalizados para repartidorRepository, si es necesario
}

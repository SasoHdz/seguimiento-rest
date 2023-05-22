package com.itq.seguimientorest.entity;


import org.springframework.data.jpa.repository.JpaRepository;

//import com.itq.seguimientopaquetes.dto.Cliente;
//import com.itq.seguimientopaquetes.entity.Usuario;

public interface usuarioRepository extends JpaRepository<Usuario, Integer> {
    // Aquí se pueden agregar métodos personalizados para usuarioRepository, si es necesario
}

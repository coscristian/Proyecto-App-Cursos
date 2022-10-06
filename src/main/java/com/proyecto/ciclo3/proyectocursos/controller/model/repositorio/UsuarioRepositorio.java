package com.proyecto.ciclo3.proyectocursos.controller.model.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.ciclo3.proyectocursos.controller.model.entidad.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, String>{
    Optional<Usuario> findByNombreUsuarioAndContraseñaAndActivoIsTrue(String nombreUsuario, String contraseña);
    Optional<Usuario> findByCorreo(String correo);
}

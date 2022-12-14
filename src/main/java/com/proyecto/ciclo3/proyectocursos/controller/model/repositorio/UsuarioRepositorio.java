package com.proyecto.ciclo3.proyectocursos.controller.model.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.ciclo3.proyectocursos.controller.model.entidad.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, String>{
    Optional<Usuario> findByNombreUsuarioAndContrase├▒aAndActivoIsTrue(String nombreUsuario, String contrase├▒a);
    Optional<Usuario> findByCorreo(String correo);
}

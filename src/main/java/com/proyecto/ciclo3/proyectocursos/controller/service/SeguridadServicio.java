package com.proyecto.ciclo3.proyectocursos.controller.service;

import java.util.List;

import com.proyecto.ciclo3.proyectocursos.controller.dto.UsuarioRequest;
import com.proyecto.ciclo3.proyectocursos.controller.dto.UsuarioResponse;

public interface SeguridadServicio{
    
    // Métodos para la gestión de usuarios
    UsuarioResponse validarUsuario(String nombreUsuario, String contraseña);

    List<UsuarioResponse> getAllUsuarios();

    UsuarioResponse getUserByNombreUsuario(String nombreUsuario);

    void crearUsuario(UsuarioRequest usuario);

    void actualizarUsuario(UsuarioRequest usuario);

    void eliminarUsuario(String nombreUsuario);

    void activarUsuario(String nombreUsuario);

    void inactivarUsuario(String nombreUsuario);
}

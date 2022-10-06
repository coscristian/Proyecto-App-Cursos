package com.proyecto.ciclo3.proyectocursos.controller.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.proyecto.ciclo3.proyectocursos.controller.dto.UsuarioRequest;
import com.proyecto.ciclo3.proyectocursos.controller.dto.UsuarioResponse;
import com.proyecto.ciclo3.proyectocursos.controller.model.entidad.Usuario;
import com.proyecto.ciclo3.proyectocursos.controller.model.repositorio.UsuarioRepositorio;
import com.proyecto.ciclo3.proyectocursos.controller.service.SeguridadServicio;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SeguridadServicioImpl implements SeguridadServicio {

    private final UsuarioRepositorio usuarioRepositorio;
    
    @Override
    public UsuarioResponse validarUsuario(String nombreUsuario, String contraseña) {
        
        var usuarioOp = usuarioRepositorio.findByNombreUsuarioAndContraseñaAndActivoIsTrue(nombreUsuario, contraseña);
        if(usuarioOp.isEmpty())
            throw new RuntimeException("Usuario no existente");
        
        var usuario = usuarioOp.get();
        return UsuarioResponse.builder()
                .nombreUsuario(usuario.getNombreUsuario())
                .nombre(usuario.getNombre())
                .correo(usuario.getCorreo())
                .admin(usuario.getAdmin())
                .build();
    }

    @Override
    public List<UsuarioResponse> getAllUsuarios() {
        
        return usuarioRepositorio.findAll().stream()
                .map( u -> UsuarioResponse.builder()
                    .nombreUsuario(u.getNombre())
                    .nombre(u.getNombre())
                    .correo(u.getCorreo())
                    .admin(u.getAdmin())
                    .build())
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioResponse getUserByNombreUsuario(String nombreUsuario) {
        var usuarioOp = usuarioRepositorio.findById(nombreUsuario);
        if(usuarioOp.isEmpty())
            throw new RuntimeException("EL usuario no existe");
        
        var usuario = usuarioOp.get();
        return UsuarioResponse.builder()
                .nombreUsuario(usuario.getNombreUsuario())
                .nombre(usuario.getNombre())
                .correo(usuario.getCorreo())
                .admin(usuario.getAdmin())
                .build();
    }

    @Override
    public void crearUsuario(UsuarioRequest usuario) {
        
        var usuarioOp = usuarioRepositorio.findById(usuario.getNombreUsuario());
        if(!usuarioOp.isPresent())
            throw new RuntimeException("El usuario ya existe, no puede utilizar ese nombre de usuario");
        
        usuarioOp = usuarioRepositorio.findByCorreo(usuario.getCorreo());
        if(usuarioOp.isPresent())
            throw new RuntimeException("Ya existe un usuario registrado con ese correo.");

        var usuarioDb = new Usuario();
        usuarioDb.setNombreUsuario(usuario.getNombreUsuario());
        usuarioDb.setContraseña(usuario.getContraseña());
        usuarioDb.setNombre(usuarioDb.getNombre());
        usuarioDb.setCorreo(usuario.getCorreo());
        usuarioDb.setActivo(true);
        usuarioDb.setAdmin(usuario.getAdmin());

        usuarioDb = usuarioRepositorio.save(usuarioDb);
    }

    @Override
    public void actualizarUsuario(UsuarioRequest usuario) {
        
        
    }

    @Override
    public void eliminarUsuario(String nombreUsuario) {
        
        
    }

    @Override
    public void activarUsuario(String nombreUsuario) {
        var usuarioOp = usuarioRepositorio.findById(nombreUsuario);
        if(usuarioOp.isEmpty())
            throw new RuntimeException("El usuario no existe");
        
        var usuario = usuarioOp.get();
        usuario.setActivo(true);
        usuarioRepositorio.save(usuario);
    }

    @Override
    public void inactivarUsuario(String nombreUsuario) {
        var usuarioOp = usuarioRepositorio.findById(nombreUsuario);
        if(usuarioOp.isEmpty())
            throw new RuntimeException("El usuario no existe");
        
        var usuario = usuarioOp.get();
        usuario.setActivo(false);
        usuarioRepositorio.save(usuario);
        
    }
    
}

package com.proyecto.ciclo3.proyectocursos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.ciclo3.proyectocursos.controller.dto.LoginRequest;
import com.proyecto.ciclo3.proyectocursos.controller.service.SeguridadServicio;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/inicioSesion")
public class LoginRestControlador {
    
    private SeguridadServicio seguridadServicio;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest usuario) {
        try {
            var respuesta = seguridadServicio.validarUsuario(usuario.getNombreUsuario(), usuario.getContraseña());
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(e.getMessage());
        }
    }
}

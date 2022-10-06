package com.proyecto.ciclo3.proyectocursos.controller.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UsuarioRequest {
    
    private String nombreUsuario;
    private String contraseña;
    private String nombre;
    private String correo;
    private Boolean admin;
}

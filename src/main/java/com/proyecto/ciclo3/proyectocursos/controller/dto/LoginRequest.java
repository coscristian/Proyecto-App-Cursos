package com.proyecto.ciclo3.proyectocursos.controller.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String nombreUsuario;
    private String contraseña;
}

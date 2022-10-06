package com.proyecto.ciclo3.proyectocursos.controller.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UsuarioResponse {
    private String nombreUsuario;

    private String nombre;

    private String correo;

    private Boolean admin;
}

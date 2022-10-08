package com.proyecto.ciclo3.proyectocursos.controller.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CursoRequest {
    private String nombre;
    private String descripcion;
    private String urlImagen;
    private Integer especialidadId;
}

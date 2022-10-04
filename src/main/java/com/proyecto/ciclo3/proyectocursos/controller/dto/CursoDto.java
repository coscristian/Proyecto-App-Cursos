package com.proyecto.ciclo3.proyectocursos.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoDto {
    private String nombre;
    private Integer id;
    private String descripcion;
    private Integer especialidadId;
    private String urlImagen;
}

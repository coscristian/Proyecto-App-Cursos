package com.proyecto.ciclo3.proyectocursos.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

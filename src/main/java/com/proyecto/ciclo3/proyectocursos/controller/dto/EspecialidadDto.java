package com.proyecto.ciclo3.proyectocursos.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Usando Lombok
@Data // Métodos Getter y Setter
@NoArgsConstructor // Constructor sin atributos
@AllArgsConstructor // Constructor con todos los atributos
public class EspecialidadDto {
    private String nombre;
    private String descripcion;
    private Integer id;
}

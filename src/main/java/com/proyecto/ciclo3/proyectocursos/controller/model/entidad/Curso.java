package com.proyecto.ciclo3.proyectocursos.controller.model.entidad;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Esta clase será una tabla en la BBDD
@Data // Genera Setters y Getters
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    @Id // Llave primaria de la tabla
    private Long id;
    private String nombre;
    private String descripcion;
    private Integer especialidadId;
    private String urlImagen;

    @ManyToOne // Relacion de muchos a uno
    private Especialidad especialidad;
}

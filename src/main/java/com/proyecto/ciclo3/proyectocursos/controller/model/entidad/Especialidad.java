package com.proyecto.ciclo3.proyectocursos.controller.model.entidad;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity; // JPA: Java Persistance Entity

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Indica que  esta clase será una tabla en la BBDD
@Table(name="Especialidad") // Indica el nombre de la tabla
@Data // Genera setters y getters
@AllArgsConstructor
@NoArgsConstructor
public class Especialidad {
    
    @Id // Hace referencia a la llave primaria de la tabla
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private Long id;

    @Column(name="nombre", nullable=false, length=10)
    private String nombre;

    @Column(name="descripcion", length=50)
    private String descripcion;

    // Relación de uno a muchos
    @OneToMany(mappedBy="especialidad")
    private List<Curso> cursos;

}
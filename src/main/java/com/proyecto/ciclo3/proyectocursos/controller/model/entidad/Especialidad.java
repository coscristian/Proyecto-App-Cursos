package com.proyecto.ciclo3.proyectocursos.controller.model.entidad;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity; // JPA: Java Persistance Entity

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity // Indica que  esta clase será una tabla en la BBDD
@Table(name="Especialidad") // Indica el nombre de la tabla
@Data // Genera setters y getters
@AllArgsConstructor
@NoArgsConstructor
public class Especialidad {
    
    @Id // Hace referencia a la llave primaria de la tabla
    private Long id;

    @Column(name="nombre", nullable=false, length=100)
    private String nombre;

    @Column(name="descripcion", length=100)
    private String descripcion;

    // Relación de uno a muchos
    //@OneToMany(mappedBy="especialidad",cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(mappedBy="especialidad")
    private List<Curso> cursos;


    public Especialidad(String nombre, Long id) {
        this.nombre = nombre;
        this.id = id;
    }

}

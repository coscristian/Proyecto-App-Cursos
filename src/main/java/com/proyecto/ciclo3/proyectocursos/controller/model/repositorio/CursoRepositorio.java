package com.proyecto.ciclo3.proyectocursos.controller.model.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.proyecto.ciclo3.proyectocursos.controller.model.entidad.Curso;

public interface CursoRepositorio extends JpaRepository<Curso, Long>{

    // Aqui van las consultas especiales a la BBDD que dese realizar
    List<Curso> findAllByEspecialidadId(Long especialidadId);
    
    Optional<Curso> findByNombreAndEspecialidadId(String nombre, Integer especialidadId);

}

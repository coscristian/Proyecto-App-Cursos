package com.proyecto.ciclo3.proyectocursos.controller.model.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.ciclo3.proyectocursos.controller.model.entidad.Curso;

public interface CursoRepositorio extends JpaRepository<Curso, Long>{
    List<Curso> findAllByEspecialidadId(Long especialidadId);

    //List<Curso> findAll();
}

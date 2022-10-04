package com.proyecto.ciclo3.proyectocursos.controller.model.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.ciclo3.proyectocursos.controller.model.entidad.Especialidad;

public interface EspecialidadRepositorio extends JpaRepository<Especialidad, Long>{
    
}

package com.proyecto.ciclo3.proyectocursos.controller.service;

import java.util.List;

import com.proyecto.ciclo3.proyectocursos.controller.dto.CursoDto;
import com.proyecto.ciclo3.proyectocursos.controller.dto.EspecialidadDto;



public interface CursoService {
    List<CursoDto> getCursos();

    void eliminarCurso(CursoDto curso, EspecialidadDto especialidad);

    void crearCurso(CursoDto curso, EspecialidadDto especialidad);

    void guardarCurso(CursoDto curso);

}   

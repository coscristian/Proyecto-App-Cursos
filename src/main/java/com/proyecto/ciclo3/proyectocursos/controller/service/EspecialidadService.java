package com.proyecto.ciclo3.proyectocursos.controller.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.ciclo3.proyectocursos.controller.dto.CursoDto;
import com.proyecto.ciclo3.proyectocursos.controller.dto.EspecialidadDto;

public interface EspecialidadService {
    List<EspecialidadDto> getEspecialidades();
    Optional<EspecialidadDto> getEspecialidadPorId(Integer id);
    List<CursoDto> getCursosPorEspecialidad(Integer id);
}

package com.proyecto.ciclo3.proyectocursos.controller.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.proyecto.ciclo3.proyectocursos.controller.dto.CursoDto;
import com.proyecto.ciclo3.proyectocursos.controller.dto.EspecialidadDto;
import com.proyecto.ciclo3.proyectocursos.controller.service.EspecialidadService;

@Service
public class EspecialidadServiceImpl implements EspecialidadService{
    
    private final List<CursoDto> cursos = Arrays.asList(
        new CursoDto("Python", 1, "Lorem", 1, null),
        new CursoDto("Java", 2, "Lorem Ipsum", 5, null),
        new CursoDto("HTML", 3, "Lorem Ipsum Dolor", 1, null),
        new CursoDto("C++", 4, "Lorem", 5, null),
        new CursoDto("CSS", 5, "Lorem", 4, null),
        new CursoDto("JavaScript", 6, "Lorem dolor", 1, null)
    );

    private final List<EspecialidadDto> especialidades = Arrays.asList(
        new EspecialidadDto("Desarrollo Web", "Aprende a desarollar web de la mejor manera", 1),
        new EspecialidadDto("Desarrollo Movil", "Se uno de los mejores desarrolladores moviles!!", 2),
        new EspecialidadDto("Mercadeo Digital", "Desarrolla nuevas habilidades de marketing", 3),
        new EspecialidadDto("Frontend", "Desarrolla excelentes interfaces para tus clientes", 4),
        new EspecialidadDto("Backend", "Aprende y entiende toda la lógica que hay detrás", 5),
        new EspecialidadDto("Diseño de interfaces","Diseña y maqueta hermosas interfaces" , 6)
    );

    @Override
    public List<EspecialidadDto> getEspecialidades() {
        return especialidades;
    }

    @Override
    public Optional<EspecialidadDto> getEspecialidadPorId(Integer id) {
        var especialidad = especialidades.stream()
            .filter(e -> e.getId().equals(id))
            .findFirst();
        return especialidad;
    }

    @Override
    public List<CursoDto> getCursosPorEspecialidad(Integer idEspecialidad) {
        var especialidadCursos = cursos.stream()
            .filter(c -> c.getEspecialidadId().equals(idEspecialidad))
            .collect(Collectors.toList());
        return especialidadCursos;
    }


}

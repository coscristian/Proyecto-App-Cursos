package com.proyecto.ciclo3.proyectocursos.controller.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.proyecto.ciclo3.proyectocursos.controller.dto.CursoDto;
import com.proyecto.ciclo3.proyectocursos.controller.model.repositorio.CursoRepositorio;
import com.proyecto.ciclo3.proyectocursos.controller.service.CursoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CursoServiceImpl implements CursoService{

    private final CursoRepositorio cursoRepositorio;

    @Override
    public List<CursoDto> getCursos() {
        
        var cursosEntity = cursoRepositorio.findAll();
        var cursosDto = cursosEntity.stream()
                .map(cur -> CursoDto.builder()
                    .nombre(cur.getNombre())
                    .id(cur.getId().intValue())
                   // .descripcion(cur.getDescripcion())
                    .especialidadId(cur.getEspecialidad().getId().intValue())
                    .urlImagen(cur.getUrlImagen())
                    .build())
            .collect(Collectors.toList());
        return cursosDto;
    }
    
}



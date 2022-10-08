package com.proyecto.ciclo3.proyectocursos.controller.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.proyecto.ciclo3.proyectocursos.controller.dto.CursoDto;
import com.proyecto.ciclo3.proyectocursos.controller.dto.EspecialidadDto;
import com.proyecto.ciclo3.proyectocursos.controller.model.entidad.Curso;
import com.proyecto.ciclo3.proyectocursos.controller.model.entidad.Especialidad;
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

    @Override
    public void eliminarCurso(CursoDto curso, EspecialidadDto especialidad) {
        
        var esp = Especialidad.builder()
            .id(especialidad.getId().longValue())
            .nombre(especialidad.getNombre())
            .descripcion(especialidad.getDescripcion())
            .build();
    
        var cursoEliminar = new Curso(curso.getId().longValue(), curso.getNombre(), curso.getDescripcion(), curso.getUrlImagen(), esp);
        
        cursoRepositorio.delete(cursoEliminar);
    }

    @Override
    public void crearCurso(CursoDto curso, EspecialidadDto especialidad) {
        /*
        var cursoOp = cursoRepositorio.findByNombreAndEspecialidadId(curso.getNombre(), curso.getEspecialidadId());
    
        if(cursoOp.isPresent()){
            throw new RuntimeException("Ya existe un curso registrado con esas caracteristicas.");
        }
 */

        var cursoOp = cursoRepositorio.findById(curso.getId().longValue());
        if(cursoOp.isPresent()){
            throw new RuntimeException("Ya existe un curso registrado con ese ID.");
        }
        var cursoDb = new Curso();

        cursoDb.setId(curso.getId().longValue());
        cursoDb.setNombre(curso.getNombre());
        cursoDb.setDescripcion(curso.getDescripcion());
        
        var especialidadEnt = new Especialidad(especialidad.getNombre(), especialidad.getId().longValue());
        cursoDb.setEspecialidad(especialidadEnt);
        
        cursoDb.setUrlImagen(curso.getUrlImagen());
        
        cursoRepositorio.save(cursoDb); 
    }

    @Override
    public void guardarCurso(CursoDto curso) {
        
        
    }
    
}



package com.proyecto.ciclo3.proyectocursos.controller.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.proyecto.ciclo3.proyectocursos.controller.dto.CursoDto;
import com.proyecto.ciclo3.proyectocursos.controller.dto.EspecialidadDto;
import com.proyecto.ciclo3.proyectocursos.controller.model.repositorio.CursoRepositorio;
import com.proyecto.ciclo3.proyectocursos.controller.model.repositorio.EspecialidadRepositorio;
import com.proyecto.ciclo3.proyectocursos.controller.service.EspecialidadService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EspecialidadServiceImpl implements EspecialidadService{

    private final EspecialidadRepositorio especialidadRepositorio;
    private final CursoRepositorio cursoRepositorio;
    
    /* 
    private final List<EspecialidadDto> especialidades = Arrays.asList(
        new EspecialidadDto("Desarrollo Web", "Aprende a desarollar web de la mejor manera", 1),
        new EspecialidadDto("Desarrollo Movil", "Se uno de los mejores desarrolladores moviles!!", 2),
        new EspecialidadDto("Mercadeo Digital", "Desarrolla nuevas habilidades de marketing", 3),
        new EspecialidadDto("Frontend", "Desarrolla excelentes interfaces para tus clientes", 4),
        new EspecialidadDto("Backend", "Aprende y entiende toda la lógica que hay detrás", 5),
        new EspecialidadDto("Diseño de interfaces","Diseña y maqueta hermosas interfaces" , 6)
    ); */

    @Override
    public List<EspecialidadDto> getEspecialidades() {

        var especialidadesRep = especialidadRepositorio.findAll();

        var resultado = especialidadesRep.stream()
                        .map(esp ->
                            new EspecialidadDto(esp.getNombre(), esp.getDescripcion(), esp.getId().intValue()))
                        .collect(Collectors.toList());
        return resultado;
    }

    @Override
    public Optional<EspecialidadDto> getEspecialidadPorId(Integer id) {
        
        var especialidad = especialidadRepositorio.findById(id.longValue());
        
        if (especialidad.isEmpty())
            return Optional.empty();
        else{
            return Optional.of(
                    new EspecialidadDto(
                        especialidad.get().getNombre(),
                        especialidad.get().getDescripcion(),
                        especialidad.get().getId().intValue()
                    )
                  );
        }
    }

    @Override
    public List<CursoDto> getCursosPorEspecialidad(Integer idEspecialidad) {

        var cursos = cursoRepositorio.findAllByEspecialidadId(idEspecialidad.longValue());

        var especialidadCursos = cursos.stream()
            .map(cur -> CursoDto.builder()
                .nombre(cur.getNombre())
                .id(cur.getId().intValue())
                .descripcion(cur.getDescripcion())
                .urlImagen(cur.getUrlImagen())
                .build())
            .collect(Collectors.toList());
        return especialidadCursos;
    }


}

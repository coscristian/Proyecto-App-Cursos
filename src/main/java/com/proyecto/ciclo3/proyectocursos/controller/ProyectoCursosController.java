package com.proyecto.ciclo3.proyectocursos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.proyecto.ciclo3.proyectocursos.controller.service.EspecialidadService;

@Controller
public class ProyectoCursosController {

    private EspecialidadService especialidadService;

    public ProyectoCursosController(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }
    
    @GetMapping("/iniciosesion")
    public String goToInicioSesion(Model model) {
        return "iniciosesion";
    }

    @GetMapping("/catalogoEsp")
    public String goToEspecialidades(Model model) {
        
        var especialidades = this.especialidadService.getEspecialidades();

        model.addAttribute("titulo", "Seleccione una categoria");
        model.addAttribute("especialidades", especialidades);

        return "catalogoEspecialidades";
    }

    @GetMapping("/catalogoEsp/{id}")
    public String cargarEspecialidadesPorId(@PathVariable("id") Integer id, Model model){
        
        var especialidadOp = this.especialidadService.getEspecialidadPorId(id);
        var especialidades = this.especialidadService.getEspecialidades();
        model.addAttribute("especialidades", especialidades);

        if(especialidadOp.isEmpty()) 
            model.addAttribute("error", "La categoria no existe");
        else{
            var especialidad = especialidadOp.get();

            model.addAttribute("titulo", especialidad.getNombre());
            model.addAttribute("id", especialidad.getId());

            var especialidadCursos = this.especialidadService.getCursosPorEspecialidad(id);
            model.addAttribute("cursos", especialidadCursos);
        }

        return "catalogoEspecialidades";
    }
}

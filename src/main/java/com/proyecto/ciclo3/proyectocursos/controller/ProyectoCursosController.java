package com.proyecto.ciclo3.proyectocursos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyecto.ciclo3.proyectocursos.controller.dto.CursoDto;
import com.proyecto.ciclo3.proyectocursos.controller.dto.UsuarioRequest;
import com.proyecto.ciclo3.proyectocursos.controller.service.CursoService;
import com.proyecto.ciclo3.proyectocursos.controller.service.EspecialidadService;
import com.proyecto.ciclo3.proyectocursos.controller.service.SeguridadServicio;

@Controller
public class ProyectoCursosController {

    private EspecialidadService especialidadService;
    private CursoService cursoService;
    private SeguridadServicio seguridadServicio;

    public ProyectoCursosController(EspecialidadService especialidadService, CursoService cursoService) {
        this.especialidadService = especialidadService;
        this.cursoService = cursoService;
    }

    @PostMapping("/registro/registrado")
    public String goToInicio(@ModelAttribute UsuarioRequest usuarioInfo, Model model) {
        System.out.println("hola1");
        seguridadServicio.crearUsuario(usuarioInfo);

        return "iniciosesion";
    }

    @GetMapping("/registro")
    public String goToRegistroUsuario(Model model) {
        return "registro";
    }

    @PostMapping("/agregarcurso/nuevo") // ModelAtribute son los datos que voy e recibir de un formulario o de algun metodo
    public String agregarNuevoCurso(@ModelAttribute CursoDto cursoInfo, Model model) {
        
        var especialidades = this.especialidadService.getEspecialidades();
        System.out.println(cursoInfo.getEspecialidadId());

        for (var especialidad : especialidades) {
            if (especialidad.getId() == cursoInfo.getEspecialidadId()){
                cursoService.crearCurso(cursoInfo, especialidad);
            }
        }

        System.out.println(cursoInfo.toString());

        //model.addAttribute("info", cursoInfo);
        return "cursoagregado";
    }

    @GetMapping("/agregarcurso")
    public String goToAgregarCurso(Model model) {
        var especialidades = this.especialidadService.getEspecialidades();
        model.addAttribute("especialidades", especialidades);

        return "agregarcurso";

    }

    @GetMapping("/gestioncursos/{id}")
    public String goToEliminarCurso(@PathVariable("id") Integer idCursoBorrar, Model model) {

        var cursos = this.cursoService.getCursos();
        var especialidades = this.especialidadService.getEspecialidades();

        for (var curso : cursos) {
            var idCurso = curso.getId();
            if(idCurso == idCursoBorrar){
                for (var especialidad : especialidades) {
                    if(especialidad.getId() == curso.getEspecialidadId()){
                        cursoService.eliminarCurso(curso, especialidad);
                        break;  
                    }
                }                            
            }
        }

        var cursosActualizados = this.cursoService.getCursos();
        
        model.addAttribute("especialidades", especialidades);
        model.addAttribute("cursos", cursosActualizados);
        
        return "gestioncursos";
    }

    @GetMapping("/gestioncursos")
    public String goToGestionCursos(Model model) {
        
        var cursos = this.cursoService.getCursos();
        var especialidades = this.especialidadService.getEspecialidades();
        
        model.addAttribute("especialidades", especialidades);
        model.addAttribute("cursos", cursos);

        return "gestioncursos";
    }

    @GetMapping("/")
    public String gotToIndex(Model model) {
        return "index";
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

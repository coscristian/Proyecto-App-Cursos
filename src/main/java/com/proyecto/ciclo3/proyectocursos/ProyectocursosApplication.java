package com.proyecto.ciclo3.proyectocursos;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.proyecto.ciclo3.proyectocursos.controller.model.entidad.Curso;
import com.proyecto.ciclo3.proyectocursos.controller.model.entidad.Especialidad;
import com.proyecto.ciclo3.proyectocursos.controller.model.entidad.Usuario;
import com.proyecto.ciclo3.proyectocursos.controller.model.repositorio.CursoRepositorio;
import com.proyecto.ciclo3.proyectocursos.controller.model.repositorio.EspecialidadRepositorio;
import com.proyecto.ciclo3.proyectocursos.controller.model.repositorio.UsuarioRepositorio;

import lombok.AllArgsConstructor;
import lombok.Data;

@SpringBootApplication
public class ProyectocursosApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProyectocursosApplication.class, args);
	}

	//@Component
	@Data
	@AllArgsConstructor
	private class DataLoader implements CommandLineRunner {

		private final EspecialidadRepositorio especialidadRepositorio;
		private final CursoRepositorio cursoRepositorio;
		private final UsuarioRepositorio usuarioRepositorio;

		@Override
		public void run(String... args) throws Exception {
			loadData();
			loadUsers();
		}

		public void loadUsers() {
			var usuario = new Usuario("admin", "admin123", "Administrador", "admin@eduonline.com", true, true);
			usuarioRepositorio.save(usuario);
		}
	
		private void loadData() {

			var desarrolloWeb = especialidadRepositorio.save(new Especialidad("Desarrollo Web"));
			var desarrolloMovil = especialidadRepositorio.save(new Especialidad("Desarrollo Movil"));
			var mercadeoDigital = especialidadRepositorio.save(new Especialidad("Mercadeo Digital"));
			var frontend = especialidadRepositorio.save(new Especialidad("Frontend"));
			var backend = especialidadRepositorio.save(new Especialidad("Backend"));
			var diseñoInterfaces = especialidadRepositorio.save(new Especialidad("Diseño de interfaces"));

			var cursos = Arrays.asList(
				new Curso(1L, "Python", "Lorem",
						 "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/Python-logo-notext.svg/1869px-Python-logo-notext.svg.png",
						 desarrolloWeb),
				new Curso(2L, "Java", "Lorem Ipsum",
						  "https://st3.depositphotos.com/13803186/19300/v/450/depositphotos_193009322-stock-illustration-java-source-trademark-logo-design.jpg",
						   backend),
				new Curso(3L, "HTML", "Lorem Ipsum Dolor",
				  	"https://cdn.worldvectorlogo.com/logos/html-1.svg",
				  	 desarrolloWeb),
				new Curso(4L, "C++", "Lorem",
						  "https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/ISO_C%2B%2B_Logo.svg/1822px-ISO_C%2B%2B_Logo.svg.png",
						   backend),
				new Curso(5L, "CSS", "Lorem",
						  "https://seeklogo.com/images/C/css-3-logo-023C1A7171-seeklogo.com.png",
						  diseñoInterfaces),
				new Curso(6L, "JavaScript", "Lorem dolor",
						  "https://upload.wikimedia.org/wikipedia/commons/6/6a/JavaScript-logo.png",
						   desarrolloWeb),
				new Curso(7L, "Dart", "Lorem Ipsum",
						"https://upload.wikimedia.org/wikipedia/commons/thumb/9/91/Dart-logo-icon.svg/2048px-Dart-logo-icon.svg.png",
						desarrolloMovil),
				new Curso(8L, "Flutter", "Lorem Ipsum",
						"https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2.0,f_auto,g_center,h_1080,q_100,w_1080/v1/gcs/platform-data-goog/events/flutter_I6JGxZE.jpg",
						desarrolloMovil),
						
				new Curso(9L, "Facebook Ads", "Lorem Ipsum",
						"https://www.amocrm.com/static/images/pages/integrations/logo/facebook-ads.png",
						mercadeoDigital),
						
				new Curso(10L, "Facebook Ads", "Lorem Ipsum",
						"https://upload.wikimedia.org/wikipedia/commons/thumb/9/96/Sass_Logo_Color.svg/2560px-Sass_Logo_Color.svg.png",
						frontend),
				new Curso(11L, "Gulp", "Lorem Ipsum",
						"https://miro.medium.com/max/960/1*mI7rlIw_VWsS-r981xXe2w.png",
						frontend),
						
				new Curso(12L, "Npm", "Lorem Ipsum",
						"https://upload.wikimedia.org/wikipedia/commons/thumb/d/db/Npm-logo.svg/540px-Npm-logo.svg.png",
						frontend),
						
				new Curso(12L, "NodeJs", "Lorem Ipsum",
						"https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Node.js_logo.svg/1280px-Node.js_logo.svg.png",
						desarrolloWeb),
				new Curso(12L, "NodeJs", "Lorem Ipsum",
						"https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Node.js_logo.svg/1280px-Node.js_logo.svg.png",
						desarrolloWeb),
				new Curso(13L, "Java", "Lorem Ipsum",
						"https://st3.depositphotos.com/13803186/19300/v/450/depositphotos_193009322-stock-illustration-java-source-trademark-logo-design.jpg",
						 desarrolloMovil),
						 
				new Curso(14L, "Switf", "Lorem Ipsum",
						 "https://assets.stickpng.com/images/58482ce4cef1014c0b5e4a4c.png",
						  desarrolloMovil),
				new Curso(15L, "Kotlin", "Lorem Ipsum",
						  "https://download.logo.wine/logo/Kotlin_(programming_language)/Kotlin_(programming_language)-Logo.wine.png",
						   desarrolloMovil),
				new Curso(15L, "C#", "Lorem Ipsum",
						   "https://upload.wikimedia.org/wikipedia/commons/4/4f/Csharp_Logo.png",
							backend),
				new Curso(16L, "Ruby", "Lorem Ipsum",
							"https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Ruby_logo.svg/1024px-Ruby_logo.svg.png",
							 backend),
				new Curso(17L, "Angular", "Lorem Ipsum",
							 "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cf/Angular_full_color_logo.svg/2048px-Angular_full_color_logo.svg.png",
							  frontend),
							  
				new Curso(18L, "Scala", "Lorem Ipsum",
							  "https://cdn-icons-png.flaticon.com/512/6132/6132220.png",
							   desarrolloWeb),
							   
				new Curso(19L, "Figma", "Lorem Ipsum",
							   "https://cdn-icons-png.flaticon.com/512/6132/6132220.png",
							   diseñoInterfaces),
				new Curso(19L, "Instagram Ads", "Lorem Ipsum",
							   "https://www.beonlinesoluciones.com/wp-content/uploads/2021/02/publicidad-instagram-ads.png",
							   mercadeoDigital)
			);
			cursoRepositorio.saveAll(cursos);
		}	
	}
}

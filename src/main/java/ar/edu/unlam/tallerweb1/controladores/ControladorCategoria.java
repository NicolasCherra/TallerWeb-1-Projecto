package ar.edu.unlam.tallerweb1.controladores;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.CajaDeRegalo;
import ar.edu.unlam.tallerweb1.modelo.Categoria;

@Controller
public class ControladorCategoria {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String mostrarCategoria(Model model) {

		List<Categoria> categorias = obtenerLista();

		model.addAttribute("categorias", categorias);

		return "home";
	}
	
	@RequestMapping(value = "/categorias", method = RequestMethod.GET)
	public ModelAndView mostrarCategoriaSeleccionada() {

		

		return new ModelAndView("home");
	}

	private List<Categoria> obtenerLista() {
		List<Categoria> lista = null;
		try {
			lista = new LinkedList<>();

			Categoria curso = new Categoria();
			curso.setId(1);
			curso.setTipo("Cursos");
			curso.setDescripcion("Los mejores cursos para adquirir habilidades nuevas y únicas");
			curso.setImagen("https://i.postimg.cc/gkcdjjQr/cursos.jpg");

			Categoria entretenimiento = new Categoria();
			entretenimiento.setId(2);
			entretenimiento.setTipo("Entretenimiento");
			entretenimiento.setDescripcion("Todo tipo de actividades con las que seguro te vas a divertir");
			entretenimiento.setImagen("https://i.postimg.cc/Y91kGWtL/restaurant.jpg");

			Categoria relax = new Categoria();
			relax.setId(3);
			relax.setTipo("Relax");
			relax.setDescripcion("Siempre es buen momento para relajarse, elegí uno de los mejores regalos!");
			relax.setImagen("https://i.postimg.cc/VvrpPpD8/spa.jpg");
			
			lista.add(curso);
			lista.add(entretenimiento);
			lista.add(relax);

			return lista;

		} catch (Exception e) {
			System.out.println("Ocurrrió un error inesperado, intente nuevamente");
			return null;
		}
	}
}

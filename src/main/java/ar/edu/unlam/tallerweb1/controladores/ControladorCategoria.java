package ar.edu.unlam.tallerweb1.controladores;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.CajaDeRegalo;
import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCategoria;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

@Controller
public class ControladorCategoria {
	
	private ServicioCategoria servicioCategoria;
	
	@Autowired
	public ControladorCategoria(ServicioCategoria servicioCategoria) {
		this.servicioCategoria = servicioCategoria;
	}


	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String mostrarCategoria(Model model) {

		List<Categoria> categorias = obtenerLista();

		model.addAttribute("categorias", categorias);

		return "home";
	}
//	@RequestMapping(value = "/home", method = RequestMethod.GET)
//	public String mostrarCategoria(Model model) {
//		List<Categoria> categorias = obtenerLista();
//
//		model.addAttribute("categorias", categorias);
//
//		return "home";
//	}
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
			curso.setDescripcion("Los mejores cursos para adquirir habilidades nuevas y �nicas");
			curso.setImagen("https://i.postimg.cc/gkcdjjQr/cursos.jpg");

			Categoria entretenimiento = new Categoria();
			entretenimiento.setId(2);
			entretenimiento.setTipo("Entretenimiento");
			entretenimiento.setDescripcion("Todo tipo de actividades con las que seguro te vas a divertir");
			entretenimiento.setImagen("https://i.postimg.cc/Y91kGWtL/restaurant.jpg");

			Categoria relax = new Categoria();
			relax.setId(3);
			relax.setTipo("Relax");
			relax.setDescripcion("Siempre es buen momento para relajarse, eleg� uno de los mejores regalos!");
			relax.setImagen("https://i.postimg.cc/VvrpPpD8/spa.jpg");
			
			lista.add(curso);
			lista.add(entretenimiento);
			lista.add(relax);

			return lista;

		} catch (Exception e) {
			System.out.println("Ocurrri� un error inesperado, intente nuevamente");
			return null;
		}
	}
	@RequestMapping(value = "/crear-categorias", method = RequestMethod.POST)
	public ModelAndView crearCategoria(@ModelAttribute("categoria") Categoria categoria, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		servicioCategoria.guardarCategoria(categoria);
		return new ModelAndView("redirect:/home");
	}
	
	@RequestMapping(value = "/crear-categorias", method = RequestMethod.GET)
	public ModelAndView vistaCrearCategoria() {
		ModelMap modelo = new ModelMap();
		Categoria categoria = new Categoria();
		modelo.put("usuario", categoria);
		return new ModelAndView("CategoriaCrear", modelo);
	}
}

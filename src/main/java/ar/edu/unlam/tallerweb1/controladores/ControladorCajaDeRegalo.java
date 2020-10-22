package ar.edu.unlam.tallerweb1.controladores;

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
import ar.edu.unlam.tallerweb1.servicios.ServicioCajaDeRegalo;

@Controller
public class ControladorCajaDeRegalo {

	private ServicioCajaDeRegalo servicioCaja;
	
	@Autowired
	public ControladorCajaDeRegalo(ServicioCajaDeRegalo servicioCaja) {
		this.servicioCaja = servicioCaja;
	}
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView mostrarCajas() {
		ModelMap model = new ModelMap();
		List<CajaDeRegalo> cajas = servicioCaja.obtenerLista();
		CajaDeRegalo caja = new CajaDeRegalo();
		model.put("cajas", cajas);
		model.put("CajaDeRegalo", caja);
		
		return new ModelAndView("home",model);
	}
	
	@RequestMapping(value="mostrarCaja", method= RequestMethod.POST)
	public ModelAndView detalleDeCaja(@ModelAttribute("CajaDeRegalo") CajaDeRegalo caja) {
		ModelMap model = new ModelMap();
		Integer numeroCaja = caja.getNumeroDeCaja();
		caja = servicioCaja.buscarCajaPorNumero(numeroCaja);
		model.put("caja", caja);
		
		return new ModelAndView("cajaSeleccionada",model);
	}
	
	@RequestMapping("/regalo-form")
	public String regaloForm(Model model) {
		// creamos la clase Caja De Regalo
		CajaDeRegalo reg = new CajaDeRegalo();
		model.addAttribute("regalo", reg);
		return "regalo-pagina";
	}
	
	@RequestMapping("/submitForm")
	public String submitForm(@ModelAttribute("regalo") CajaDeRegalo reg) {
		return "confirmacion-regalo";
	}
	
	@RequestMapping(value = "/crear-cajaDeRegalo", method = RequestMethod.GET)
	public ModelAndView vistaCrearCategoria() {
		ModelMap modelo = new ModelMap();
		CajaDeRegalo cajaDeRegalo = new CajaDeRegalo();
		modelo.put("cajaDeRegalo", cajaDeRegalo);
		return new ModelAndView("CrearCajaDeRegalo", modelo);
	}
	
	@RequestMapping(value = "/crear-cajaDeRegalo", method = RequestMethod.POST)
	public ModelAndView crearCategoria(@ModelAttribute("cajaDeRegalo") CajaDeRegalo cajaDeRegalo, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		servicioCaja.crearCajaDeRegalo(cajaDeRegalo);
		return new ModelAndView("home",model);
	}
}
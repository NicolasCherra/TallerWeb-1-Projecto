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
import ar.edu.unlam.tallerweb1.modelo.Experiencia;
import ar.edu.unlam.tallerweb1.modelo.Regalo;
import ar.edu.unlam.tallerweb1.modelo.RegaloForm;
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
		List<Experiencia> experiencias = servicioCaja.listarExperiencias(caja.getNumeroDeCaja());
		model.put("caja", caja);
		model.put("experiencias", experiencias);
		model.put("RegaloForm", new RegaloForm());
		
		return new ModelAndView("caja-seleccionada",model);
	}
	

	
	@RequestMapping(value="canjearRegalo", method= RequestMethod.POST)
	public ModelAndView elegirExperiencia(@ModelAttribute("Regalo") Regalo regalo) {
		ModelMap model = new ModelMap();
//		Integer numeroCaja = regalo.getCajaDeRegalo().getNumeroDeCaja();
		Integer numeroCaja = 8;
		CajaDeRegalo caja = servicioCaja.buscarCajaPorNumero(numeroCaja);
		List<Experiencia> experiencias = servicioCaja.listarExperiencias(caja.getNumeroDeCaja());
		
	System.err.println("Size de la lista =>" + experiencias.size());
		model.put("caja", caja);
		model.put("experiencias", experiencias);
	
		
		return new ModelAndView("canjeDelRegalo",model);
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
		return new ModelAndView("crear-caja-regalo", modelo);
	}
	
	@RequestMapping(value = "/crear-cajaDeRegalo", method = RequestMethod.POST)
	public ModelAndView crearCategoria(@ModelAttribute("cajaDeRegalo") CajaDeRegalo cajaDeRegalo, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		servicioCaja.crearCajaDeRegalo(cajaDeRegalo);
		return new ModelAndView("home",model);
	}
}


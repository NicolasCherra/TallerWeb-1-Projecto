package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.CajaDeRegalo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@RequestMapping("/cajaderegalo")
@Controller
public class ControladorCajaDeRegalo {

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
}
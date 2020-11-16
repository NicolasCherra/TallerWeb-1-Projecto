package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.CajaDeRegalo;
import ar.edu.unlam.tallerweb1.modelo.Regalo;
import ar.edu.unlam.tallerweb1.modelo.RegaloForm;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegalo;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorRegalo {

	private ServicioRegalo servicioRegalo;

	@Autowired
	public ControladorRegalo(ServicioRegalo servicioRegalo) {
		this.servicioRegalo = servicioRegalo;
	}

	@RequestMapping(value = "hacerRegalo", method = RequestMethod.POST)
	public ModelAndView regalar(@ModelAttribute("RegaloForm") RegaloForm regaloForm) {
		ModelMap model = new ModelMap();

		Boolean regalado = servicioRegalo.guardarRegalo(regaloForm.getNumeroCajaDeRegalo(), regaloForm.getIdRegalador(),
				regaloForm.getEmail());
		if (!regalado) {
			model.put("error", "No se ha podido enviar el regalo, inténtalo nuevamente");
			return new ModelAndView("pagina-resultado", model);

		} else if (regalado) {
			model.put("ok", "Regalo enviado!");
			return new ModelAndView("pagina-resultado", model);

		} else {
			model.put("error", "Para realizar un regalo primero debes iniciar sesión");
			model.put("boton", "registrarse");
			return new ModelAndView("pagina-resultado", model);
		}
	}
}
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
	private ServicioUsuario servicioUsuario;
	
	@Autowired
	public ControladorRegalo(ServicioRegalo servicioRegalo, ServicioUsuario servicioUsuario) {
		this.servicioRegalo = servicioRegalo;
		this.servicioUsuario = servicioUsuario;
	}

	@RequestMapping(value="hacerRegalo", method= RequestMethod.POST)
	public ModelAndView regalar(@ModelAttribute("RegaloForm") RegaloForm regaloForm) {
		ModelMap model = new ModelMap();
		Boolean usuarioExiste = servicioUsuario.checkUserByEmail(regaloForm.getEmail());
		if(!usuarioExiste) {
			model.put("mensaje", "Usuario no existe");
			return new ModelAndView("redirect:/home", model);
		}
		
		
		Regalo regalo = new Regalo();
		CajaDeRegalo caja = new CajaDeRegalo();
		caja.setNumeroDeCaja(regaloForm.getNumeroCajaDeRegalo());
		regalo.setBeneficiario(servicioUsuario.getUsuarioByEmail(regaloForm.getEmail()));
		regalo.setCajaDeRegalo(caja);
		regalo.setEstado(false);
		regalo.setRegalador(servicioUsuario.getUsuarioById(regaloForm.getIdRegalador()));
		
		servicioRegalo.guardarRegalo(regalo);
		model.put("mensaje", "Regalo enviado!");
		return new ModelAndView("home", model);
	}
}
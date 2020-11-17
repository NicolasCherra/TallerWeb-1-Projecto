package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.ContextLifecycleScheduledTaskRegistrar;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import antlr.StringUtils;
import ar.edu.unlam.tallerweb1.modelo.CajaDeRegalo;
import ar.edu.unlam.tallerweb1.modelo.Regalo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegalo;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorUsuario {

	private ServicioUsuario servicioUsuario;
	private ServicioRegalo servicioRegalo;

	@Autowired
	public ControladorUsuario(ServicioUsuario servicioUsuario, ServicioRegalo servicioRegalo) {
		this.servicioUsuario = servicioUsuario;
		this.servicioRegalo = servicioRegalo;
	}

	@RequestMapping("perfil")
	public ModelAndView irAlPerfil(HttpServletRequest request) {
		if (request.getSession().getAttribute("IDUSUARIO") == null)
			return new ModelAndView("redirect:/registrarse");

		ModelMap model = new ModelMap();
		Usuario usuarioExistente = servicioUsuario
				.getUsuarioPorNombreUsuario(request.getSession().getAttribute("IDUSUARIO").toString());
		model.put("usuario", usuarioExistente);

		List<Regalo> listarRegalosHechos = servicioRegalo.listarRegalosHechosPor(usuarioExistente);
		model.put("lista",listarRegalosHechos);
		model.put("CajaDeRegalo", new CajaDeRegalo());
		model.put("Regalo", new Regalo());

		Long valor = Long.parseLong(request.getSession().getAttribute("IDUSUARIO").toString());
		model.put("usuario", servicioUsuario.getUsuarioById(valor));

		return new ModelAndView("perfil", model);
	}

	
}
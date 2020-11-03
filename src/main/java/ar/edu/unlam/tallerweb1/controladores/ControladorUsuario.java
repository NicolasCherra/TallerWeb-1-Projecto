package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorUsuario {

	private ServicioUsuario servicioUsuario;
	
	@Autowired
	public ControladorUsuario(ServicioUsuario servicioUsuario) {
		this.servicioUsuario = servicioUsuario;
	}

	@RequestMapping("profile")
	public ModelAndView perfilUsuario(@RequestParam("username") String username, HttpServletRequest request) {
		if(request.getSession().getAttribute("IDUSUARIO") == null)
			return new ModelAndView("redirect:/home");
		ModelMap model = new ModelMap();
		Usuario usuarioExistente = servicioUsuario.getUsuarioPorNombreUsuario(username);
		model.put("usuario", usuarioExistente);
		return new ModelAndView("user-profile", model);
		
	}
}
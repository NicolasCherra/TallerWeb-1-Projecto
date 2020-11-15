package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorLogin {

	private ServicioLogin servicioLogin;
	private ServicioUsuario servicioUsuario;

	@Autowired
	public ControladorLogin(ServicioLogin servicioLogin, ServicioUsuario servicioUsuario) {
		this.servicioLogin = servicioLogin;
		this.servicioUsuario = servicioUsuario;
	}

	@RequestMapping("/entrar")
	public ModelAndView irALogin() {
		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		return new ModelAndView("login", modelo);
	}

	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		Usuario usuarioBuscado = servicioLogin.consultarUsuario(usuario);
		if (usuarioBuscado != null) {
			request.getSession().setAttribute("USERNAME", usuarioBuscado.getNombreUsuario());
			request.getSession().setAttribute("IDUSUARIO", usuarioBuscado.getId());
			return new ModelAndView("redirect:/home");
		} else {
			model.put("error", "Usuario o clave incorrecta");
		}
		return new ModelAndView("login", model);
	}

	private Boolean buscarUsuarioPorEmail(Usuario usuario) {
		Usuario usuarioBuscado = servicioLogin.buscarUsuarioPorEmail(usuario);
		if (usuarioBuscado != null) {
			return true;
		}
		return false;
	}

	@RequestMapping(path = "/home1", method = RequestMethod.GET)
	public ModelAndView irAHome() {
		return new ModelAndView("home");
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/home");
	}

	@RequestMapping(path = "/registrarse", method = RequestMethod.GET)
	public ModelAndView irARegistrarse() {
		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		return new ModelAndView("registrarse", modelo);
	}

	@RequestMapping(path = "/validar-registro", method = RequestMethod.POST)
	public ModelAndView validarRegistro(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		Boolean encontrado = buscarUsuarioPorEmail(usuario);
		Boolean usuarioExistente = servicioLogin.buscarUsuarioPorNombreUsuario(usuario);
		Boolean valorNull = servicioLogin.verificarSiValoresNulos(usuario);

		if (encontrado) {
			model.put("error", "* Ya existe un usuario con ese email");
			return new ModelAndView("registrarse", model);

		} else if (usuarioExistente) {
			model.put("error", "* El nombre de usuario ya existe");
			return new ModelAndView("registrarse", model);

		} else if (valorNull) {
			model.put("error", "* Debe completar todos los campos");
			return new ModelAndView("registrarse", model);
		}

		else {
			usuario.setIp(request.getRemoteAddr());
			if (servicioLogin.guardarUsuario(usuario))
				return new ModelAndView("redirect:/login");

			model.put("error", "No se pudo guardar el registro*");
			return new ModelAndView("registrarse", model);
		}

	}

	@RequestMapping("logout")
	public ModelAndView cerrarSesion(HttpServletRequest request) {
		request.getSession().invalidate();
		return new ModelAndView("redirect:/home");
	}
}
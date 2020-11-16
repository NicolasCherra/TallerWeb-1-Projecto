package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.CajaDeRegalo;
import ar.edu.unlam.tallerweb1.modelo.Regalo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegalo;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

@Service
@Transactional
public class ServicioRegaloImpl implements ServicioRegalo {

	private RepositorioRegalo servicioRegaloDAO;
	private RepositorioUsuario servicioUsuarioDAO;

	@Autowired
	public ServicioRegaloImpl(RepositorioRegalo servicioRegaloDAO, RepositorioUsuario servicioUsuarioDAO) {
		this.servicioRegaloDAO = servicioRegaloDAO;
		this.servicioUsuarioDAO = servicioUsuarioDAO;
	}

	@Override
	public Boolean guardarRegalo(Integer cajaDeRegalo, Long idRegalador, String emailDetino) {
		Boolean usuarioExiste = servicioUsuarioDAO.checkUserByEmail(emailDetino);
		if (!usuarioExiste) {
			return false;
		}

		Regalo regalo = new Regalo();
		CajaDeRegalo caja = new CajaDeRegalo();
		caja.setNumeroDeCaja(cajaDeRegalo);
		regalo.setBeneficiario(servicioUsuarioDAO.getUserByEmail(emailDetino));
		regalo.setCajaDeRegalo(caja);
		regalo.setRegalador(servicioUsuarioDAO.getUserById(idRegalador));

		return servicioRegaloDAO.guardarRegalo(regalo);
	}

	@Override
	public List<Regalo> listarRegalosHechosPor(Usuario usuario) {
		return servicioRegaloDAO.listarRegalosHechosPor(usuario);
	}
}

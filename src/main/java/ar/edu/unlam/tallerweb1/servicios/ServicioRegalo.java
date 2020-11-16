package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Regalo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioRegalo {
	Boolean guardarRegalo(Integer cajaDeRegalo, Long idRegalador, String emailDetino);

	List<Regalo> listarRegalosHechosPor(Usuario usuario);
}

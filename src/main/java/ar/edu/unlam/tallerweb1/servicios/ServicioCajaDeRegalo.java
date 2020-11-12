package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import java.util.Set;

import ar.edu.unlam.tallerweb1.modelo.CajaDeRegalo;
import ar.edu.unlam.tallerweb1.modelo.Experiencia;

public interface ServicioCajaDeRegalo {
	List<CajaDeRegalo> obtenerLista();
	CajaDeRegalo buscarCajaPorNumero(Integer numeroCaja);
	Boolean crearCajaDeRegalo(CajaDeRegalo cajaDeRegalo);
	List<Experiencia> listarExperiencias(Integer numeroDeCaja);
}

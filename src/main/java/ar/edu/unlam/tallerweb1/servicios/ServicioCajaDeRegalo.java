package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.CajaDeRegalo;

public interface ServicioCajaDeRegalo {
	List<CajaDeRegalo> obtenerLista();
	CajaDeRegalo buscarCajaPorNumero(Integer numeroCaja);
	Boolean crearCajaDeRegalo(CajaDeRegalo cajaDeRegalo);
}

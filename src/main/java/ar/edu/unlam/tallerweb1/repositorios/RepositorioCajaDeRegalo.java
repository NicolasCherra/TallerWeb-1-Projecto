package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.CajaDeRegalo;

public interface RepositorioCajaDeRegalo {
	List<CajaDeRegalo> obtenerLista();
	CajaDeRegalo buscarCajaPorNumero(Integer numeroCaja);	
	Boolean crearCajaDeRegalo(CajaDeRegalo cajaDeRegalo);
}

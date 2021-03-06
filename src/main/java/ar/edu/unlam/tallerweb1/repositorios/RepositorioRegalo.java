package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;
import java.util.Set;

import ar.edu.unlam.tallerweb1.modelo.CajaDeRegalo;
import ar.edu.unlam.tallerweb1.modelo.Experiencia;
import ar.edu.unlam.tallerweb1.modelo.Regalo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioRegalo {
	Boolean guardarRegalo(Regalo regalo);
	List<Regalo> listarRegalosHechosPor(Usuario usuario);
} 

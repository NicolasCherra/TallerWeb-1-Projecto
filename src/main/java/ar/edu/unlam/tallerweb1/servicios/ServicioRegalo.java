package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Regalo;


public interface ServicioRegalo {

	Boolean guardarRegalo(Regalo regalo);

	
	
}

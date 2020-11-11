package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Regalo;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioRegalo;

@Service
@Transactional
public class ServicioRegaloImpl implements ServicioRegalo {

	private RepositorioRegalo servicioRegaloDAO;
	
	@Autowired
	public ServicioRegaloImpl(RepositorioRegalo servicioRegaloDAO){
		this.servicioRegaloDAO = servicioRegaloDAO;
	}
	
	
	@Override
	public Boolean guardarRegalo(Regalo regalo) {
		// TODO Auto-generated method stub
		return servicioRegaloDAO.guardarRegalo(regalo);
	}

}

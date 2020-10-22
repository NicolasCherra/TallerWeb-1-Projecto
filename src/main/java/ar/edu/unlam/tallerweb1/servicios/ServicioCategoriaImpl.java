package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCategoria;

@Service("servicioCategoria")
@Transactional
public class ServicioCategoriaImpl implements ServicioCategoria {
	
	private RepositorioCategoria servicioCategoriaDao;

	@Autowired
	public ServicioCategoriaImpl(RepositorioCategoria servicioCategoriaDao){
		this.servicioCategoriaDao = servicioCategoriaDao;
	}
	@Override
	public Categoria buscarTipoCategoria(String tipo) {
		return servicioCategoriaDao.buscarTipoCategoria(tipo);
	}

	@Override
	public Categoria buscarCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return servicioCategoriaDao.buscarCategoria(categoria);
	}

	@Override
	public Boolean guardarCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return servicioCategoriaDao.guardarCategoria(categoria);
	}

	@Override
	public Boolean borrarCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return servicioCategoriaDao.borrarCategoria(categoria);
	}

	@Override
	public Boolean modificarCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return servicioCategoriaDao.modificarCategoria(categoria);
	}

}

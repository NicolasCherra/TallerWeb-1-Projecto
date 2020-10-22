package ar.edu.unlam.tallerweb1.repositorios;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Categoria;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository("repositorioCategoria")
public class RepositorioCategoriaImpl implements RepositorioCategoria {

	
	private SessionFactory sessionFactory;
	
    @Autowired
	public RepositorioCategoriaImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Categoria buscarTipoCategoria(String tipo) {
		final Session session = sessionFactory.getCurrentSession();
		return (Categoria) session.createCriteria(Categoria.class)				
				.add(Restrictions.eq("tipo", tipo));
	}

	@Override
	public Categoria buscarCategoria(Categoria categoria) {
		final Session session = sessionFactory.getCurrentSession();
		return (Categoria) session.createCriteria(Usuario.class)				
				.add(Restrictions.eq("Id", categoria.getId()))				
				.uniqueResult();
	}

	@Override
	public Boolean guardarCategoria(Categoria categoria) {
		final Session session = sessionFactory.getCurrentSession();
		try {
			session.save(categoria);
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}				
	}

	@Override
	public Boolean borrarCategoria(Categoria categoria) {
		final Session session = sessionFactory.getCurrentSession();
		try {
			session.delete(categoria);
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public Boolean modificarCategoria(Categoria categoria) {
		final Session session = sessionFactory.getCurrentSession();
		try {
			session.update(categoria);
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}

}

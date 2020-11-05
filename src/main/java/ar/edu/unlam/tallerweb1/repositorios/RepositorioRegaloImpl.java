package ar.edu.unlam.tallerweb1.repositorios;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Regalo;

@Repository("repositorioRegalo")
public class RepositorioRegaloImpl implements RepositorioRegalo {

	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioRegaloImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Boolean guardarRegalo(Regalo regalo) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(regalo);
		Regalo regaloCreado = getRegaloById(regalo.getId());
		return regaloCreado != null;
	}

	private Regalo getRegaloById(Integer id) {
		final Session session = sessionFactory.getCurrentSession();
		return session.get(Regalo.class, id);
	}

}

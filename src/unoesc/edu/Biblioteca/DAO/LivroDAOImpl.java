package unoesc.edu.Biblioteca.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import unoesc.edu.Biblioteca.model.Livro;


@Service(value="LivroDAO")
public class LivroDAOImpl implements LivroDAO {
	
	@Autowired
	SessionFactory sessionFactory;


	@Override
	@Transactional
	public List<Livro> getallLivros() {
		Session session = sessionFactory.getCurrentSession();
		List<Livro> listaLivros = session.createQuery("FROM Livro").list();
		return listaLivros;
	}

	@Override
	@Transactional
	public Livro getLivroById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Livro c = session.get(Livro.class, id);
		return c;
	}

	@Override
	@Transactional
	public void insertLivro(Livro user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		
	}

	@Override
	@Transactional
	public boolean updateLivro(Livro user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
		return true;
	
	}


	@Override
	@Transactional
	public boolean deleteLivro(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Livro p = (Livro) session.load(Livro.class, id);
		if (p!=null) {
			session.delete(p);
			return true;
		}
		return false;
		
	}

	

	
	

}

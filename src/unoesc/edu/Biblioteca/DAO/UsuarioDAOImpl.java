package unoesc.edu.Biblioteca.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import unoesc.edu.Biblioteca.model.Usuario;



@Repository
public class UsuarioDAOImpl implements UsuarioDAO {
	
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	@Transactional
	public List<Usuario> getallUsuarios() {
		Session session = sessionFactory.getCurrentSession();
		List<Usuario> listaUsuarios = session.createQuery("FROM Usuario").list();
		return listaUsuarios;
	}

	@Override
	@Transactional
	public Usuario getUsuarioById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Usuario c = session.get(Usuario.class, id);
		return c;
	}

	@Override
	@Transactional
	public void insertUsuario(Usuario user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		
	}

	@Override
	@Transactional
	public boolean updateUsuario(Usuario user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
		return true;
	
	}


	@Override
	@Transactional
	public boolean deleteUsuario(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Usuario p = (Usuario) session.load(Usuario.class, id);
		if (p!=null) {
			session.delete(p);
			return true;
		}
		return false;
		
	}


	
	

}

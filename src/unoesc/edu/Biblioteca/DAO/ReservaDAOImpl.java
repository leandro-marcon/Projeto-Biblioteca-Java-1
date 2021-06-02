package unoesc.edu.Biblioteca.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import unoesc.edu.Biblioteca.model.Livro;
import unoesc.edu.Biblioteca.model.Reserva;
import unoesc.edu.Biblioteca.model.Usuario;



@Service(value="ReservaDAO")
public class ReservaDAOImpl implements ReservaDAO {
	
	@Autowired
	SessionFactory sessionFactory;


	@Override
	@Transactional
	public List<Reserva> getallReservas() {
		Session session = sessionFactory.getCurrentSession();
		List<Reserva> listaReservas = session.createQuery("FROM Reserva").list();
		return listaReservas;
	}
	


	@Override
	@Transactional
	public Reserva getReservaById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Reserva c = session.get(Reserva.class, id);
		return c;
	}

	@Override
	@Transactional
	public void insertReserva(Reserva user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		
	}

	@Override
	@Transactional
	public boolean updateReserva(Reserva user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
		return true;
	
	}


	@Override
	@Transactional
	public boolean deleteReserva(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Reserva p = (Reserva) session.load(Reserva.class, id);
		if (p!=null) {
			session.delete(p);
			return true;
		}
		return false;

}
	
	
}

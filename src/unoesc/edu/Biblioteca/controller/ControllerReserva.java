package unoesc.edu.Biblioteca.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import unoesc.edu.Biblioteca.DAO.ReservaDAO;
import unoesc.edu.Biblioteca.DAO.UsuarioDAO;
import unoesc.edu.Biblioteca.model.Reserva;
import unoesc.edu.Biblioteca.model.Usuario;


@ManagedBean(name="reserva")
@RequestScoped
public class ControllerReserva {

	private List<Reserva> listaReservas;
	private List<Usuario> listaUsuarios;
	
	private Reserva user = new Reserva();
	
	@ManagedProperty(value="#{ReservaDAO}")
	private ReservaDAO reservaDao;
	
	@ManagedProperty(value="#{UsuarioDAO}")
	private UsuarioDAO usuarioDao;


	
	public void save() {
		
		if (user.getCodigoReserva() == 0) {
			this.reservaDao.insertReserva(user);
			System.out.println("Salvou Reserva");
		} else {
			this.reservaDao.updateReserva(user);

		}
		
		this.user = new Reserva();

	}
	
	public void edit(int id) {
		List<Reserva> listaReservas = this.reservaDao.getallReservas();
	
		user = this.reservaDao.getReservaById(id); //Buscar o cara a ser editado

	}
	
	
	public void delete(int id) {
		
		this.reservaDao.deleteReserva(id);
	
		System.out.println("Removeu");
		
		
		
	}
	
	

	public List<Reserva> getListaReservas() {
		return this.reservaDao.getallReservas();
	}

	public void setListaReservas(List<Reserva> listaReservas) {
		this.listaReservas = listaReservas;
	}
	
	
	
	

	public List<Usuario> getListaUsuarios() {
		return this.usuarioDao.getallUsuarios();
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public UsuarioDAO getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public Reserva getUser() {
		return user;
	}

	public void setUser(Reserva user) {
		this.user = user;
	}

	public ReservaDAO getReservaDao() {
		return reservaDao;
	}

	public void setReservaDao(ReservaDAO ReservaDao) {
		this.reservaDao = ReservaDao;
	}

	
}

package unoesc.edu.Biblioteca.controller;

import java.io.IOException;

import java.lang.management.MemoryType;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.jdi.Method;

import unoesc.edu.Biblioteca.DAO.LivroDAO;
import unoesc.edu.Biblioteca.DAO.UsuarioDAO;
import unoesc.edu.Biblioteca.model.Livro;
import unoesc.edu.Biblioteca.model.Usuario;


@ManagedBean(name="usuario")
@RequestScoped
public class ControllerUsuario {

	private List<Usuario> listaUsuarios;
	private Usuario user = new Usuario();
	
	@ManagedProperty(value="#{UsuarioDAO}")
	private UsuarioDAO usuarioDao;

	
	public void save() {

		if (user.getCodigoUser() == 0) {
			this.usuarioDao.insertUsuario(user);
			System.out.println("Salvou Cliente");
		} else {
			this.usuarioDao.updateUsuario(user);

		}
		

	}
	
	public void edit(int id) {
		List<Usuario> listaUsuarios = this.usuarioDao.getallUsuarios();
	
		user = this.usuarioDao.getUsuarioById(id); //Buscar o cara a ser editado

	}
	
	
	public void delete(int id) {
		
		this.usuarioDao.deleteUsuario(id);
	
		System.out.println("Removeu");
		
		
		
	}

	public List<Usuario> getListaUsuarios() {
		return this.usuarioDao.getallUsuarios();
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public UsuarioDAO getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	
}

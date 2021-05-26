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



import unoesc.edu.Biblioteca.DAO.LivroDAO;
import unoesc.edu.Biblioteca.model.Livro;




@ManagedBean(name="livro")
@RequestScoped
public class ControllerLivro {

	private List<Livro> listaLivros;
	private Livro user = new Livro();
	
	@ManagedProperty(value="#{LivroDAO}")
	private LivroDAO livroDao;


	
	public void save() {

		if (user.getCodigoLivro() == 0) {
			this.livroDao.insertLivro(user);
			System.out.println("Salvou Cliente");
		} else {
			this.livroDao.updateLivro(user);

		}
		
		this.user = new Livro();
		

	}
	
	public void edit (int id){
		List<Livro> listaLivros = this.livroDao.getallLivros();
	
		user = this.livroDao.getLivroById(id); //Buscar o cara a ser editado
	
		
	}
	
	
	public void delete(int id) {
		
		this.livroDao.deleteLivro(id);
	
		System.out.println("Removeu");
		
		
		
	}



	public List<Livro> getListaLivros() {
		return this.livroDao.getallLivros();
	}

	public void setListaLivros(List<Livro> listaLivros) {
		this.listaLivros = listaLivros;
	}

	public Livro getUser() {
		return user;
	}

	public void setUser(Livro user) {
		this.user = user;
	}

	public LivroDAO getLivroDao() {
		return livroDao;
	}

	public void setLivroDao(LivroDAO livroDao) {
		this.livroDao = livroDao;
	}
	
	
	

}

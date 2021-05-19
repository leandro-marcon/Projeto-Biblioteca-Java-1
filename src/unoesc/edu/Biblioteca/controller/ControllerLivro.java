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

	private List<Livro> listLivros;
	private Livro cli = new Livro();
	
	@ManagedProperty(value="#{LivroDAO}")
	private LivroDAO livroDao;


	@RequestMapping(path = "livroSave", method = RequestMethod.POST)
	public String LivroSave(@ModelAttribute("Livro") Livro user, HttpSession session, Model model) {
		List listaLivros = (LinkedList<Livro>) session.getAttribute("listaLivro");

		if (user.getCodigoLivro() == 0) {
			this.livroDao.insertLivro(user);
			System.out.println("Salvou Cliente");
		} else {
			this.livroDao.updateLivro(user);

		}
		
		return "redirect:/livro";

	}
	
//	@RequestMapping(path = "livroEdit/{id}", method = RequestMethod.GET)
//	public String edit(@PathVariable int id, Model model, HttpSession session) {
//		List listaLivros = (LinkedList<Livro>) session.getAttribute("listaLivro");
//	
//		Livro c = this.LivroDao.getLivroById(id); //Buscar o cara a ser editado
//		model.addAttribute("listaLivro", listaLivros);
//		model.addAttribute("livro", c);
//		
//		
//		return "livroCrud";
//		
//	}
//	
//	
//	@RequestMapping(path = "livroDelete/{id}", method = RequestMethod.GET)
//	public String delete( @PathVariable int id, Model model, HttpSession session) {
//		
//		this.LivroDao.deleteLivro(id);
//	
//		System.out.println("Removeu");
//		
//		return "redirect:/livro";
//		
//	}

}

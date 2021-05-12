package unoesc.edu.Biblioteca.controller;

import java.io.IOException;

import java.lang.management.MemoryType;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

import unoesc.edu.Biblioteca.DAO.UsuarioDAO;
import unoesc.edu.Biblioteca.model.Usuario;


@Controller
public class ControllerUsuario {

	@Autowired
	private UsuarioDAO usuarioDao;

	@RequestMapping(path = "/usuario", method = RequestMethod.GET)
	public String acessoUsuario(Model model, HttpSession session) {
		System.out.println("Chamou usuário");

		List<Usuario> listaUsuarios = this.usuarioDao.getallUsuarios();

		model.addAttribute("listaUsuarios", listaUsuarios);
		model.addAttribute("usuario", new Usuario());

		return "usuarioCrud";
	}

	@RequestMapping(path = "usuarioSave", method = RequestMethod.POST)
	public String usuarioSave(@ModelAttribute("usuario") Usuario user, HttpSession session, Model model) {
		List listaUsuario = (LinkedList<Usuario>) session.getAttribute("listaUsuario");

		if (user.getCodigoUser() == 0) {
			this.usuarioDao.insertUsuario(user);
			System.out.println("Salvou Cliente");
		} else {
			this.usuarioDao.updateUsuario(user);

		}
		
		return "redirect:/usuario";

	}
	
	@RequestMapping(path = "usuarioEdit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable int id, Model model, HttpSession session) {
		List listaUsuario = (LinkedList<Usuario>) session.getAttribute("listaUsuario");
	
		Usuario c = this.usuarioDao.getUsuarioById(id); //Buscar o cara a ser editado
		model.addAttribute("listaUsuario", listaUsuario);
		model.addAttribute("usuario", c);
		
		
		return "usuarioCrud";
		
	}
	
	
	@RequestMapping(path = "usuarioDelete/{id}", method = RequestMethod.GET)
	public String delete( @PathVariable int id, Model model, HttpSession session) {
		
		this.usuarioDao.deleteUsuario(id);
	
		System.out.println("Removeu");
		
		return "redirect:/usuario";
		
	}

}

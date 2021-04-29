package unoesc.edu.Biblioteca.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import unoesc.edu.Biblioteca.model.Usuario;

@Controller
public class ControllerUsuario {
	
	@RequestMapping(path =  "/usuario", method = RequestMethod.GET)
	public String acessoUsuario(Model model, HttpSession session) {
		System.out.println("Chamou usuário");
		
		List<Usuario> listaUsuarios;
		
		if (session.getAttribute("listaUsuarios") == null) {
			listaUsuarios = new LinkedList<Usuario>();
			session.setAttribute("listaUsuarios", listaUsuarios);
		} 
		else 
			listaUsuarios = (LinkedList) session.getAttribute("listaUsuarios");
			
			model.addAttribute("listaUsuarios", listaUsuarios);
			model.addAttribute("usuario", new Usuario(0, null, null));
		
		
		
		return "usuarioCrud";
	}
	

}

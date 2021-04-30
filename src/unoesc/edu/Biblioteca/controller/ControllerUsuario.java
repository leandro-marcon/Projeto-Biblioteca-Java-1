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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.jdi.Method;

import unoesc.edu.Biblioteca.model.Usuario;

@Controller
public class ControllerUsuario {

	@RequestMapping(path = "/usuario", method = RequestMethod.GET)
	public String acessoUsuario(Model model, HttpSession session) {
		System.out.println("Chamou usuário");

		List<Usuario> listaUsuarios;

		if (session.getAttribute("listaUsuarios") == null) {
			listaUsuarios = new LinkedList<Usuario>();
			session.setAttribute("listaUsuarios", listaUsuarios);
		} else
			listaUsuarios = (LinkedList) session.getAttribute("listaUsuarios");

		model.addAttribute("listaUsuarios", listaUsuarios);
		model.addAttribute("usuario", new Usuario());

		return "usuarioCrud";
	}

	@RequestMapping(path = "usuarioSave", method = RequestMethod.POST)
	public String usuarioSave(@ModelAttribute("usuario") Usuario user, HttpSession session, Model model) {
		List listaUsuario = (LinkedList<Usuario>) session.getAttribute("listaUsuario");

//		if (user.getCodigoUser() == 0) {
	
			listaUsuario.add(user);
			user.setCodigoUser(listaUsuario.size());
			System.out.println("Salvou Usuário");
//		} else {
//			Usuario c = (Usuario) listaUsuario.get(user.getCodigoUser() - 1);
//			c.setCodigoUser(user.getCodigoUser());
//			c.setNome(user.getNome());
//			System.out.println("pegou o usuario");
//		}
		
		return "redirect:/usuario";

	}

}
